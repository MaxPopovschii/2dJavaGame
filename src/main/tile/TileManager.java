package main.tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	GamePanel gp;
	public Tile[] tiles;
	public int mapTileNum[][];

	public TileManager(GamePanel gp) {
		this.gp = gp;

		tiles = new Tile[50];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

		getTileImage();
		loadMap("/res/maps/worldV2.txt");
	}

	public void getTileImage() {
		try {
			tiles[0] = new Tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[0].collision = false;
			tiles[1] = new Tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[1].collision = false;
			tiles[2] = new Tile();
			tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[2].collision = false;
			tiles[3] = new Tile();
			tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[3].collision = false;
			tiles[4] = new Tile();
			tiles[4].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[4].collision = false;
			tiles[5] = new Tile();
			tiles[5].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[5].collision = false;
			tiles[6] = new Tile();
			tiles[6].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[6].collision = false;
			tiles[7] = new Tile();
			tiles[7].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[7].collision = false;
			tiles[8] = new Tile();
			tiles[8].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[8].collision = false;
			tiles[9] = new Tile();
			tiles[9].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[9].collision = false;

			tiles[10] = new Tile();
			tiles[10].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass00.png"));
			tiles[10].collision = false;

			tiles[11] = new Tile();
			tiles[11].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/grass01.png"));
			tiles[11].collision = false;

			tiles[12] = new Tile();
			tiles[12].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water00.png"));
			tiles[12].collision = true;

			tiles[13] = new Tile();
			tiles[13].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water01.png"));
			tiles[13].collision = true;

			tiles[14] = new Tile();
			tiles[14].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water02.png"));
			tiles[14].collision = true;

			tiles[15] = new Tile();
			tiles[15].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water03.png"));
			tiles[15].collision = true;

			tiles[16] = new Tile();
			tiles[16].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water04.png"));
			tiles[16].collision = true;

			tiles[17] = new Tile();
			tiles[17].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water05.png"));
			tiles[17].collision = true;

			tiles[18] = new Tile();
			tiles[18].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water06.png"));
			tiles[18].collision = true;

			tiles[19] = new Tile();
			tiles[19].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water07.png"));
			tiles[19].collision = true;

			tiles[20] = new Tile();
			tiles[20].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water08.png"));
			tiles[20].collision = true;

			tiles[21] = new Tile();
			tiles[21].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water09.png"));
			tiles[21].collision = true;

			tiles[22] = new Tile();
			tiles[22].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water10.png"));
			tiles[22].collision = true;

			tiles[23] = new Tile();
			tiles[23].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water11.png"));
			tiles[23].collision = true;

			tiles[24] = new Tile();
			tiles[24].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water12.png"));
			tiles[24].collision = true;

			tiles[25] = new Tile();
			tiles[25].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/water13.png"));
			tiles[25].collision = true;

			tiles[26] = new Tile();
			tiles[26].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road00.png"));
			tiles[26].collision = false;

			tiles[27] = new Tile();
			tiles[27].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road01.png"));
			tiles[27].collision = false;

			tiles[28] = new Tile();
			tiles[28].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road02.png"));
			tiles[28].collision = false;

			tiles[29] = new Tile();
			tiles[29].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road03.png"));
			tiles[29].collision = false;

			tiles[30] = new Tile();
			tiles[30].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road04.png"));
			tiles[30].collision = false;

			tiles[31] = new Tile();
			tiles[31].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road05.png"));
			tiles[31].collision = false;

			tiles[32] = new Tile();
			tiles[32].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road06.png"));
			tiles[32].collision = false;

			tiles[33] = new Tile();
			tiles[33].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road07.png"));
			tiles[33].collision = false;

			tiles[34] = new Tile();
			tiles[34].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road08.png"));
			tiles[34].collision = false;

			tiles[35] = new Tile();
			tiles[35].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road09.png"));
			tiles[35].collision = false;

			tiles[36] = new Tile();
			tiles[36].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road10.png"));
			tiles[36].collision = false;

			tiles[37] = new Tile();
			tiles[37].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road11.png"));
			tiles[37].collision = false;

			tiles[38] = new Tile();
			tiles[38].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/road12.png"));
			tiles[38].collision = false;

			tiles[39] = new Tile();
			tiles[39].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/earth.png"));
			tiles[39].collision = false;

			tiles[40] = new Tile();
			tiles[40].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/wall.png"));
			tiles[40].collision = true;

			tiles[41] = new Tile();
			tiles[41].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/new/tree.png"));
			tiles[41].collision = true;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadMap(String map) {
		try {

			InputStream is = getClass().getResourceAsStream(map);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();

				while (col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);

					mapTileNum[col][row] = num;
					col++;
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2) {
		int worldCol = 0;
		int worldRow = 0;

		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

			int tileNum = mapTileNum[worldCol][worldRow];

			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;

			if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
					worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
					worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
					worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
				g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			}

			worldCol++;

			if (worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}
		}
	}
}
