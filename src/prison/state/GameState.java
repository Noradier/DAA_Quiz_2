package prison.state;

import java.awt.Color;
import java.awt.Graphics;

import prison.main.Game;

public class GameState extends State {
	
	public GameState(Game game) {
		super(game);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 400);
	}

}
