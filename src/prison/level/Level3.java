package prison.level;

import java.awt.image.BufferedImage;

import prison.utils.ImageLoader;
import prison.utils.Map;

public class Level3 {

	private Map map;
	public static BufferedImage bg;
	public Level3() {
		map = new Map(4);
		makeLevel(map);
		bg = ImageLoader.loadImage("/Level3.png");
	}
//	public static void main(String[] args) {
//		Map mapa = new Map(4);
//		makeLevel(mapa);
//		mapa.printGraph();
//	}
	private static void makeLevel(Map map1)
	{
		map1.deleteEdge(4, 5);
		map1.deleteEdge(8, 9);
		map1.deleteEdge(5, 9);
		map1.deleteEdge(9, 10);
		map1.deleteEdge(10, 11);
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
