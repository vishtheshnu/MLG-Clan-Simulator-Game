package com.shnu.mlg.data;

import java.util.ArrayList;

/**
 * List of bonuses purchased by the player
 * @author Vishnu
 *
 */
public class Bonuses {

	public static ArrayList<BonusItem> allBonuses, shownBonuses; //list of bonus items (all vs shown)
	public static int onClickAdd, onClickMultiply, secondAdd, secondMultiply; //total bonuses
	
	public Bonuses(){
		load();
	}
	
	/**
	 * Load what's been purchased so far
	 */
	public void load(){
		//TODO temp
		onClickAdd = 0;
		onClickMultiply = 1;
		secondAdd = 0;
		secondMultiply = 1;
	}
	
	/**
	 * Object that represents each bonus
	 * @author Vishnu
	 *
	 */
	class BonusItem{
		int amt; //quantity of bonus
		int type;	//type of bonus- 0 = on-click add, 1 = on-click multiply,
					//2 = per-sec add, 3 = per-sec multiply
		boolean bought; //whether the player has bought it
		
		public BonusItem(int a, int t){
			amt = a;
			type = t;
		}
		
		public BonusItem(int a, int t, boolean b){
			this(a, t);
			bought = b;
		}
	}
}
