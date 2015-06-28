package SpaceInvadersExternal;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Space extends Actor {

	Texture texture;

	int x = 0;
	int y = 0;

	int width = 300;
	int height = 200;

	public Space() {

		final Pixmap pixmap = new Pixmap(width, height, Format.RGBA8888);
		pixmap.setColor(0, 1, 0, 0.75f);
		pixmap.fillRectangle(x, y, width, height);
		texture = new Texture(pixmap);
		pixmap.dispose();

		setBounds(x, y, texture.getWidth(), texture.getHeight());
	}

	@Override
	public void draw(final Batch batch, final float parentAlpha) {
		batch.draw(texture, 0, 0);
	}

}
