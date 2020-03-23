package prison.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject {

	public Enemy(int posX, int posY, BufferedImage avatar) {
		super(posX, posY, avatar);
	}

	// Perlu Fungsi mencari shortest path
	
	@Override
	public void tick() {
		
	}

}
