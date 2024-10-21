package io.github.puzzle_dash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    //sprites
    Sprite mainmenusprite;
    Sprite playbuttonsprite;
    Sprite levelbuttonsprite;
    Sprite creditsbuttonsprite;
    Sprite exitbuttonsprite;
    Texture mainmenuTexture;
    Stage stage; // Stage for the button
    //buttons
    Texture playbuttonTexture;
    ImageButton button1;
    Texture levelbuttonTexture;
    ImageButton button2;
    Texture creditsbuttonTexture;
    ImageButton button3;
    Texture exitbuttonTexture;
    ImageButton button4;

    @Override
    public void create() {
        // Create sprite
        mainmenuTexture = new Texture("main-menu.png");
        batch = new SpriteBatch();


        mainmenusprite = new Sprite(mainmenuTexture);
        mainmenusprite.setPosition(0, 0);
        mainmenusprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); // Use screen dimensions

        // Set up the stage and input processor?????
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage); // Direct input events to the stage

        // Play button texture
        playbuttonTexture = new Texture("play-button.png");
        playbuttonsprite = new Sprite(playbuttonTexture);
        TextureRegion buttonRegion1 = new TextureRegion(playbuttonTexture);
        TextureRegionDrawable buttonDrawable1 = new TextureRegionDrawable(buttonRegion1);
        button1 = new ImageButton(buttonDrawable1);
        button1.setSize(180, 81);
        button1.setPosition(708, 404);

        // Add click listener to the button
        button1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Button", "Start Game Button Clicked!");
                // Add code to start the game or transition to another screen
            }
        });
        // level button texture
        levelbuttonTexture = new Texture("level-button.png");
        levelbuttonsprite = new Sprite(levelbuttonTexture);
        TextureRegion buttonRegion2 = new TextureRegion(levelbuttonTexture);
        TextureRegionDrawable buttonDrawable2 = new TextureRegionDrawable(buttonRegion2);
        button2 = new ImageButton(buttonDrawable2);
        button2.setSize(209, 84);
        button2.setPosition(698, 313);

        // Add click listener to the button
        button2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Button", "Start Level Button Clicked!");
                // Add code to start the game or transition to another screen
            }
        });
        // credits button texture
        creditsbuttonTexture = new Texture("credits-button.png");
        creditsbuttonsprite = new Sprite(creditsbuttonTexture);
        TextureRegion buttonRegion3 = new TextureRegion(creditsbuttonTexture);
        TextureRegionDrawable buttonDrawable3 = new TextureRegionDrawable(buttonRegion3);
        button3 = new ImageButton(buttonDrawable3);
        button3.setSize(277, 85);
        button3.setPosition(659, 224);

        // Add click listener to the button
        button3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Button", "Open Credits Button Clicked!");
                // Add code to start the game or transition to another screen
            }
        });
        //exit button texture
        exitbuttonTexture = new Texture("exit-button.png");
        exitbuttonsprite = new Sprite(exitbuttonTexture);
        TextureRegion buttonRegion4 = new TextureRegion(exitbuttonTexture);
        TextureRegionDrawable buttonDrawable4 = new TextureRegionDrawable(buttonRegion4);
        button4 = new ImageButton(buttonDrawable4);
        button4.setSize(181, 82);
        button4.setPosition(708, 138);

        // Add click listener to the button
        button4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Button", "Exit Game Button Clicked!");
                // Add code to start the game or transition to another screen
            }
        });

        // Add the button to the stage
        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
    }


    @Override
    public void render() {
        // Clear the screen
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // Draw the sprite (background)
        batch.begin();
        mainmenusprite.draw(batch);

        batch.end();

        // Draw the stage (button)
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        mainmenuTexture.dispose();
        playbuttonTexture.dispose(); // Dispose of the button texture when done
    }
}
