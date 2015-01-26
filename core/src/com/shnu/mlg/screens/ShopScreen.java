package com.shnu.mlg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.shnu.mlg.MLG;
import com.shnu.mlg.Resources;
import com.shnu.mlg.data.Player;

public class ShopScreen implements Screen {

	private MLG game;
	private Group hitmarkers;
	private Stage stage;
	
	public ShopScreen(MLG game){
		this.game = game;
		stage = new Stage(MLG.viewport);
		hitmarkers = new Group();
		createStage();
	}
	
	public void createStage(){
		stage.clear();
		
		//Background
		stage.addActor(new Image(Resources.tescoback));
		//Money
		
		//Upgrade Icons & Names
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
