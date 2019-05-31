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

import javax.inject.Named;

import api.GameState;
import api.Player;
import api.events.VarbitChanged;
import callbacks.Callbacks;
import net.runelite.mapping.Import;
import rs.api.RSClient;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import org.slf4j.Logger;

import java.awt.*;

@Mixin(RSClient.class)
public abstract class RSClientMixin implements RSClient
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@javax.inject.Inject
	private Callbacks callbacks;

	@Inject
	@javax.inject.Inject
	@Named("Core Logger")
	private Logger logger;

	@Inject
	@Override
	public boolean isInterpolatePlayerAnimations() {
		return false;
	}

	@Inject
	@Override
	public Callbacks getCallbacks()
	{
		return callbacks;
	}


	@Inject
	@Override
	public void setDrawingMode(int mode) {
		System.out.println("Hello");
	}

	@Inject
	@Override
	public GameState getGameState() {
		return GameState.LOGIN_SCREEN;
	}

	@Inject
	@Override
	public void setGameDrawingMode(int mode) {
		System.out.println("Hello");
	}

	@Import("localPlayer")
	@Inject
	rs.api.RSPlayer localPlayer;

	@Inject
	@Override
	public Player getLocalPlayer() {
		VarbitChanged vbc = new VarbitChanged();
		vbc.setIndex(420);
		if (client.getCallbacks()==null) {
			System.out.println("Booooo");
		} else {
			client.getCallbacks().post(vbc);
		}
		System.out.println("Impl getLocalPlayer");
		return localPlayer;
	}

	@Inject
	@Override
	public Canvas getCanvas() {
		System.out.println("Impl Canvas");
		return null;
	}


}