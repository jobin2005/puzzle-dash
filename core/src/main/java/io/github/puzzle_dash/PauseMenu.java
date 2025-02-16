package io.github.puzzle_dash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
//        Class
public class PauseMenu implements Screen {
    SpriteBatch batch;
    Texture PauseMen;
    Sprite pausemenuSprite;
    Stage stage;
    Texture resumetexture;
    Texture restarttexture;
    Texture quittexture;
    Level1 level1;
    Music bg;

//    Constructor
public PauseMenu(SpriteBatch batch, Level1 lvl1)
    {
        this.level1=lvl1;
        this.batch=batch;
        PauseMen =new Texture("credits.png");
        pausemenuSprite= new Sprite(PauseMen);
        pausemenuSprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

//      Play button texture
        resumetexture = new Texture("resume-button.png");
        TextureRegionDrawable buttonDrawable1 = new TextureRegionDrawable(resumetexture);
        ImageButton button1 = new ImageButton(buttonDrawable1);
        button1.setSize(199, 82);
        button1.setPosition(885, 600);


        button1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Resume Button Clicked!");
                bg.stop();
                level1.resumeGame();
                PuzzleDashGame game = (PuzzleDashGame) Gdx.app.getApplicationListener();
                game.setScreen(level1);
                dispose();
            }
        });

//        Restart button
        restarttexture = new Texture("restart-button.png");
        TextureRegionDrawable buttonDrawable2 = new TextureRegionDrawable(restarttexture);
        ImageButton button2 = new ImageButton(buttonDrawable2);
        button2.setSize(213, 83);
        button2.setPosition(877, 450);

        button2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Restart Button Clicked!");
                bg.stop();
                PuzzleDashGame game = (PuzzleDashGame) Gdx.app.getApplicationListener();
                game.setScreen(new Level1(batch));
                dispose();
            }
        });

//        Quit Button
        quittexture = new Texture("quit-button.png");
        TextureRegionDrawable buttonDrawable3 = new TextureRegionDrawable(quittexture);
        ImageButton button3 = new ImageButton(buttonDrawable3);
        button3.setSize(139, 82);
        button3.setPosition(920, 300);

        button3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Quit Button Clicked!");
                bg.stop();
                PuzzleDashGame game = (PuzzleDashGame) Gdx.app.getApplicationListener();
                game.setScreen(new MainMenuScreen(game));
                dispose();
            }


        });

        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);


    }
    @Override
    public void show() {
        bg = Gdx.audio.newMusic(Gdx.files.internal("bgm.mp3"));
        bg.setLooping(true); // Set to loop if needed
        bg.setVolume(0.2f); // Set volume (0.0 to 1.0)
        bg.play();
    }

    @Override
    public void render(float v) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            bg.stop();
            PuzzleDashGame game = (PuzzleDashGame) Gdx.app.getApplicationListener();
            game.setScreen(new Level1(batch));


        }

        batch.begin();
        pausemenuSprite.draw(batch);
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        PauseMen.dispose();
        bg.dispose();
    }
}
