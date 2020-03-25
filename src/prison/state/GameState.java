package prison.state;

import java.awt.Color;
import java.awt.Graphics;
import prison.entity.*;
import prison.level.*;
import prison.main.Asset;
import prison.main.Game;
import prison.utils.ImageLoader;

public class GameState extends State {
	private Level level;
	public static Button buttonDown, buttonLeft, buttonUp, buttonRight, startPlay, toMainMenu, retry;
	private GameObject player, enemy;
	public static boolean enemyTurn, levelCompleted, gameOver, mainMenu,
		level1, level2, level3, level4, level5,
		finish1, finish2, finish3, finish4, finish5,
		win;
	
	public GameState(Game game) {
		super(game);
		
		level = new Menu();
		mainMenu = true;
		gameOver = false;
		initPlayer();
		initEnemy();
		initMainButton();
	}
	
	private void initPlayer() {
		player = new Player(0, 0, Asset.player);
		player.setV(level.getMap().getV());
	}
	
	private void initEnemy() {
		int newPos = 800 / level.getMap().getV() * (level.getMap().getV() - 1);
		enemy = new Enemy(newPos, newPos, Asset.enemy);
		enemy.setV(level.getMap().getV());
		enemyTurn = false;
	}
	
	private void initMainButton() {
		buttonDown = new ButtonDown(900, 350, Asset.buttonDown, 100, 100);
		buttonLeft = new ButtonLeft(900-100, 350, Asset.buttonLeft, 100, 100);
		buttonUp = new ButtonUp(900, 350-100, Asset.buttonUp, 100, 100);
		buttonRight = new ButtonRight(900+100, 350, Asset.buttonRight, 100, 100);
		buttonDown.setPlayer((Player)player);
		buttonLeft.setPlayer((Player)player);
		buttonUp.setPlayer((Player)player);
		buttonRight.setPlayer((Player)player);
		setButtonMap();
		startPlay = new ButtonStart(300, 310, null, 150, 150);
		retry = new ButtonReplay(240, 485, null, 150, 150);
		toMainMenu = new ButtonHome(420, 485, null, 150, 150);
	}
	
	private void setButtonMap() {
		buttonDown.setMap(level.getMap());
		buttonLeft.setMap(level.getMap());
		buttonRight.setMap(level.getMap());
		buttonUp.setMap(level.getMap());
	}
	
	private void toGameOver() {
		gameOver = true;
		if(level instanceof Level1)
			((ButtonReplay)retry).setLevel("level1");
		if(level instanceof Level2)
			((ButtonReplay)retry).setLevel("level2");
		if(level instanceof Level3)
			((ButtonReplay)retry).setLevel("level3");
		if(level instanceof Level4)
			((ButtonReplay)retry).setLevel("level4");
		if(level instanceof Level5)
			((ButtonReplay)retry).setLevel("level5");
		level1 = false;
		level2 = false;
		level3 = false;
		level4 = false;
		level5 = false;
		level = new GameOver();
	}
	
	public void openLevel1() {
		level = new Level1();
		player.setPosX(480); player.setPosY(0);
		player.setV(level.getMap().getV());
		enemy.setPosX(0); enemy.setPosY(160);
		((Enemy)enemy).setPlayer((Player)player);
		((Enemy)enemy).setMap(level.getMap());
		enemy.setV(level.getMap().getV());
		setButtonMap();
	}
	
	public void openLevel2() {
		level = new Level2();
		player.setPosX(600); player.setPosY(600);
		player.setV(level.getMap().getV());
		enemy.setPosX(200); enemy.setPosY(200);
		((Enemy)enemy).setPlayer((Player)player);
		((Enemy)enemy).setMap(level.getMap());
		enemy.setV(level.getMap().getV());
		setButtonMap();
	}
	
	public void openLevel3() {
		level = new Level3();
		player.setPosX(400); player.setPosY(400);
		player.setV(level.getMap().getV());
		enemy.setPosX(600); enemy.setPosY(0);
		((Enemy)enemy).setPlayer((Player)player);
		((Enemy)enemy).setMap(level.getMap());
		enemy.setV(level.getMap().getV());
		setButtonMap();
	}
	
	public void openLevel4() {
		level = new Level4();
		player.setPosX(160); player.setPosY(0);
		player.setV(level.getMap().getV());
		enemy.setPosX(640); enemy.setPosY(320);
		((Enemy)enemy).setPlayer((Player)player);
		((Enemy)enemy).setMap(level.getMap());
		enemy.setV(level.getMap().getV());
		setButtonMap();
	}
	
	public void openLevel5() {
		level = new Level5();
		player.setPosX(3 * 800 / 6); player.setPosY( 4 * 800 / 6);
		player.setV(level.getMap().getV());
		enemy.setPosX(5 * 800 / 6); enemy.setPosY(2 * 800 / 6);
		((Enemy)enemy).setPlayer((Player)player);
		((Enemy)enemy).setMap(level.getMap());
		enemy.setV(level.getMap().getV());
		setButtonMap();
	}
	
	@Override
	public void tick() {
		if(win)
			return;
		
		if(mainMenu) {
			if(level1) {
				mainMenu = false;
				openLevel1();
			}
		}
		
		if(level1) {
			if(player.getPosX() == 160 && player.getPosY() == 0)
				finish1 = true;
			else
				finish1 = false;
			if(level2) {
				level1 = false;
				openLevel2();
			}
		}
		
		if(level2) {
			if(player.getPosX() == 600 && player.getPosY() == 0)
				finish2 = true;
			else
				finish2 = false;
			if(level3) {
				level2 = false;
				openLevel3();
			}
		}
		
		if(level3) {
			if(player.getPosX() == 0 && player.getPosY() == 600)
				finish3 = true;
			else
				finish3 = false;
			if(level4) {
				level3 = false;
				openLevel4();
			}
		}
		
		if(level4) {
			if(player.getPosX() == 640 && player.getPosY() == 320)
				finish4 = true;
			else
				finish4 = false;
			if(level5) {
				level4 = false;
				openLevel5();
			}
		}
		
		if(level5) {
			if(player.getPosX() >= 666 && player.getPosY() == 0)
				finish5 = true;
			else
				finish5 = false;
			if(win) {
				level5 = false;
				return;
			}
		}
		
		if(gameOver) {
			if(mainMenu) {
				level = new Menu();
				mainMenu = true;
				gameOver = false;
			}
			if(level1) {
				gameOver = false;
				openLevel1();
			}
			if(level2) {
				gameOver = false;
				openLevel2();
			}
			if(level3) {
				gameOver = false;
				openLevel3();
			}
			if(level4) {
				gameOver = false;
				openLevel4();
			}
			if(level5) {
				gameOver = false;
				openLevel5();
			}
		}
		
		if(!gameOver && !mainMenu) {
			if(enemyTurn) {
				enemy.tick();
			}
				
			if(player.getPosX() == enemy.getPosX() && player.getPosY() == enemy.getPosY())
				toGameOver();
		}
	}

	@Override
	public void render(Graphics g) {
		if(win)
			g.drawImage(Asset.winScreen, 0, 0, null);
		else {
			g.drawImage(level.getBackground(), 0, 0, null);
			if(!gameOver && !mainMenu) {
				player.render(g);
				enemy.render(g);
				buttonDown.render(g);
				buttonLeft.render(g);
				buttonUp.render(g);
				buttonRight.render(g);
			}
		}
//		g.setColor(Color.BLACK);
//		g.fillRect(420, 485, 150, 150);
	}

}
