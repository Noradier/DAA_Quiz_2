package prison.state;

import java.awt.Graphics;
import prison.entity.*;
import prison.level.*;
import prison.main.Asset;
import prison.main.Game;
import prison.utils.ImageLoader;

public class GameState extends State {
	private Level level;
	public static Button buttonDown, buttonLeft, buttonUp, buttonRight;
	private GameObject player, enemy;
	public static boolean enemyTurn, levelCompleted; 
	
	public GameState(Game game) {
		super(game);
		
		level = new Level1();
		initPlayer();
		initEnemy();
		initButton();
	}
	
	private void initPlayer() {
		player = new Player(0, 0, Asset.player);
		player.setV(level.getMap().getV());
	}
	
	private void initEnemy() {
		int newPos = 800 / level.getMap().getV() * (level.getMap().getV() - 1);
		enemy = new Enemy(newPos, newPos, Asset.enemy);
		enemy.setV(level.getMap().getV());
		((Enemy)enemy).setPlayer((Player)player);
		((Enemy)enemy).setMap(level.getMap());
		enemyTurn = false;
	}
	
	private void initButton() {
		buttonDown = new ButtonDown(400, 400, ImageLoader.loadImage("/ButtonTest.png"), 160, 160);
		buttonLeft = new ButtonLeft(400-200, 400, ImageLoader.loadImage("/ButtonTest.png"), 160, 160);
		buttonUp = new ButtonUp(400, 400-200, ImageLoader.loadImage("/ButtonTest.png"), 160, 160);
		buttonRight = new ButtonRight(400+200, 400, ImageLoader.loadImage("/ButtonTest.png"), 160, 160);
		buttonDown.setPlayer((Player)player);
		buttonLeft.setPlayer((Player)player);
		buttonUp.setPlayer((Player)player);
		buttonRight.setPlayer((Player)player);
		setButtonMap();
	}
	
	private void setButtonMap() {
		buttonDown.setMap(level.getMap());
		buttonLeft.setMap(level.getMap());
		buttonRight.setMap(level.getMap());
		buttonUp.setMap(level.getMap());
	}
	
	@Override
	public void tick() {
		if(enemyTurn)
			enemy.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(level.getBackground(), 0, 0, null);
		player.render(g);
		enemy.render(g);
		buttonDown.render(g);
		buttonLeft.render(g);
		buttonUp.render(g);
		buttonRight.render(g);
		
	}

}
