package pacman.launcher;

import pacman.main.Game;

public class GameLauncher {
	
	public static void main(String[] args) {
		Game game = new Game("Title", 800, 600);
		game.start();
	}
}
