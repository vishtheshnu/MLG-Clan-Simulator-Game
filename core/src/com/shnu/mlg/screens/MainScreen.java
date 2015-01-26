package com.shnu.mlg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.shnu.mlg.MLG;
import com.shnu.mlg.Resources;
import com.shnu.mlg.data.Bonuses;
import com.shnu.mlg.data.Player;

public class MainScreen implements Screen{

	private MLG game;
	
	private Stage stage;
	private Group hitmarkers;
	private Label fps;
	
	private float time;
	
	public MainScreen(MLG game){
		this.game = game;
		stage = new Stage(MLG.viewport);
		hitmarkers = new Group();
		createStage();
		//TODO temp
		new Player();
	}
	
	public void createStage(){
		stage.clear();
		
		//Background
		Image back = new Image(Resources.background);
		back.setBounds(0, 0, 1920, 1080);
		stage.addActor(back);
		
		//Buttons
		for(Actor a : Buttons.mainscreenActors)
			stage.addActor(a);
		
		//Button Listeners
		Buttons.msShop.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y){
				//game.setScreen(MLG.shopScreen);
			}
		});
		
		//Add extra listeners/stuff to buttons/actors
		stage.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				if(x >= Buttons.msDirtyCash.getX() && y >= Buttons.msDirtyCash.getY() &&
						x <= Buttons.msDirtyCash.getX()+Buttons.msDirtyCash.getWidth() && y <= Buttons.msDirtyCash.getY()+Buttons.msDirtyCash.getHeight()){
					addMoney(x, y);
					Buttons.msDirtyCash.toggle();
		 			return true;
				}
				return true;
			}
		});
		
		Buttons.msQuit.addListener(new ClickListener(){
			public void clicked(InputEvent e, float x, float y){
				Dialog qd = new Dialog("Quit", Resources.uiskin){
					protected void result(Object o){
						if(o instanceof Boolean){
							if((Boolean)o == true){
								Gdx.app.exit();
							}else{
								//Do nothing
							}
						}
					}
				};
				//qd.add(new Label("Sure you want to quit, m8?", Resources.uiskin));
				qd.setSkin(Resources.uiskin);
				qd.add("Sure you want to quit, m8?");
				qd.button("Yes", true);
				qd.button("No", false);
				qd.setBounds(200, 200, 1920-200, 1080-200);
				stage.addActor(qd);
			}
		});
		
		//hitmarkers on top
		stage.addActor(hitmarkers);
		
		fps = new Label("fps", Resources.uiskin);
		//stage.addActor(fps);
	}
	
	/**
	 * Caluclates how much money to add depending on upgrades, etc.
	 */
	private void addMoney(float x, float y){
		Player.money += (1+Bonuses.onClickAdd)*Bonuses.onClickMultiply;
		addSmoke((1+Bonuses.onClickAdd)*Bonuses.onClickMultiply);
		MLG.addHitmarker(hitmarkers, x,y);
	}
	
	/**
	 * Make smoke effect w/ amt of money earned inside
	 * @param money amt of money to show
	 */
	private void addSmoke(int money){
		Image img = new Image(Resources.smoke);
		Label m = new Label("$"+money, Resources.uiskin);
		m.setColor(Color.DARK_GRAY);
		int randx = (int)(Math.random()*200 - 100);
		int randy = (int)(Math.random()*100-50);
		m.setBounds(400+700+randx, 250+50+randy, m.getWidth(), m.getHeight());
		img.setBounds(300+700+randx, 200+50+randy-m.getWidth()/2, 200+m.getWidth(), 100+m.getHeight()+m.getWidth());
		
		img.addAction(Actions.moveBy(0, 300, 1.5f));
		img.addAction(Actions.fadeOut(1.5f));
		img.addAction(Actions.sequence(Actions.delay(1.6f), Actions.removeActor()));
		
		m.addAction(Actions.moveBy(0, 300, 1.5f));
		m.addAction(Actions.fadeOut(1.5f));
		m.addAction(Actions.sequence(Actions.delay(1.6f), Actions.removeActor()));
		
		stage.addActor(img);
		stage.addActor(m);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Update other values
		time += delta;
		if(time >= 1){
			time -= 1;
			Player.money += (Bonuses.secondAdd)*Bonuses.secondMultiply;
		}
		Buttons.msMoney.setText("Money: $"+Player.money);
		fps.setText("FPS: "+delta);
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().apply();
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
