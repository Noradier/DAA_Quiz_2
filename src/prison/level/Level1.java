package prison.level;

import java.awt.image.BufferedImage;

import prison.utils.ImageLoader;
import prison.utils.Map;

public class Level1 extends Level {
	
	public static BufferedImage bg;
	public Level1()
	{
		super(5);
		makeLevel(map);
		bg = ImageLoader.loadImage("/Level1.png");
	}
//	public static void main(String[] args) {
//		Map mapa = new Map(5);
//		makeLevel(mapa);
//		mapa.printGraph();
//	}
	public void makeLevel(Map map1)
	{
		map1.deleteEdge(5, 6);
		map1.deleteEdge(1, 6);
		map1.deleteEdge(3, 4);
		map1.deleteEdge(7, 8);
		map1.deleteEdge(8, 13);
		map1.deleteEdge(11, 12);
		map1.deleteEdge(15, 16);
		map1.deleteEdge(16, 21);
		map1.deleteEdge(16, 17);
		map1.deleteEdge(12, 17);
		map1.deleteEdge(13, 18);
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
