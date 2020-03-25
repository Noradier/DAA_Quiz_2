package prison.entity;

import java.awt.image.BufferedImage;

import prison.state.GameState;

public class ButtonHome extends Button {

	public ButtonHome(int posX, int posY, BufferedImage texture, int width, int height) {
		super(posX, posY, texture, width, height);
	}

	@Override
	public void onClick(int x, int y) {
		GameState.mainMenu = true;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
