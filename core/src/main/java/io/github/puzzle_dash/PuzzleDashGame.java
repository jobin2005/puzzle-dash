package io.github.puzzle_dash;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//      Class
public class PuzzleDashGame extends Game {
    public static final int V_WIDTH = 800;
    public static final int V_HEIGHT = 600;


    @Override
    public void create() {

        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {

    }
}
