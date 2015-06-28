package com.mygdx.game;

import SpaceInvadersExternal.Controller;
import SpaceInvadersExternal.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SpaceInvadersStage extends Stage {
	Model model = new Model();
	private boolean gameOver = false;
	private boolean win = false;

	public SpaceInvadersStage() {
		final Camera camera = new OrthographicCamera();
		camera.position.x = Gdx.graphics.getWidth() / 2f;
		camera.position.y = Gdx.graphics.getHeight() / 2f;
		setViewport(new ScreenViewport(camera));

	}

	public void init() {

		final Controller controller = new Controller(model);

		model.addSpaceship(this);
		model.addInvaders(this);
		model.addSpaceshipBullet(this);
		addActor(model);

		Gdx.input.setInputProcessor(this);
		addListener(new InputListener() {
			@Override
			public boolean keyDown(final InputEvent event, final int keycode) {
				switch (keycode) {
				case Input.Keys.LEFT: {
					controller.leftPressed();
					break;
				}
				case Input.Keys.RIGHT: {
					controller.rightPressed();
					break;
				}
				case Input.Keys.SPACE: {
					controller.shootPressed();
					break;
				}
				}
				return true;
			}

			@Override
			public boolean keyUp(final InputEvent event, final int keycode) {

				if (keycode == Input.Keys.LEFT || keycode == Input.Keys.RIGHT) {
					controller.leftOrRightReleased();
				}

				return true;
			}

		});

	}

	@Override
	public void act(final float delta) {
		gameOver = model.isGameOver();
		win = model.isWin();
		super.act(delta);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		super.draw();
	}

	public boolean loosed() {
		return gameOver;
	}

	public boolean winned() {
		return win;
	}

}
