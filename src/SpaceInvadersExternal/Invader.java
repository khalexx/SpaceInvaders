package SpaceInvadersExternal;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Invader extends Actor {

	private static final float MAX_CHARGE_DISDANCE = 15f;
	Texture texture;
	private float _x = 0;
	private float _y = 0;
	private float chargeDistance = MAX_CHARGE_DISDANCE;
	private boolean onCharge = false;
	private float speedModifier = 0.0f;

	private final Type type;
	private MovingDirection movingDirection = MovingDirection.RIGHT;

	// public static final float WIDTH = 5f;
	// public static final float LENGHT = 7.5f;
	//
	// public int row;
	// public int col;

	static Random random = new Random();

	enum MovingDirection {
		RIGHT, LEFT
	}

	enum Type {
		A("invader1.jpg"), B("invader2.jpg"), C("invader3.jpg"), D(
				"invader4.jpg"), E("invader5.jpg");

		Type(final String texture) {
			texturePath = texture;

		}

		String texturePath;
	}

	public Invader(final float x, final float y) {
		_x = x;
		_y = y;
		type = Type.values()[random.nextInt(Type.values().length)];
		texture = new Texture(Gdx.files.internal(type.texturePath));
		setBounds(_x, _y, texture.getWidth(), texture.getHeight());
	}

	@Override
	public void draw(final Batch batch, final float parentAlpha) {
		batch.draw(texture, _x, _y);
	}

	@Override
	public void act(final float delta) {

		if (onCharge) {
			_y -= 1;
			chargeDistance -= 2;
			if (chargeDistance <= 0) {
				changeDirection();
				chargeDistance = MAX_CHARGE_DISDANCE;
				onCharge = false;
			}
			return;
		}

		switch (movingDirection) {
		case LEFT: {
			_x -= 1 + speedModifier;
			break;
		}

		case RIGHT: {
			_x += 1 + speedModifier;
			break;
		}
		}
	}

	private void changeDirection() {
		if (movingDirection == MovingDirection.RIGHT) {
			movingDirection = MovingDirection.LEFT;
			_x -= 1 + speedModifier;
		} else {
			movingDirection = MovingDirection.RIGHT;
			_x += 1 + speedModifier;

		}
	}

	public boolean onEdge() {
		if (_x < 0 || _x > Gdx.graphics.getWidth() - texture.getWidth()) {
			return true;
		}
		return false;
	}

	void startCharge() {
		onCharge = true;
	}

	boolean tryHit(final float x, final float y) {
		if (x >= _x && x < _x + getWidth() && y >= _y && y <= _y + getHeight()) {
			return true;
		}
		return false;
	}

	void increaseInvaderSpeed() {
		speedModifier += 0.025f;
	}
}
