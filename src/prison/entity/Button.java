package prison.entity;

import java.awt.image.BufferedImage;

import prison.utils.Clickable;

public abstract class Button extends GameObject implements Clickable {
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
	public abstract void onClick(int x, int y);
}
