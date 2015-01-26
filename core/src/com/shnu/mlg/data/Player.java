package com.shnu.mlg.data;

/**
 * Represents the player and their progress.
 * Is a static class, and load method is called via title screen's continue
 * Stores money, inventory, members & their stats, and match history (or w/e)
 * @author Vishnu
 *
 */
public class Player {

	public static int money;

	public Player(){
		load(); //TODO temp, for now.
		new Bonuses();
	}
	
	/**
	 * Loads progress from file
	 */
	public void load(){
		money = 100;
	}
}
