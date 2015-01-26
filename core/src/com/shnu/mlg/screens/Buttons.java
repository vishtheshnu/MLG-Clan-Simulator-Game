package com.shnu.mlg.screens;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.shnu.mlg.Resources;

/**
 * Pre-creates and stores all of the buttons
 * @author Vishnu
 *
 */
public class Buttons {
	
	//MainScreen
	public static TextButton msCalendar, msInventory, msMembers, msRecruit, msShop, msQuit;
	public static Label msMoney;
	public static ImageButton msDirtyCash;
	
	public static ArrayList<ImageButton> ssSpgradeButtons;
	
	public static Actor [] mainscreenActors;
	
	public Buttons(){
		createMainScreenButtons();
		createShopScreenButtons();
	}
	
	private void createMainScreenButtons(){
		mainscreenActors = new Actor[7];
		
		msCalendar = new TextButton("Calendar", Resources.uiskin);
		msCalendar.setBounds(120, 120, 300, 120);
		mainscreenActors[0] = msCalendar;
		msMembers = new TextButton("Members", Resources.uiskin);
		msMembers.setBounds(120, 120*3, 300, 120);
		mainscreenActors[1] = msMembers;
		msShop = new TextButton("Tesco", Resources.uiskin);
		msShop.setBounds(120, 120*5, 300, 120);
		mainscreenActors[2] = msShop;
		msRecruit = new TextButton("Recruit", Resources.uiskin);
		msRecruit.setBounds(120, 120*7, 300, 120);
		mainscreenActors[3] = msRecruit;
		
		msMoney = new Label("Money: ", Resources.uiskin);
		msMoney.setBounds(1500, 120*7, 300, 120);
		mainscreenActors[4] = msMoney;
		msQuit = new TextButton("Quit", Resources.uiskin);
		msQuit.setBounds(1500, 120, 300, 120);
		mainscreenActors[5] = msQuit;
		
		
		msDirtyCash = new ImageButton(new TextureRegionDrawable(new TextureRegion(Resources.weedButtonUp)),
				new TextureRegionDrawable(new TextureRegion(Resources.weedButtonUp)));
		msDirtyCash.setBounds(760, 50, 400, 400);
		mainscreenActors[6] = msDirtyCash;
		
	}
	
	private void createShopScreenButtons(){
		//get list of upgrades/everything from text file
	}

}
