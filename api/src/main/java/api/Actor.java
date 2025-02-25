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
package api;

import api.coords.LocalPoint;
import api.coords.WorldPoint;

import javax.annotation.Nullable;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Represents a RuneScape actor/entity.
 */
public interface Actor extends Renderable
{
	/**
	 * Gets the combat level of the actor.
	 *
	 * @return the combat level
	 */
	int getCombatLevel();

	/**
	 * Gets the name of the actor.
	 *
	 * @return the name
	 */
	String getName();


	LocalPoint getLocalLocation();

	Polygon getCanvasTilePoly();

	@Nullable
	Point getCanvasTextLocation(Graphics2D graphics, String text, int zOffset);

	int getLogicalHeight();

	Point getCanvasImageLocation(BufferedImage image, int zOffset);

	Polygon getConvexHull();

	WorldPoint getWorldLocation();

	void setActionFrame(int actionFrame);

	void setSpotAnimFrame(int spotAnimFrame);

	int getOrientation();
}
