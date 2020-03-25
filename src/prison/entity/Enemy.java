package prison.entity;

import java.awt.image.BufferedImage;

import prison.state.GameState;
import prison.utils.Map;

public class Enemy extends GameObject {
	private Player player;
	private Map map, dfsMap;
	private int path[];
	private boolean finishedSearch, chaseRight, chaseDown;
	
	public Enemy(int posX, int posY, BufferedImage avatar) {
		super(posX, posY, avatar);
		path = new int[2];
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
		dfsMap = new Map(V);
	}
	
	private void chasePlayer(int vertex, int i, boolean chaseRight, boolean chaseDown) {
		System.out.println("chasePlayer(" + vertex + ", "+ i + ")");
		setEnemyPosition();
		if(i == 2)
			finishedSearch = true;
		
		if(finishedSearch)
			return;
		
		int oldVertexX, oldVertexY, newVertexX, newVertexY;
		oldVertexX = vertex % V;
		oldVertexY = vertex / V;
		
		if(chaseRight) {
			for(int p = oldVertexX + oldVertexY * V; p < (V-1) + oldVertexY * V ; p++) {
				if(dfsMap.getGraph()[vertex][p] == 1) {
					path[i] = p;
					chasePlayer(p, i+1, chaseRight, chaseDown);
				}
			}
		} else {
			for(int p = oldVertexX + oldVertexY * V; p > oldVertexY * V - 1 ; p--) {
				if(dfsMap.getGraph()[vertex][p] == 1) {
					path[i] = p;
					chasePlayer(p, i+1, chaseRight, chaseDown);
				}
			}
		}
		
		if(finishedSearch)
			return;
		
		if(chaseDown) {
			for(int p = oldVertexX + oldVertexY * V; p < V*V ; p+=V) {
				if(dfsMap.getGraph()[vertex][p] == 1) {
					path[i] = p;
					chasePlayer(p, i+1, chaseRight, chaseDown);
				}
			}
		} else {
			for(int p = oldVertexX + oldVertexY * V; p > -1 ; p-=V) {
				if(dfsMap.getGraph()[vertex][p] == 1) {
					path[i] = p;
					chasePlayer(p, i+1, chaseRight, chaseDown);
				}
			}
		}
	}
	
	private void setEnemyPosition() {
		int sizeConst, playerX, playerY, enemyX, enemyY;
		sizeConst = 800 / V;
		playerX = player.getPosX() / sizeConst;
		playerY = player.getPosY() / sizeConst;
		enemyX = posX / sizeConst;
		enemyY = posY / sizeConst;
		
		if(playerX > enemyX)
			chaseRight = true;
		else
			chaseRight = false;
		
		if(playerY > enemyY)
			chaseDown = true;
		else
			chaseDown = false;
	}
	
	private void chasePlayer() {
		int initialVertex = posX * V / 800 + posY * V * V / 800;
		chasePlayer(initialVertex, 0, chaseRight, chaseDown);
	}
	
	@Override
	public void tick() {
		chasePlayer();
		boolean walking = true;
		
		int sizeConst, enemyX, enemyY;
		sizeConst = 800 / V;
		enemyX = posX / sizeConst;
		enemyY = posY / sizeConst;
		
		if(map.getGraph()[enemyX + enemyY * V][path[0]] == 1 && walking) {
			posX = path[0] % V * sizeConst;
			posY = path[0] / V * sizeConst;
		} else
			walking = false;
		
		enemyX = posX / sizeConst;
		enemyY = posY / sizeConst;
		
		if(map.getGraph()[enemyX + enemyY * V][path[1]] == 1 && walking) {
			for(int i=0; i< 18; i++) ;
			posX = path[1] % V * sizeConst;
			posY = path[1] / V * sizeConst;
		}
		
		finishedSearch = false;
		GameState.enemyTurn = false;
	}
}
