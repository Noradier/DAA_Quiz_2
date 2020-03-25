package prison.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import prison.utils.Clickable;
import prison.utils.Map;

public abstract class Button extends GameObject implements Clickable {
	protected int width;
	protected int height;
	protected Player player;
	protected Map map;
	
	public Button(int posX, int posY, BufferedImage texture, int width, int height) {
		super(posX, posY, texture);
		this.width = width;
		this.height = height;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	@Override
	public final boolean isInside(int x, int y) {
		if (x >= posX && x <= posX+width && y >= posY && y <= posY+height) return true;
		return false;
	}
	
	@Override
	public final void render(Graphics g) {
		g.drawImage(avatar, posX, posY, width, height, null);
	}

}
