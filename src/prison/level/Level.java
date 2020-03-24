package prison.level;

import java.awt.image.BufferedImage;

import prison.main.Asset;
import prison.utils.ImageLoader;
import prison.utils.Map;

public abstract class Level {
	protected Map map;
	protected BufferedImage bg;
	public Level(int V, String path) {
		map = new Map(V);
		bg = ImageLoader.loadImage(path);
		Asset.background = bg;
	}
	
	public abstract void makeLevel(Map map1);
	public int[][] getLevel()
	{
		return map.getGraph();
	}
	public BufferedImage getBackground()
	{
		return bg;
	}
}
