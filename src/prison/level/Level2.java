package prison.level;

import java.awt.image.BufferedImage;

import prison.utils.ImageLoader;
import prison.utils.Map;

public class Level2 extends Level{
	public Level2() {
		super(4, "/Level2.png");
		makeLevel(map);
	}
//	public static void main(String[] args) {
//		Map mapa = new Map(4);
//		makeLevel(mapa);
//		mapa.printGraph();
//	}
	@Override
	public void makeLevel(Map map1)
	{
		map1.deleteEdge(1, 2);
		map1.deleteEdge(5, 6);
		map1.deleteEdge(6, 10);
		map1.deleteEdge(6, 7);
		map1.deleteEdge(7, 11);
	}
}
