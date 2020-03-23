package prison.entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class EntityPlayer extends Entity implements KeyListener{
	private boolean[] keys;
	
	public EntityPlayer(int posX, int posY, BufferedImage avatar) {
		super(posX, posY, avatar);
		keys = new boolean[256];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
