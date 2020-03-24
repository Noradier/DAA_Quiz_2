package prison.state;

import java.awt.Graphics;
import prison.entity.Button;
import prison.entity.ButtonDown;
import prison.entity.ButtonLeft;
import prison.entity.ButtonRight;
import prison.entity.ButtonUp;
import prison.entity.GameObject;
import prison.entity.Player;
import prison.level.Level;
import prison.level.Level1;
import prison.level.Level2;
import prison.main.Asset;
import prison.main.Game;
import prison.utils.ImageLoader;

public class GameState extends State {
	private Level level;
	public static Button buttonDown;
	public static Button buttonLeft;
	public static Button buttonUp;
	public static Button buttonRight;
	private GameObject player, enemy;
	
	public GameState(Game game) {
		super(game);
		buttonDown = new ButtonDown(400, 400, ImageLoader.loadImage("/ButtonTest.png"), 160, 160);
		buttonLeft = new ButtonLeft(400-200, 400, ImageLoader.loadImage("/ButtonTest.png"), 160, 160);
		buttonUp = new ButtonUp(400, 400-200, ImageLoader.loadImage("/ButtonTest.png"), 160, 160);
		buttonRight = new ButtonRight(400+200, 400, ImageLoader.loadImage("/ButtonTest.png"), 160, 160);
		level = new Level1();
//		player = new Player(0, 0, Asset.player);
//		player.setV(level.getV());
		buttonDown.setPlayer((Player)player);
		buttonLeft.setPlayer((Player)player);
		buttonUp.setPlayer((Player)player);
		buttonRight.setPlayer((Player)player);
	}
	
	@Override
	public void tick() {
		//Insert stage.tick(), player.tick(), dan enemy.tick() 
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(level.getBackground(), 0, 0, null);
//		player.render(g);
		buttonDown.render(g);
		buttonLeft.render(g);
		buttonUp.render(g);
		buttonRight.render(g);
		// Insert player.render() dan enemy.render()
	}

}
