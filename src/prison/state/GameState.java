package prison.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import prison.main.Asset;
import prison.main.Game;

public class GameState extends State {
	private BufferedImage background;
	
	public GameState(Game game) {
		super(game);
		
		background = Asset.background;
	}

	@Override
	public void tick() {
		//Insert stage.render(), player.render(), dan enemy.render() 
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, null);
		
		// Insert player.render() dan enemy.render()
	}

}
