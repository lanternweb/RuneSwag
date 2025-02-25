/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.mixins;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import api.HeadIcon;
import api.Model;
import api.Perspective;
import api.Point;
import api.SkullIcon;
import api.coords.LocalPoint;
import api.model.Triangle;
import api.model.Vertex;
import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import rs.api.RSClient;
import rs.api.RSModel;
import rs.api.RSName;
import rs.api.RSPlayer;

import static api.HeadIcon.MAGIC;
import static api.HeadIcon.MELEE;
import static api.HeadIcon.RANGED;
import static api.HeadIcon.REDEMPTION;
import static api.HeadIcon.RETRIBUTION;
import static api.HeadIcon.SMITE;
import static api.SkullIcon.DEAD_MAN_FIVE;
import static api.SkullIcon.DEAD_MAN_FOUR;
import static api.SkullIcon.DEAD_MAN_ONE;
import static api.SkullIcon.DEAD_MAN_THREE;
import static api.SkullIcon.DEAD_MAN_TWO;
import static api.SkullIcon.SKULL;
import static api.SkullIcon.SKULL_FIGHT_PIT;

@Mixin(RSPlayer.class)
public abstract class RSPlayerMixin implements RSPlayer
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public String getName()
	{
		final RSName rsName = getRsName();

		if (rsName == null)
		{
			return null;
		}

		String name = rsName.getName();

		if (name == null)
		{
			return null;
		}

		return name.replace('\u00A0', ' ');
	}

	@Inject
	@Override
	public HeadIcon getOverheadIcon()
	{
		switch (getRsOverheadIcon())
		{
			case 0:
				return MELEE;
			case 1:
				return RANGED;
			case 2:
				return MAGIC;
			case 3:
				return RETRIBUTION;
			case 4:
				return SMITE;
			case 5:
				return REDEMPTION;
			default:
				return null;
		}
	}

	@Inject
	@Override
	public SkullIcon getSkullIcon()
	{
		if (this != client.getLocalPlayer())
		{
			// prevent seeing skulls of other players.
			return null;
		}

		switch (getRsSkullIcon())
		{
			case 0:
				return SKULL;
			case 1:
				return SKULL_FIGHT_PIT;
			case 8:
				return DEAD_MAN_FIVE;
			case 9:
				return DEAD_MAN_FOUR;
			case 10:
				return DEAD_MAN_THREE;
			case 11:
				return DEAD_MAN_TWO;
			case 12:
				return DEAD_MAN_ONE;
			default:
				return null;
		}
	}

	@Inject
	@Override
	public Polygon[] getPolygons()
	{
		Model model = getModel();

		if (model == null)
		{
			return null;
		}

		int localX = getX();
		int localY = getY();

		int orientation = getOrientation();

		final int tileHeight = Perspective.getTileHeight(client, new LocalPoint(localX, localY), client.getPlane());

		List<Triangle> triangles = model.getTriangles();

		triangles = rotate(triangles, orientation);

		List<Polygon> polys = new ArrayList<Polygon>();
		for (Triangle triangle : triangles)
		{
			Vertex vx = triangle.getA();
			Vertex vy = triangle.getB();
			Vertex vz = triangle.getC();

			Point x = Perspective.localToCanvas(client,
					localX - vx.getX(),
					localY - vx.getZ(),
					tileHeight + vx.getY());

			Point y = Perspective.localToCanvas(client,
					localX - vy.getX(),
					localY - vy.getZ(),
					tileHeight + vy.getY());

			Point z = Perspective.localToCanvas(client,
					localX - vz.getX(),
					localY - vz.getZ(),
					tileHeight + vz.getY());

			int[] xx =
					{
							x.getX(), y.getX(), z.getX()
					};
			int[] yy =
					{
							x.getY(), y.getY(), z.getY()
					};
			polys.add(new Polygon(xx, yy, 3));
		}

		return polys.toArray(new Polygon[polys.size()]);
	}

	@Inject
	@Override
	public Polygon getConvexHull()
	{
		RSModel model = getModel();
		if (model == null)
		{
			return null;
		}

		int tileHeight = Perspective.getTileHeight(client, new LocalPoint(getX(), getY()), client.getPlane());
		return model.getConvexHull(getX(), getY(), getOrientation(), tileHeight);
	}

	@Inject
	private List<Triangle> rotate(List<Triangle> triangles, int orientation)
	{
		List<Triangle> rotatedTriangles = new ArrayList<Triangle>();
		for (Triangle triangle : triangles)
		{
			Vertex a = triangle.getA();
			Vertex b = triangle.getB();
			Vertex c = triangle.getC();

			Triangle rotatedTriangle = new Triangle(
					a.rotate(orientation),
					b.rotate(orientation),
					c.rotate(orientation)
			);
			rotatedTriangles.add(rotatedTriangle);
		}
		return rotatedTriangles;
	}

	@Copy("getModel")
	public abstract RSModel rs$getModel();

	@Replace("getModel")
	public RSModel rl$getModel()
	{
		if (!client.isInterpolatePlayerAnimations())
		{
			return rs$getModel();
		}
		int actionFrame = getActionFrame();
		int poseFrame = getPoseFrame();
		int spotAnimFrame = getSpotAnimFrame();
		try
		{
			// combine the frames with the frame cycle so we can access this information in the sequence methods
			// without having to change method calls
			setActionFrame(Integer.MIN_VALUE | getActionFrameCycle() << 16 | actionFrame);
			setPoseFrame(Integer.MIN_VALUE | getPoseFrameCycle() << 16 | poseFrame);
			setSpotAnimFrame(Integer.MIN_VALUE | getSpotAnimFrameCycle() << 16 | spotAnimFrame);
			return rs$getModel();
		}
		finally
		{
			// reset frames
			setActionFrame(actionFrame);
			setPoseFrame(poseFrame);
			setSpotAnimFrame(spotAnimFrame);
		}
	}
}
