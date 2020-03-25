package prison.level;

import prison.utils.Map;

public class Level4 extends Level {
	public Level4()
	{
		super(5, "/Level4.png");
		makeLevel(map);
	}
//	public static void main(String[] args) {
//		Map mapa = new Map(5);
//		makeLevel(mapa);
//		mapa.printGraph();
//	}
	@Override
	public void makeLevel(Map map1)
	{
		map1.deleteEdge(1, 2);
		map1.deleteEdge(5, 6);
		map1.deleteEdge(5, 10);
		map1.deleteEdge(6, 11);
		map1.deleteEdge(7, 8);
		map1.deleteEdge(8, 9);
		map1.deleteEdge(9, 14);
		map1.deleteEdge(11, 12);
		map1.deleteEdge(11, 16);
		map1.deleteEdge(12, 17);
		map1.deleteEdge(12, 13);
		map1.deleteEdge(13, 14);
		map1.deleteEdge(17, 22);
		map1.deleteEdge(18, 23);
		map1.deleteEdge(18, 19);
	}

}
