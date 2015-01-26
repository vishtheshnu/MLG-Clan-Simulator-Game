package com.shnu.mlg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.shnu.mlg.screens.*;

public class MLG extends Game {

	public static FitViewport viewport;
	
	public static MainScreen mainScreen;
	public static TitleScreen titleScreen;
	public static ShopScreen shopScreen;
	
	@Override
	public void create() {
		//Set Cursor
		Gdx.input.setCursorImage(new Pixmap(Gdx.files.internal("images/scope-mouse.png")), 16, 16);
		//Create viewport
		viewport = new FitViewport(1920, 1080); //1080p HD, nigga
		viewport.apply(true);
		
		//Load Resources
		new Resources();
		new Buttons();
		
		//Create Stages
		titleScreen = new TitleScreen(this);
		mainScreen = new MainScreen(this);
		shopScreen = new ShopScreen(this);
		
		//Set starting screen
		setScreen(mainScreen);
	}

	@Override
	public void render() {
		super.render();
		
	}
	
	public void dispose(){
		super.dispose();
		Resources.dispose();
	}
	
	//Helper static methods
	public static void addHitmarker(Group group, float x, float y){
		Image img = new Image(Resources.hitmarker);
		img.setBounds(x-img.getWidth()/2, y-img.getHeight()/2, 50, 50);
		img.addAction(Actions.sequence(Actions.delay(.1f), Actions.fadeOut(.5f)));
		img.addAction(Actions.sequence(Actions.delay(.6f), Actions.removeActor()));
		group.addActor(img);
		Resources.hitmarkerSound.play();
	}
}
