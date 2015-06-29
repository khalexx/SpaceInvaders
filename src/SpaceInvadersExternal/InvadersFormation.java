package SpaceInvadersExternal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class InvadersFormation {

	final int ROWS = 5;
	final int COLUMNS = 10;

	public static final float HORIZONTAL_SPACE = Gdx.graphics.getWidth() * 0.025f;
	public static final float VERTICAL_SPACE = Gdx.graphics.getHeight() * 0.025f;
	public static final float TEXTURE_WIDTH = 30;
	public static final float TEXTURE_HEIGHT = 30;
	// final float XMAX = Space.WIDTH - COLUMNS * Invader.WIDTH - (COLUMNS - 1)

	private final float _x = 0;
	private final float _y = Gdx.graphics.getHeight();
	int invadersCount = 0;

	Invader[][] _formation;

	InvadersFormation() {
		_formation = new Invader[ROWS][COLUMNS];
		float x = _x;
		float y = _y;

		for (int i = 0; i < _formation.length; i++) {
			y -= VERTICAL_SPACE + TEXTURE_HEIGHT;
			for (int j = 0; j < _formation[i].length; j++) {
				_formation[i][j] = new Invader(x, y);
				x += HORIZONTAL_SPACE + TEXTURE_WIDTH;
				invadersCount++;
			}
			x = 0;

		}
	}

	public void delegateActors(final Stage stage) {
		for (int i = 0; i < _formation.length; i++) {
			for (int j = 0; j < _formation[i].length; j++) {
				stage.addActor(_formation[i][j]);
			}
		}
	}

	public boolean isOnEdge() {
		boolean onEdge = false;
		for (int i = 0; i < _formation.length; i++) {
			for (int j = 0; j < _formation[i].length; j++) {
				if (_formation[i][j] == null) {
					continue;
				}
				if (_formation[i][j].onEdge()) {
					onEdge = true;
				}
				;
			}
		}
		return onEdge;
	}

	public void startCharge() {
		for (int i = 0; i < _formation.length; i++) {
			for (int j = 0; j < _formation[i].length; j++) {
				if (_formation[i][j] == null) {
					continue;
				}
				_formation[i][j].startCharge();
			}
		}
	}

	public boolean bulletShot(final float x, final float y) {
		for (int i = 0; i < _formation.length; i++) {
			for (int j = 0; j < _formation[i].length; j++) {
				if (_formation[i][j] == null) {
					continue;
				}
				if (_formation[i][j].tryHit(x, y)) {
					_formation[i][j].remove();
					_formation[i][j] = null;
					invadersCount--;
					increaseInvadersSpeed();
					return true;
				}
				;
			}
		}
		return false;

	}

	private void increaseInvadersSpeed() {
		for (int i = 0; i < _formation.length; i++) {
			for (int j = 0; j < _formation[i].length; j++) {
				if (_formation[i][j] == null) {
					continue;
				}
				_formation[i][j].increaseInvaderSpeed();
			}
		}
	}

	public boolean attackSpaceship(final Spaceship spaceship) {
		for (int i = 0; i < _formation.length; i++) {
			for (int j = 0; j < _formation[i].length; j++) {
				if (_formation[i][j] == null) {
					continue;
				}
				if (_formation[i][j].tryHit(spaceship.getGunX(),
						spaceship.getY() + spaceship.texture.getHeight())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean destroyed() {
		return invadersCount == 0;
	}

	boolean attackEarth() {
		for (int i = 0; i < _formation.length; i++) {
			for (int j = 0; j < _formation[i].length; j++) {
				if (_formation[i][j] == null) {
					continue;
				}
				if (_formation[i][j].attackEarth()) {
					return true;
				}
			}
		}
		return false;

	}

}
