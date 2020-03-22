package prison.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import prison.main.Asset;
import prison.main.Game;

public class GameState extends State {
	
	private BufferedImage testImage;
	
	public GameState(Game game) {
		super(game);
		
		testImage = Asset.player;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 400);
		
		g.drawImage(testImage, 100, 100, null);
	}

}
