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
package com.runeswag.client.ui;

import api.Actor;
import api.Client;
import api.Perspective;
import api.TileObject;
import api.coords.LocalPoint;
import com.google.common.base.Strings;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;


/**
 * Created by Kyle Fricilone on Jun 09, 2017.
 */
public class OverlayUtil
{
	private static final int MINIMAP_DOT_RADIUS = 4;
	private static final double UNIT = Math.PI / 1024.0d;

	public static void renderPolygon(Graphics2D graphics, Polygon poly, Color color)
	{
		graphics.setColor(color);
		final Stroke originalStroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(2));
		graphics.drawPolygon(poly);
		graphics.setColor(new Color(0, 0, 0, 50));
		graphics.fillPolygon(poly);
		graphics.setStroke(originalStroke);
	}

	public static void renderMinimapLocation(Graphics2D graphics, api.Point mini, Color color)
	{
		graphics.setColor(Color.BLACK);
		graphics.fillOval((int)mini.getX() - MINIMAP_DOT_RADIUS / 2, (int)mini.getY() - MINIMAP_DOT_RADIUS / 2 + 1, MINIMAP_DOT_RADIUS, MINIMAP_DOT_RADIUS);
		graphics.setColor(color);
		graphics.fillOval((int)mini.getX() - MINIMAP_DOT_RADIUS / 2, (int)mini.getY() - MINIMAP_DOT_RADIUS / 2, MINIMAP_DOT_RADIUS, MINIMAP_DOT_RADIUS);
	}

	public static void renderMinimapRect(Client client, Graphics2D graphics, Point center, int width, int height, Color color)
	{
		double angle = client.getMapAngle() * UNIT;

		graphics.setColor(color);
		graphics.rotate(angle, center.getX(), center.getY());
		graphics.drawRect((int)center.getX() - width / 2, (int)center.getY() - height / 2, width, height);
		graphics.rotate(-angle, center.getX(), center.getY());
	}

	public static void renderTextLocation(Graphics2D graphics, api.Point txtLoc, String text, Color color)
	{
		if (Strings.isNullOrEmpty(text))
		{
			return;
		}

		int x = (int)txtLoc.getX();
		int y = (int)txtLoc.getY();

		graphics.setColor(Color.BLACK);
		graphics.drawString(text, x + 1, y + 1);

		graphics.setColor(color);
		graphics.drawString(text, x, y);
	}

	public static void renderImageLocation(Client client, Graphics2D graphics, LocalPoint localPoint, BufferedImage image, int zOffset)
	{
		api.Point imageLocation = Perspective.getCanvasImageLocation(client, localPoint, image, zOffset);
		if (imageLocation != null)
		{
			renderImageLocation(graphics, imageLocation, image);
		}
	}

	public static void renderImageLocation(Graphics2D graphics, api.Point imgLoc, BufferedImage image)
	{
		int x = (int)imgLoc.getX();
		int y = (int)imgLoc.getY();

		graphics.drawImage(image, x, y, null);
	}

	public static void renderActorOverlay(Graphics2D graphics, Actor actor, String text, Color color)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		api.Point textLocation = actor.getCanvasTextLocation(graphics, text, actor.getLogicalHeight() + 40);
		if (textLocation != null)
		{
			renderTextLocation(graphics, textLocation, text, color);
		}
	}

	public static void renderActorOverlayImage(Graphics2D graphics, Actor actor, BufferedImage image, Color color, int zOffset)
	{
		Polygon poly = actor.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		api.Point imageLocation = actor.getCanvasImageLocation(image, zOffset);
		if (imageLocation != null)
		{
			renderImageLocation(graphics, imageLocation, image);
		}
	}

	public static void renderTileOverlay(Graphics2D graphics, TileObject tileObject, String text, Color color)
	{
		Polygon poly = tileObject.getCanvasTilePoly();
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		api.Point minimapLocation = tileObject.getMinimapLocation();
		if (minimapLocation != null)
		{
			renderMinimapLocation(graphics, minimapLocation, color);
		}

		api.Point textLocation = tileObject.getCanvasTextLocation(graphics, text, 0);
		if (textLocation != null)
		{
			renderTextLocation(graphics, textLocation, text, color);
		}
	}

	public static void renderTileOverlay(Client client, Graphics2D graphics, LocalPoint localLocation, BufferedImage image, Color color)
	{
		Polygon poly = Perspective.getCanvasTilePoly(client, localLocation);
		if (poly != null)
		{
			renderPolygon(graphics, poly, color);
		}

		renderImageLocation(client, graphics, localLocation, image, 0);
	}

	public static void renderHoverableArea(Graphics2D graphics, Area area, api.Point mousePosition, Color fillColor, Color borderColor, Color borderHoverColor)
	{
		if (area != null)
		{
			if (area.contains(mousePosition.getX(), mousePosition.getY()))
			{
				graphics.setColor(borderHoverColor);
			}
			else
			{
				graphics.setColor(borderColor);
			}

			graphics.draw(area);
			graphics.setColor(fillColor);
			graphics.fill(area);
		}
	}

	public static void setGraphicProperties(Graphics2D graphics)
	{
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public static java.awt.Point padPosition(OverlayPosition position, Dimension dimension, final int padding)
	{
		final java.awt.Point result = new java.awt.Point();

		switch (position)
		{
			case DYNAMIC:
			case TOOLTIP:
				break;
			case BOTTOM_LEFT:
				result.x += dimension.width + (dimension.width == 0 ? 0 : padding);
				break;
			case BOTTOM_RIGHT:
				result.x -= dimension.width + (dimension.width == 0 ? 0 : padding);
				break;
			case TOP_LEFT:
			case TOP_CENTER:
				result.y += dimension.height + (dimension.height == 0 ? 0 : padding);
				break;
			case CANVAS_TOP_RIGHT:
			case TOP_RIGHT:
				result.y += dimension.height + (dimension.height == 0 ? 0 : padding);
				break;
			case ABOVE_CHATBOX_RIGHT:
				result.y -= dimension.height + (dimension.height == 0 ? 0 : padding);
				break;
		}

		return result;
	}

	public static java.awt.Point transformPosition(OverlayPosition position, Dimension dimension)
	{
		final java.awt.Point result = new java.awt.Point();

		switch (position)
		{
			case DYNAMIC:
			case TOOLTIP:
			case TOP_LEFT:
				break;
			case TOP_CENTER:
				result.x = result.x - dimension.width / 2;
				break;
			case BOTTOM_LEFT:
				result.y = result.y - dimension.height;
				break;
			case BOTTOM_RIGHT:
			case ABOVE_CHATBOX_RIGHT:
				result.y = result.y - dimension.height;
				// FALLTHROUGH
			case CANVAS_TOP_RIGHT:
			case TOP_RIGHT:
				result.x = result.x - dimension.width;
				break;
		}

		return result;
	}

	public static void renderActorTextAndImage(Graphics2D graphics, Actor actor, String text, Color color,
											BufferedImage image, int yOffset, int xOffset)
	{
		api.Point textLocation = new api.Point(actor.getConvexHull().getBounds().x + xOffset,
			actor.getConvexHull().getBounds().y + yOffset);

		renderImageLocation(graphics, textLocation, image);
		xOffset = image.getWidth() + 1;
		yOffset = (image.getHeight() - (int) graphics.getFontMetrics().getStringBounds(text, graphics).getHeight());
		textLocation = new api.Point((int)textLocation.getX() + xOffset, (int)textLocation.getY() + image.getHeight() - yOffset);
		renderTextLocation(graphics, textLocation, text, color);
	}
}
