package com.mfein.sfs;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mfein.sfs.resources.Assets;
import com.mfein.sfs.screens.GameScreen;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class SFS extends Game {
    public SpriteBatch batch;
    public Assets assets;

    // screens
    public GameScreen gameScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        assets = new Assets(); // asset manager

        // load all assets
        assets.load();
        assets.manager.finishLoading();// block all other code in our game from running until all the
        //.. assets have finished loading.

        // initialize the game screen and switch to it
        gameScreen = new GameScreen(this);
        setScreen(gameScreen);
    }

    @Override
    public void render() {
        // calls the render method in the Game class.
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        assets.dispose();
    }
}
