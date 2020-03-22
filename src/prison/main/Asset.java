package prison.main;

import java.awt.image.BufferedImage;
import prison.utils.ImageLoader;

public class Asset {
	public static BufferedImage
		player, enemy, background;
	
	public static void init() {
		player = ImageLoader.loadImage("/penjahat_1.png");
		enemy = ImageLoader.loadImage("/polisi_1.png");
		background = ImageLoader.loadImage("/tiles.png");
	}
}
