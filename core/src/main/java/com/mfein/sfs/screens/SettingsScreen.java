package com.mfein.sfs.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
        // create the main table and add it to the stage
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.setRound(false);
        stage.addActor(mainTable);

        // create the banner table
        Table bannerTable = new Table();
        bannerTable.setRound(false);

        // add the back button and the settings image to the banner table
        bannerTable.add(backButton).size(backButton.getWidth(), backButton.getHeight());
        bannerTable.add(settingsImage).size(settingsImage.getWidth(), settingsImage.getHeight());

        // add an empty cell to the banner table the same size as the back button in order to center the settings image
        bannerTable.add().size(backButton.getWidth(), backButton.getHeight());

        // add the banner table to the main table
        mainTable.add(bannerTable);
        mainTable.row().padTop(1f);

        // create the audio table
        Table audioTable = new Table();
        audioTable.setRound(false);

        // create the music table and set its background to the music setting background image
        Table musicTable = new Table();
        musicTable.setRound(false);
        musicTable.setBackground(musicSettingBackgroundImage.getDrawable());
        musicTable.setSize(musicSettingBackgroundImage.getWidth(), musicSettingBackgroundImage.getHeight());

        // add an empty cell (for alignment) and the music toggle button to the music table
        musicTable.add().width(musicSettingBackgroundImage.getWidth() - musicToggleButton.getWidth() - 2f);
        musicTable.add(musicToggleButton).size(musicToggleButton.getWidth(), musicToggleButton.getHeight());

        // add the music table to the audio table
        audioTable.add(musicTable).size(musicTable.getWidth(), musicTable.getHeight());

        // create the sounds table and set its background to the sounds setting background image
        Table soundsTable = new Table();
        soundsTable.setRound(false);
        soundsTable.setBackground(soundsSettingBackgroundImage.getDrawable());
        soundsTable.setSize(soundsSettingBackgroundImage.getWidth(), soundsSettingBackgroundImage.getHeight());


        // add an empty cell (for alignment) and the sounds toggle button to the sounds table
        soundsTable.add().width(soundsSettingBackgroundImage.getWidth() - soundsToggleButton.getWidth() - 2f);
        soundsTable.add(soundsToggleButton).size(soundsToggleButton.getWidth(), soundsToggleButton.getHeight());

        // add the sounds table to the audio table
        audioTable.add(soundsTable).size(soundsTable.getWidth(), soundsTable.getHeight());

        // add the audio table to the main table
        mainTable.add(audioTable);
        mainTable.row().padTop(1f);

        // create the difficulty table and set its background to the difficulty setting background image
        Table difficultyTable = new Table();
        difficultyTable.setRound(false);
        difficultyTable.setBackground(difficultySettingBackgroundImage.getDrawable());
        difficultyTable.setSize(difficultySettingBackgroundImage.getWidth(), difficultySettingBackgroundImage.getHeight());


        // create the difficulty selection table
        Table difficultySelectionTable = new Table();
        difficultySelectionTable.setRound(false);

        // create the difficulty image stack and add the difficulty images to it
        Stack difficultyImageStack = new Stack();
        difficultyImageStack.add(easyImage);
        difficultyImageStack.add(mediumImage);
        difficultyImageStack.add(hardImage);
        difficultyImageStack.setSize(easyImage.getWidth(), easyImage.getHeight());


        // add the difficulty selection buttons and the difficulty image stack to the difficulty selection table
        difficultySelectionTable.add(previousDifficultyButton).size(previousDifficultyButton.getWidth(),
            previousDifficultyButton.getHeight());
        difficultySelectionTable.add(difficultyImageStack).size(difficultyImageStack.getWidth(),
            difficultyImageStack.getHeight()).padLeft(0.5f).padRight(0.5f);
        difficultySelectionTable.add(nextDifficultyButton).size(nextDifficultyButton.getWidth(),
            nextDifficultyButton.getHeight());
        difficultySelectionTable.pack();

        // add an empty cell (for alignment) and the difficulty selection table to the difficulty table
        difficultyTable.add().width(difficultySettingBackgroundImage.getWidth() - difficultySelectionTable.getWidth() - 2f);
        difficultyTable.add(difficultySelectionTable).size(difficultySelectionTable.getWidth(),
            difficultySelectionTable.getHeight());

        // add the difficulty table to the main table
        mainTable.add(difficultyTable).size(difficultyTable.getWidth(), difficultyTable.getHeight());
        mainTable.row().padTop(1f);

        // create the bottom table
        Table bottomTable = new Table();
        bottomTable.setRound(false);

        // create the full screen table and set its background to the full screen setting background image
        Table fullScreenTable = new Table();
        fullScreenTable.setRound(false);
        fullScreenTable.setBackground(fullScreenSettingBackgroundImage.getDrawable());
        fullScreenTable.setSize(fullScreenSettingBackgroundImage.getWidth(), fullScreenSettingBackgroundImage.getHeight());

        // add an empty cell (for alignment) and the full screen check button to the full screen table
        fullScreenTable.add().width(fullScreenSettingBackgroundImage.getWidth() - fullScreenCheckButton.getWidth() - 2f);
        fullScreenTable.add(fullScreenCheckButton).size(fullScreenCheckButton.getWidth(), fullScreenCheckButton.getHeight());

        // add the full screen table to the bottom table
        bottomTable.add(fullScreenTable).size(fullScreenTable.getWidth(), fullScreenTable.getHeight());

        // create the blood table and set its background to the blood setting background image
        Table bloodTable = new Table();
        bloodTable.setRound(false);
        bloodTable.setBackground(bloodSettingBackgroundImage.getDrawable());
        bloodTable.setSize(bloodSettingBackgroundImage.getWidth(), bloodSettingBackgroundImage.getHeight());

        // add an empty cell (for alignment) and the blood check button to the blood table
        bloodTable.add().width(bloodSettingBackgroundImage.getWidth() - bloodCheckButton.getWidth() - 2f);
        bloodTable.add(bloodCheckButton).size(bloodCheckButton.getWidth(), bloodCheckButton.getHeight());

        // add the blood table to the bottom table
        bottomTable.add(bloodTable).size(bloodTable.getWidth(), bloodTable.getHeight());


        // add the bottom table to the main table
        mainTable.add(bottomTable);
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
