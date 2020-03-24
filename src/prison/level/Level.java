package prison.level;

import java.awt.image.BufferedImage;

import prison.utils.Map;

public abstract class Level {
	protected Map map;
	public Level(int V) {
		map = new Map(V);
	}
	
	public abstract void makeLevel(Map map1);
	public abstract int[][] getLevel();
	public abstract BufferedImage getBackground();
}
