package com.shnu.mlg;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class Resources {

	public static Texture background, tescoback;
	public static Texture hitmarker;
	
	public static Texture weedButtonUp, weedButtonDown;
	public static Texture smoke;
	
	
	public static Sound hitmarkerSound;
	
	public static Skin uiskin;
	
	public Resources(){
		background = new Texture("images/backgrounds/background.jpg");
		tescoback = new Texture("images/backgrounds/tesco-logo.png");
		
		hitmarker = new Texture("images/hitmarker.png");
		weedButtonUp = new Texture("images/weedbutton-up.png");
		weedButtonDown = new Texture("images/weedbutton-down.png");
		smoke = new Texture("images/whitePuff23.png");
		
		hitmarkerSound = Gdx.audio.newSound(Gdx.files.internal("sounds/hitmarker.wav"));
		
		uiskin = new Skin(Gdx.files.internal("skins/uiskin.json"));
		(new Label("", uiskin)).getStyle().font = new BitmapFont(Gdx.files.internal("skins/default.fnt"));
		(new TextButton("", uiskin)).getStyle().font = new BitmapFont(Gdx.files.internal("skins/default.fnt"));
		(new Dialog("", uiskin)).getStyle().titleFont = new BitmapFont(Gdx.files.internal("skins/default.fnt"));
		
	}
	
	public static void dispose(){
		hitmarker.dispose();
	}
}
