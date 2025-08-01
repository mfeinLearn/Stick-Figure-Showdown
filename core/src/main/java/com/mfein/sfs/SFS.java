package com.mfein.sfs;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mfein.sfs.objects.Fighter;
import com.mfein.sfs.resources.Assets;
import com.mfein.sfs.resources.AudioManager;
import com.mfein.sfs.screens.GameScreen;
import com.mfein.sfs.screens.MainMenuScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class SFS extends Game {


    public SpriteBatch batch;

    public ShapeRenderer shapeRenderer;

    public Assets assets;
    public AudioManager audioManager;

    // screens
    public GameScreen gameScreen;
    public MainMenuScreen mainMenuScreen;


    // fighters
    public Fighter player, opponent;


    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        assets = new Assets();


        // load all assets
        assets.load();
        assets.manager.finishLoading();

        // initialize the audio manager
        audioManager = new AudioManager(assets.manager);
        audioManager.playMusic();

        // initialize the fighters
        player = new Fighter(this, "Slim Stallone", new Color(1f, 0.2f,0.2f,1f));
        opponent = new Fighter(this, "Thin Diesel", new Color(0.25f, 0.7f, 1f, 1f));

        // initialize the game screen
        gameScreen = new GameScreen(this);

        // initialize the main menu screen and switch to it
        mainMenuScreen = new MainMenuScreen(this);
        setScreen(mainMenuScreen);

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        assets.dispose();

    }
}
