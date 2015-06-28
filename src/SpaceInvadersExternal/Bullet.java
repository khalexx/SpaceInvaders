package SpaceInvadersExternal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bullet extends Actor {

	final Texture texture;
	private boolean spaceshipBullet = true;
	private boolean inFly = false;

	public Bullet(final boolean isSpaceshipShooted) {
		spaceshipBullet = isSpaceshipShooted;
		texture = new Texture(Gdx.files.internal("bullet.jpg"));
		setX(0);
		setY(0);
		setBounds(getX(), getY(), texture.getWidth(), texture.getHeight());
	}

	public void shoot(final float gunX) {
		if (inFly) {
			return;
		}

		inFly = true;
		setX(gunX - texture.getWidth() / 2);
	}

	@Override
	public void act(final float delta) {
		if (!inFly) {
			return;
		}

		if (getY() < 0
				|| getY() > Gdx.graphics.getHeight() + texture.getHeight()) {
			stopFly();
			return;
		}

		if (spaceshipBullet) {
			setY(getY() + 4);
		} else {
			setY(getY() - 4);
		}

	}

	void stopFly() {
		inFly = false;
		setY(0);
	}

	@Override
	public void draw(final Batch batch, final float parentAlpha) {
		if (!inFly) {
			return;
		}

		batch.draw(texture, getX(), getY());
	}

}
