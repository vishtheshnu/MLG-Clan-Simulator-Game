package com.shnu.mlg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.shnu.mlg.MLG;
import com.shnu.mlg.Resources;

public class TitleScreen implements Screen {

	private MLG game;
	private Stage stage;
	
	public TitleScreen(MLG game){
		this.game = game;
		
		stage = new Stage(MLG.viewport);
		createStage();
	}
	
	public void createStage(){
		stage.clear();
		Image img = new Image(Resources.hitmarker);
		img.setBounds(0, 0, 50, 50);
		stage.addActor(img);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().apply();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

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
