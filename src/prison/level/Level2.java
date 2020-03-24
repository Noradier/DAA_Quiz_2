package prison.level;

import java.awt.image.BufferedImage;

import prison.utils.ImageLoader;
import prison.utils.Map;

public class Level2 {
	private Map map;
	public static BufferedImage bg;
	public Level2() {
		map = new Map(4);
		makeLevel(map);
		bg = ImageLoader.loadImage("/Level2.png");
	}
//	public static void main(String[] args) {
//		Map mapa = new Map(4);
//		makeLevel(mapa);
//		mapa.printGraph();
//	}
	private static void makeLevel(Map map1)
	{
		map1.deleteEdge(1, 2);
		map1.deleteEdge(5, 6);
		map1.deleteEdge(6, 10);
		map1.deleteEdge(6, 7);
		map1.deleteEdge(7, 11);
	}
	public int[][] getLevel()
	{
		return map.getGraph();
	}
	public BufferedImage getBackground()
	{
		return bg;
	}
}
