package prison.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {
	protected int posX, posY;
	protected BufferedImage avatar;
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public Entity(int posX, int posY, BufferedImage avatar) {
		this.posX = posX;
		this.posY = posY;
		this.avatar = avatar;
	}
	
	public abstract void tick();
	
	public void render(Graphics g) {
		g.drawImage(avatar, posX, posY, null);
	}
}
