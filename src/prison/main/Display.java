package prison.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import prison.utils.Clickable;
import prison.utils.MouseHandler;

@SuppressWarnings("serial")
public class Display extends JPanel{
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
		MouseHandler handler = new MouseHandler(this);
		addMouseListener(handler);
		addMouseMotionListener(handler);
		addMouseWheelListener(handler);
		
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
	}
}
