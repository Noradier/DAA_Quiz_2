package prison.utils;

public class Map {
	private int V, size;
	private int graph[][];
	
	public Map(int V) {
		this.V = V;
		
		init();
	}
	
	public static void main(String[] args) {
		Map map = new Map(4);
		map.printGraph();
	}
	
	public int[][] getGraph() {
		return graph;
	}
	
	private void init() {
		size = V*V;
		graph = new int[size][size];
		createGraph();
	}
	
	// Inisiasi graph.
	// Nilai diisi mulai dari baris pertama dari kolom satu sampai akhir.
	private void createGraph() {
		for(int i=0; i<size; i++) {
			if(i < V) { 					// Untuk node pada baris pertama map
				if(i%V == 0) { 				// Untuk node pada kolom pertama map
					graph[i][i+1] = 1;
					graph[i][i+V] = 1;
				} else if((i+1)%V == 0) { 	// Untuk node pada kolom akhir map 
					graph[i][i-1] = 1;
					graph[i][i+V] = 1;
				} else {					// Untuk sisanya
					graph[i][i+1] = 1;
					graph[i][i-1] = 1;
					graph[i][i+V] = 1;
				}
			} else if((i+V) > (size-1)) {	// Untuk node pada baris akhir map
				if(i%V == 0) {
					graph[i][i+1] = 1;
					graph[i][i-V] = 1;
				} else if((i+1)%V == 0) {
					graph[i][i-1] = 1;
					graph[i][i-V] = 1;
				} else {
					graph[i][i+1] = 1;
					graph[i][i-1] = 1;
					graph[i][i-V] = 1;
				}
			} else {						// Untuk sisanya
				if(i%V == 0) {
					graph[i][i+1] = 1;
					graph[i][i+V] = 1;
					graph[i][i-V] = 1;
				} else if((i+1)%V == 0) {
					graph[i][i-1] = 1;
					graph[i][i+V] = 1;
					graph[i][i-V] = 1;
				} else {
					graph[i][i+1] = 1;
					graph[i][i-1] = 1;
					graph[i][i+V] = 1;
					graph[i][i-V] = 1;
				}
			}
		}
	}
	
	public void deleteEdge(int i, int j) {
		if(graph[i][j] == 0)
			return;
		
		graph[i][j] = 0;
		graph[j][i] = 0;
	}
	
	public void printGraph() {
		int size = V*V;
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++) {
				System.out.print(graph[i][j]);
				if(j != size-1)
					System.out.print(" ");
				else
					System.out.println();
			}
	}
}
