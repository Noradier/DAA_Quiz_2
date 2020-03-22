package prison.launcher;

import prison.main.Game;

public class GameLauncher {
	
	public static void main(String[] args) {
		Game game = new Game("Title", 800, 800);
		game.start();
	}
}