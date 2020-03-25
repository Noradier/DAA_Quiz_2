package prison.entity;

import java.awt.image.BufferedImage;

import prison.state.GameState;

public class ButtonLeft extends Button{
	
	public ButtonLeft(int posX, int posY, BufferedImage texture, int width, int height) {
		super(posX, posY, texture, width, height);
	}
	
	@Override
	public void onClick(int x, int y) {
		if(player == null)
			return;
		
		int sizeConst, oldX, oldY, newX, newY;
		sizeConst = 800 / player.getV();
		oldX = player.getPosX() / sizeConst;
		oldY = player.getPosY() / sizeConst;
		newX = oldX - 1;
		newY = oldY;
		
		if(newX < 0)
			return;
		
		if(map.getGraph()
				[oldX + oldY * player.getV()]
						[newX + newY * player.getV()] == 0)
			return;
		
		int newPosition = player.getPosX() - 800 / player.getV();
		player.setPosX(newPosition);
		GameState.enemyTurn = true;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
