/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import java.awt.Color;
import java.awt.Image;

import com.runeswag.client.misc.Plugin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class InfoBox
{
	@Getter(AccessLevel.PUBLIC)
	private final Plugin plugin;

	@Getter
	@Setter
	private Image image;

	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private Image scaledImage;

	@Getter(AccessLevel.PUBLIC)
	@Setter
	public InfoBoxPriority priority;

	@Getter
	@Setter
	private String tooltip;

	public InfoBox(Image image, Plugin plugin)
	{
		this.plugin = plugin;
		setImage(image);
		setPriority(InfoBoxPriority.NONE);
	}

	public abstract String getText();

	public abstract Color getTextColor();

	public boolean render()
	{
		return true;
	}

	public boolean cull()
	{
		return false;
	}
}
