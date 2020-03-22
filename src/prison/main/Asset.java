package prison.main;

import java.awt.image.BufferedImage;
import prison.utils.ImageLoader;

public class Asset {
	public static BufferedImage
		player, enemy;
	
	public static void init() {
		player = ImageLoader.loadImage("/testpng.png");
		enemy = ImageLoader.loadImage("/enemy.png");
	}
}
