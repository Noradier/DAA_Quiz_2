package prison.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class EntityEnemy extends Entity {

	public EntityEnemy(int posX, int posY, BufferedImage avatar) {
		super(posX, posY, avatar);
	}

	// Perlu Fungsi mencari shortest path
	
	@Override
	public void tick() {
		
	}

}
