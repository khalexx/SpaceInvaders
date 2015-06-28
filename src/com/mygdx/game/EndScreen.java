package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndScreen implements Screen {

	SpriteBatch batch;
	Texture endTexture;
	private boolean _isWin = true;

	public void setGameOverScreen() {
		_isWin = false;
	}

	@Override
	public void show() {
		if (_isWin) {
			endTexture = new Texture(Gdx.files.internal("Win.jpg"));
		} else {
			endTexture = new Texture(Gdx.files.internal("GameOver.jpg"));
		}
		batch = new SpriteBatch();

	}

	@Override
	public void render(final float delta) {
		final Color backgroundColor = Color.BLACK;
		Gdx.gl.glClearColor(backgroundColor.r, backgroundColor.g,
				backgroundColor.b, backgroundColor.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(endTexture,
				Gdx.graphics.getWidth() / 2 - endTexture.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - endTexture.getHeight() / 2);
		batch.end();

	}

	@Override
	public void resize(final int width, final int height) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
