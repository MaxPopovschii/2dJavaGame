package main.objects;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Boots extends SuperObject {
	GamePanel gp;

	public Boots(GamePanel gp) {
		this.gp = gp;
		name = "Boots";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/res/objects/boots.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
