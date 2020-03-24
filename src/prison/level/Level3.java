package prison.level;

import java.awt.image.BufferedImage;

import prison.utils.ImageLoader;
import prison.utils.Map;

public class Level3 extends Level{
	public Level3() {
		super(4, "/Level3.png");
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
		map1.deleteEdge(4, 5);
		map1.deleteEdge(8, 9);
		map1.deleteEdge(5, 9);
		map1.deleteEdge(9, 10);
		map1.deleteEdge(10, 11);
		map1.deleteEdge(7, 11);
	}
}
