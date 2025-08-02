package com.mfein.sfs.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mfein.sfs.SFS;
import com.mfein.sfs.resources.Assets;
import com.mfein.sfs.resources.GlobalVariables;

public class SettingsScreen implements Screen {
    private final SFS game;
    private final Stage stage;
    private final TextureAtlas menuItemsAtlas;

    // image widgets
    private Image settingsImage;

    private Image musicSettingBackgroundImage;
    private Image soundsSettingBackgroundImage;
    private Image difficultySettingBackgroundImage;
    private Image fullScreenSettingBackgroundImage;
    private Image bloodSettingBackgroundImage;
    private Image easyImage;
    private Image mediumImage;
    private Image hardImage;

    // button widgets
    private Button backButton;
    private Button musicToggleButton;
    private Button soundsToggleButton;

    private Button previousDifficultyButton;
    private Button nextDifficultyButton;

    private Button fullScreenCheckButton;
    private Button bloodCheckButton;

    public SettingsScreen(SFS game) {
        this.game = game;

        // set up the stage
        stage = new Stage();
        stage.setViewport(new ExtendViewport(GlobalVariables.WORLD_WIDTH, GlobalVariables.MIN_WORLD_HEIGHT,
            GlobalVariables.WORLD_WIDTH, 0, stage.getCamera()));

        // get the menu items texture atlas from the asset manager
        menuItemsAtlas = game.assets.manager.get(Assets.MENU_ITEMS_ATLAS);

        // create the widgets
        createImages();
        createButtons();

        // create the tables
        createTables();

    }

    private void createImages() {
        // create the settings image
        settingsImage = new Image(menuItemsAtlas.findRegion("Settings"));
        settingsImage.setSize(settingsImage.getWidth() * GlobalVariables.WORLD_SCALE, settingsImage.getHeight() *
            GlobalVariables.WORLD_SCALE);

        // create the settings background images
        musicSettingBackgroundImage = new Image(menuItemsAtlas.findRegion("MusicSettingBackground"));
        musicSettingBackgroundImage.setSize(musicSettingBackgroundImage.getWidth() * GlobalVariables.WORLD_SCALE,
            musicSettingBackgroundImage.getHeight() * GlobalVariables.WORLD_SCALE);

        soundsSettingBackgroundImage = new Image(menuItemsAtlas.findRegion("SoundsSettingBackground"));
        soundsSettingBackgroundImage.setSize(soundsSettingBackgroundImage.getWidth() * GlobalVariables.WORLD_SCALE,
            soundsSettingBackgroundImage.getHeight() * GlobalVariables.WORLD_SCALE);

        difficultySettingBackgroundImage = new Image(menuItemsAtlas.findRegion("DifficultySettingBackground"));
        difficultySettingBackgroundImage.setSize(difficultySettingBackgroundImage.getWidth() * GlobalVariables.WORLD_SCALE,
            difficultySettingBackgroundImage.getHeight() * GlobalVariables.WORLD_SCALE);

        fullScreenSettingBackgroundImage = new Image(menuItemsAtlas.findRegion("FullScreenSettingBackground"));
        fullScreenSettingBackgroundImage.setSize(fullScreenSettingBackgroundImage.getWidth() * GlobalVariables.WORLD_SCALE,
            fullScreenSettingBackgroundImage.getHeight() * GlobalVariables.WORLD_SCALE);

        bloodSettingBackgroundImage = new Image(menuItemsAtlas.findRegion("BloodSettingBackground"));
        bloodSettingBackgroundImage.setSize(bloodSettingBackgroundImage.getWidth() * GlobalVariables.WORLD_SCALE,
            bloodSettingBackgroundImage.getHeight() * GlobalVariables.WORLD_SCALE);

        // create the difficulty images
        easyImage = new Image(menuItemsAtlas.findRegion("Easy"));
        easyImage.setSize(easyImage.getWidth() * GlobalVariables.WORLD_SCALE, easyImage.getHeight() *
            GlobalVariables.WORLD_SCALE);

        mediumImage = new Image(menuItemsAtlas.findRegion("Medium"));
        mediumImage.setSize(mediumImage.getWidth() * GlobalVariables.WORLD_SCALE, mediumImage.getHeight() *
            GlobalVariables.WORLD_SCALE);

        hardImage = new Image(menuItemsAtlas.findRegion("Hard"));
        hardImage.setSize(hardImage.getWidth() * GlobalVariables.WORLD_SCALE, hardImage.getHeight() *
            GlobalVariables.WORLD_SCALE);


    }

