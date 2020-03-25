package prison.level;

import prison.utils.Map;

public class Level5 extends Level{

	public Level5()
	{
		super(6, "/Level5.png");
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
		map1.deleteEdge(3, 4);
		map1.deleteEdge(2, 8);
		map1.deleteEdge(8, 9);
		map1.deleteEdge(16, 17);
		map1.deleteEdge(20, 21);
		map1.deleteEdge(21, 22);
		map1.deleteEdge(22, 23);
		map1.deleteEdge(24, 25);
		map1.deleteEdge(24, 30);
		map1.deleteEdge(31, 32);
		map1.deleteEdge(32, 33);
	}
}
