package SpaceInvadersExternal;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Model extends Actor {
	private final Spaceship spaceship = new Spaceship();
	private final InvadersFormation invadersFormation = new InvadersFormation();
	private final Bullet spaceshipBullet = new Bullet(true);
	private final Bullet invadersBullet = new Bullet(false);
	private boolean gameOver = false;
	private boolean win = false;

	public void addSpaceship(final Stage spaceInvadersStage) {
		spaceInvadersStage.addActor(spaceship);
	}

	public void addSpaceshipBullet(final Stage spaceInvadersStage) {
		spaceInvadersStage.addActor(spaceshipBullet);
	}

	public void addInvaders(final Stage spaceInvadersStage) {
		invadersFormation.delegateActors(spaceInvadersStage);
	}

	@Override
	public void act(final float delta) {

		if (invadersFormation.bulletShot(spaceshipBullet.getX(),
				spaceshipBullet.getY())) {
			spaceshipBullet.stopFly();
		}

		if (invadersFormation.isOnEdge()) {
			invadersFormation.startCharge();
		}

		if (invadersFormation.attackSpaceship(spaceship)) {
			gameOver = true;
		}

		if (invadersFormation.destroyed()) {
			win = true;
		}

	}

	public void startMovingSpaceshipLeft() {
		spaceship.startMovingLeft();
	}

	void startMovingSpaceshipRight() {
		spaceship.startMovingRight();
	}

	public void stopMovingSpaceship() {
		spaceship.stopMoving();
	}

	public void spaceshipShoot() {
		spaceshipBullet.shoot(spaceship.getGunX());
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public boolean isWin() {
		return win;
	}

}
