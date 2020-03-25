package prison.entity;

import java.awt.image.BufferedImage;

import prison.state.GameState;

public class ButtonStart extends Button {

	public ButtonStart(int posX, int posY, BufferedImage texture, int width, int height) {
		super(posX, posY, texture, width, height);
	}

	@Override
	public void onClick(int x, int y) {
		GameState.level1 = true;
	}

	@Override
	public void tick() {
		
	}

}
