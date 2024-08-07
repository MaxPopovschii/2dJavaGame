package main.objects;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Chest extends SuperObject {
	GamePanel gp;

	public Chest(GamePanel gp) {
		this.gp = gp;
		name = "Chest";

		try {
			image = ImageIO.read(getClass().getResourceAsStream("/res/objects/chest.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		collision = true;
	}

}
