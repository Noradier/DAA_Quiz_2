package prison.entity;

import java.awt.image.BufferedImage;

import prison.state.GameState;

public class ButtonReplay extends Button {
	
	private String level;
	
	public ButtonReplay(int posX, int posY, BufferedImage texture, int width, int height) {
		super(posX, posY, texture, width, height);
		// TODO Auto-generated constructor stub
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return level;
	}
	
	@Override
	public void onClick(int x, int y) {
		if(level == "level1")
			GameState.level1 = true;
		if(level == "level2")
			GameState.level2 = true;
		if(level == "level3")
			GameState.level3 = true;
		if(level == "level4")
			GameState.level4 = true;
		if(level == "level5")
			GameState.level5 = true;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
