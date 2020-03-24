package prison.main;

import java.awt.image.BufferedImage;
import prison.utils.ImageLoader;

public class Asset {
	public static BufferedImage
		player, enemy, background, buttonLeft, buttonUp, buttonRight, buttonDown;
	
	public static void init() {
		player = ImageLoader.loadImage("/penjahat_1.png");
		enemy = ImageLoader.loadImage("/polisi_1.png");
		background = ImageLoader.loadImage("/tiles.png");
//		buttonLeft = ImageLoader.loadImage(path);
//		buttonUp = ImageLoader.loadImage(path);
//		buttonRight = ImageLoader.loadImage(path);
//		buttonDown = ImageLoader.loadImage(path);
	}
}
