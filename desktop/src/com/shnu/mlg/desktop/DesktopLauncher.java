package com.shnu.mlg.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.shnu.mlg.MLG;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		/*
		config.width = config.getDesktopDisplayMode().width;
		config.height = config.getDesktopDisplayMode().height;
		config.fullscreen = true;
		*/
		
		//1/4 of 1080p for now
		config.width = 1280;
		config.height = 720;
		
		
		new LwjglApplication(new MLG(), config);
	}
}
