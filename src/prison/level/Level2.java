package prison.level;

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
		map1.deleteEdge(0, 1);
		map1.deleteEdge(4, 5);
		map1.deleteEdge(5, 9);
		map1.deleteEdge(5, 6);
		map1.deleteEdge(6, 10);
	}
}
