package prison.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import prison.utils.Clickable;

public class Button extends GameObject implements Clickable {
	private int width;
	private int height;
	
	public Button(int posX, int posY, BufferedImage texture, int width, int height) {
		super(posX, posY, texture);
		this.width = width;
		this.height = height;
	}

	@Override
	public final boolean isInside(int x, int y) {
		if (x >= posX && x <= posX+width && y >= posY && y <= posY+height) return true;
		return false;
	}

	@Override
	public void onClick(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public final void render(Graphics g) {
		g.drawImage(avatar, posX, posY, width, height, null);
	}

}
