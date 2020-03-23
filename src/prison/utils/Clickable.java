package prison.utils;

public interface Clickable {
	
	public void onClick(int x, int y);
	
	public boolean isInside(int x, int y);
}