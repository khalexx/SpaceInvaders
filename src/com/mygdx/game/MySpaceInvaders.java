package com.mygdx.game;

import com.badlogic.gdx.Game;

public class MySpaceInvaders extends Game {

	EndScreen gos;

	@Override
	public void create() {
		final SpaceInvadersScreen sis = new SpaceInvadersScreen(this);
		gos = new EndScreen();
		setScreen(sis);

	}

}
