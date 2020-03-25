package prison.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import prison.state.GameState;
import prison.utils.Clickable;
import prison.utils.MouseHandler;

@SuppressWarnings("serial")
public class Display{
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
		
		MouseHandler handler = new MouseHandler(this);
		canvas.addMouseListener(handler);
		canvas.addMouseMotionListener(handler);
		canvas.addMouseWheelListener(handler);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void closeFrame() {
		frame.setVisible(false);
		frame.dispose();
	}
	
	public void mousePressed(int x, int y) {
		if(GameState.enemyTurn || GameState.win)
			return;
		
		if(GameState.mainMenu) {
			if(GameState.startPlay.isInside(x, y))
				GameState.startPlay.onClick(x, y);
		} else if(GameState.gameOver) {
			if(GameState.retry.isInside(x, y))
				GameState.retry.onClick(x, y);
			if(GameState.toMainMenu.isInside(x, y))
				GameState.toMainMenu.onClick(x, y);
		} else {
			if(GameState.buttonDown.isInside(x, y))
				GameState.buttonDown.onClick(x, y);
			if(GameState.buttonLeft.isInside(x, y))
				GameState.buttonLeft.onClick(x, y);
			if(GameState.buttonUp.isInside(x, y))
				GameState.buttonUp.onClick(x, y);
			if(GameState.buttonRight.isInside(x, y))
				GameState.buttonRight.onClick(x, y);
		}
		
	}
}
