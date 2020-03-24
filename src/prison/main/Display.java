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
//		for (Renderable renderObject : scenes.get(currentScene).getSceneObjects()) {
//			if (renderObject instanceof Clickable) {
//				Clickable inputObject = (Clickable)renderObject;
//				if (inputObject.isInside(x, y)) {
//					inputObject.onClick(x, y);
//				}
//			}
//		}
//		repaint();
		
		if(GameState.buttonDown.isInside(x, y))
			GameState.buttonDown.onClick(x, y);
		
		System.out.println("TESST");
	}
}