    private void createButtons() {
        // create the back button
        Button.ButtonStyle backButtonStyle = new Button.ButtonStyle();
        backButtonStyle.up = new TextureRegionDrawable(menuItemsAtlas.findRegion("BackButton"));
        backButtonStyle.down = new TextureRegionDrawable(menuItemsAtlas.findRegion("BackButtonDown"));
        backButton = new Button(backButtonStyle);
        backButton.setSize(backButton.getWidth() * GlobalVariables.WORLD_SCALE, backButton.getHeight() *
            GlobalVariables.WORLD_SCALE);

        // create the toggle button style
        Button.ButtonStyle toggleButtonStyle = new Button.ButtonStyle();
        toggleButtonStyle.up = new TextureRegionDrawable(menuItemsAtlas.findRegion("ToggleButtonOff"));
        toggleButtonStyle.checked = new TextureRegionDrawable(menuItemsAtlas.findRegion("ToggleButtonOn"));

        // create the music toggle button
        musicToggleButton = new Button(toggleButtonStyle);
        musicToggleButton.setSize(musicToggleButton.getWidth() * GlobalVariables.WORLD_SCALE,
            musicToggleButton.getHeight() * GlobalVariables.WORLD_SCALE);

        // create the sounds toggle button
        soundsToggleButton = new Button(toggleButtonStyle);
        soundsToggleButton.setSize(soundsToggleButton.getWidth() * GlobalVariables.WORLD_SCALE,
            soundsToggleButton.getHeight() * GlobalVariables.WORLD_SCALE);

        // create the triangle button style
        Button.ButtonStyle triangleButtonStyle = new Button.ButtonStyle();
        triangleButtonStyle.up = new TextureRegionDrawable(menuItemsAtlas.findRegion("TriangleButton"));
        triangleButtonStyle.down = new TextureRegionDrawable(menuItemsAtlas.findRegion("TriangleButtonDown"));

        // create the previous difficulty button
        previousDifficultyButton = new Button(triangleButtonStyle);
        previousDifficultyButton.setSize(previousDifficultyButton.getWidth() * GlobalVariables.WORLD_SCALE,
            previousDifficultyButton.getHeight() * GlobalVariables.WORLD_SCALE);
        previousDifficultyButton.setTransform(true);
        previousDifficultyButton.setOrigin(previousDifficultyButton.getWidth() / 2f,
            previousDifficultyButton.getHeight() / 2f);
        previousDifficultyButton.setScaleX(-1);

        // create the next difficulty button
        nextDifficultyButton = new Button(triangleButtonStyle);
        nextDifficultyButton.setSize(nextDifficultyButton.getWidth() * GlobalVariables.WORLD_SCALE,
            nextDifficultyButton.getHeight() * GlobalVariables.WORLD_SCALE);

        // create the check button style
        Button.ButtonStyle checkButtonStyle = new Button.ButtonStyle();
        checkButtonStyle.up = new TextureRegionDrawable(menuItemsAtlas.findRegion("CheckButtonOff"));
        checkButtonStyle.checked = new TextureRegionDrawable(menuItemsAtlas.findRegion("CheckButtonOn"));

        // create the full screen check button
        fullScreenCheckButton = new Button(checkButtonStyle);
        fullScreenCheckButton.setSize(fullScreenCheckButton.getWidth() * GlobalVariables.WORLD_SCALE,
            fullScreenCheckButton.getHeight() * GlobalVariables.WORLD_SCALE);

        // create the blood check button
        bloodCheckButton = new Button(checkButtonStyle);
        bloodCheckButton.setSize(bloodCheckButton.getWidth() * GlobalVariables.WORLD_SCALE,
            bloodCheckButton.getHeight() * GlobalVariables.WORLD_SCALE);




    }

    private void createTables() {

    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(GlobalVariables.BLUE_BACKGROUND);

        // tell the stage to do actions and draw itself
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // update the stage's viewport with the new screen size
        stage.getViewport().update(width, height,true);
    }

    @Override
    public void pause() {
        // pause music
        game.audioManager.pauseMusic();

    }

    @Override
    public void resume() {
        // resume music (if it's enabled)
        game.audioManager.playMusic();
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
