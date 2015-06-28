package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class SpaceInvadersScreen implements Screen {

	SpaceInvadersStage _stage;
	MySpaceInvaders game;

	public SpaceInvadersScreen(final MySpaceInvaders game) {
		this.game = game;
	}

	@Override
	public void show() {

		_stage = new SpaceInvadersStage();
		_stage.init();

	}

	@Override
	public void render(final float delta) {
		final Color backgroundColor = Color.BLACK;
		Gdx.gl.glClearColor(backgroundColor.r, backgroundColor.g,
				backgroundColor.b, backgroundColor.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		_stage.act(delta);
		_stage.draw();
		if (_stage.loosed()) {
			game.gos.setGameOverScreen();
			game.setScreen(game.gos);
		}

		if (_stage.winned()) {
			game.setScreen(game.gos);
		}

	}

	@Override
	public void resize(final int width, final int height) {
		_stage.getViewport().update(width, height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {

	}

}
