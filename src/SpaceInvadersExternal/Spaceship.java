package SpaceInvadersExternal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Spaceship extends Actor {
	Texture texture = new Texture(Gdx.files.internal("Spaceship.jpg"));
	private boolean _movingleft = false;
	private boolean _movingright = false;

	public Spaceship() {
		setX(0);
		setY(0);
		setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());
	}

	@Override
	public void draw(final Batch batch, final float parentAlpha) {
		batch.draw(texture, getX(), getY());
	}

	public void startMovingLeft() {
		_movingleft = true;
	}

	public void startMovingRight() {
		_movingright = true;
	}

	public void stopMoving() {
		_movingleft = false;
		_movingright = false;
	}

	@Override
	public void act(final float delta) {

		if (_movingleft && getX() > 0) {
			setX(getX() - 3);
		} else if (_movingright
				&& getX() < (Gdx.graphics.getWidth() - texture.getWidth())) {
			setX(getX() + 3);
		}
	}

	public float getGunX() {
		return getX() + texture.getWidth() / 2;
	}
}
