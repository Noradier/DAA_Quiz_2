package prison.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	protected int posX, posY;
	protected BufferedImage avatar;
	protected int V;
	
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
	
	public int getV() {
		return V;
	}
	
	public void setV(int V) {
		this.V = V;
	}
	
	public GameObject(int posX, int posY, BufferedImage avatar) {
		this.posX = posX;
		this.posY = posY;
		this.avatar = avatar;
	}
	
	public abstract void tick();
	
	public void render(Graphics g) {
		g.drawImage(avatar, posX, posY, 800/V, 800/V, null);
	}
}
