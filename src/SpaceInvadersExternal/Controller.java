package SpaceInvadersExternal;

public class Controller {

	private final Model _model;

	public Controller(final Model model) {
		_model = model;
	}

	public void leftPressed() {
		_model.startMovingSpaceshipLeft();
	}

	public void rightPressed() {
		_model.startMovingSpaceshipRight();
	}

	public void leftOrRightReleased() {
		_model.stopMovingSpaceship();

	}

	public void shootPressed() {
		_model.spaceshipShoot();
	}

}
