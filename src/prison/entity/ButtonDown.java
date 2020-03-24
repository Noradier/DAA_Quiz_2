package prison.entity;

import java.awt.image.BufferedImage;

public class ButtonDown extends Button{
	
	public ButtonDown(int posX, int posY, BufferedImage texture, int width, int height) {
		super(posX, posY, texture, width, height);
	}
	
	@Override
	public void onClick(int x, int y) {
//		if(player.getPosY() + 800 / player.getV() < 800)
//			player.setPosY(player.getPosY() + 800 / player.getV());
		System.out.println("Test" /*+ player.getPosY()*/);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
