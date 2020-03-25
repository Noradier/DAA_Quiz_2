package prison.entity;

import java.awt.image.BufferedImage;

import prison.state.GameState;
import prison.utils.Map;

public class Enemy extends GameObject {
	private Player player;
	private Map map, dfsMap;
	private Path path;
	
	public Enemy(int posX, int posY, BufferedImage avatar) {
		super(posX, posY, avatar);
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	@Override
	public void setV(int V) {
		super.setV(V);
		path = new Path(V);
		dfsMap = new Map(V);
	}
	
	private void chasePlayer(int vertex, int dest) {
		if(posX < player.getPosX()) {
			if(vertex + 1 < V*V)
				if(map.getGraph()[vertex][vertex + 1] == 1)
					path.firstPath = vertex + 1;
			if(path.firstPath == -1)
				if(vertex - 1 > -1)
					if(map.getGraph()[vertex][vertex - 1] == 1)
						path.firstPath = vertex - 1;
		} else if(posX > player.getPosX()) {
			if(vertex - 1 > -1)
				if(map.getGraph()[vertex][vertex - 1] == 1)
					path.firstPath = vertex - 1;
			if(path.firstPath == -1)
				if(vertex + 1 < V*V)
					if(map.getGraph()[vertex][vertex + 1] == 1)
						path.firstPath = vertex + 1;
		} else {
			if(path.firstPath == -1)
				if(vertex - 1 > -1)
					if(map.getGraph()[vertex][vertex - 1] == 1)
						path.firstPath = vertex - 1;
			if(path.firstPath == -1)
				if(vertex + 1 < V*V)
					if(map.getGraph()[vertex][vertex + 1] == 1)
						path.firstPath = vertex + 1;
		}
		
		if(path.firstPath == -1) {
			path.visited[vertex] = 0;
			dfs(-1, -1, 0, vertex, dest);
		}
		else {
			path.visited[vertex] = 0;
			dfs(-1, 0, path.firstPath, dest);
		}
			
	}
	
	private void dfs(int secondPath, int distance, int vertex, int dest) {
		for(int i=0; i<V*V; i++) {
			if(map.getGraph()[vertex][i] == 0)
				continue;
			
			if(map.getGraph()[vertex][dest] == 1) {
				if(distance < path.visited[dest] || path.visited[dest] == -1) {
					if(secondPath == -1) {
						path.secondPath = dest;
						path.visited[i] = distance;
						return;
					}
					path.secondPath = secondPath;
					path.visited[dest] = distance;
					return;
				}
			}
			
			if(map.getGraph()[vertex][i] == 1
					&& (distance < path.visited[i] || path.visited[i] == -1)) {
				path.visited[i] = distance;
				if(secondPath == -1)
					dfs(i, distance+1, i, dest);
				else
					dfs(secondPath, distance+1, i, dest);
			}
		}
	}
	
	private void dfs(int firstPath, int secondPath, int distance, int vertex, int dest) {
		for(int i=0; i< V*V; i++) {
			if(map.getGraph()[vertex][i] == 0)
				continue;
			
			if(map.getGraph()[vertex][dest] == 1) {
				if(distance < path.visited[dest] || path.visited[dest] == -1) {
					if(firstPath == -1) {
						path.firstPath = dest;
						path.visited[dest] = distance;
						return;
					}
					if(secondPath == -1) {
						path.secondPath = dest;
						path.visited[dest] = distance;
						return;
					}
					path.firstPath = firstPath;
					path.secondPath = secondPath;
					path.visited[dest] = distance;
					return;
				}
			}
			
			if(map.getGraph()[vertex][i] == 1 
					&& (distance < path.visited[i] || path.visited[i] == -1)) {
				path.visited[i] = distance;
				if(firstPath == -1)
					dfs(i, -1, distance+1, i, dest);
				else if(secondPath == -1)
					dfs(firstPath, i, distance+1, i, dest);
				else
					dfs(firstPath, secondPath, distance+1, i, dest);
			}
		}
	}
	
	private void chasePlayer() {
		int initVertex = posX * V / 800 + posY * V * V / 800;
		int destVertex = player.getPosX() * V / 800 + player.getPosY() * V * V / 800;
		path.resetPath();
		chasePlayer(initVertex, destVertex);
	}
	
	@Override
	public void tick() {
		chasePlayer();
		boolean walking = true;
		
		int sizeConst, enemyX, enemyY;
		if(V == 6)
			sizeConst = 133;
		else
			sizeConst = 800 / V;
		
		if(path.firstPath != -1) {
			enemyX = posX / sizeConst;
			enemyY = posY / sizeConst;
			if(map.getGraph()[enemyX + enemyY * V][path.firstPath] == 1 && walking) {
				posX = path.firstPath % V * sizeConst;
				posY = path.firstPath / V * sizeConst;
			} else
				walking = false;
		}
		
		if(posX == player.getPosX() && posY == player.getPosY()) {
			GameState.enemyTurn = false;
			return;
		}
		
		if(path.secondPath != -1) {
			enemyX = posX / sizeConst;
			enemyY = posY / sizeConst;
			if(map.getGraph()[enemyX + enemyY * V][path.secondPath] == 1 && walking) {
				posX = path.secondPath % V * sizeConst;
				posY = path.secondPath / V * sizeConst;
			}
		}
		
		GameState.enemyTurn = false;
	}
	
	class Path{
		public int firstPath;
		public int secondPath;
		public int visited[];
		
		public Path(int V) {
			visited = new int[V*V];
			resetPath();
		}
		
		public void resetPath() {
			firstPath = -1;
			secondPath = -1;
			for(int i=0; i<visited.length; i++)
				visited[i] = -1;
		}
	}
}
