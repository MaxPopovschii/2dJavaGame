package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.entities.Entity;
import main.entities.Player;
import main.objects.SuperObject;
import main.tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	// screen settings
	final int originalTileSize = 16; // 16x16 size
	final int scale = 3; // mult for size
	public final int tileSize = originalTileSize * scale; // 48x48 px
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 768 px
	public final int screenHeight = tileSize * maxScreenRow; // 576 px

	// world settings
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;

	// FPS
	final int FPS = 60;

	// System
	TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	Sound music = new Sound();
	Sound se = new Sound();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);

	// Entities and objects
	public Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[100];
	public Entity[] npc = new Entity[10];

	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		setupGame();
	}

	public void setupGame() {

		aSetter.setObject();
		aSetter.setNPC();
		gameState = playState;
		playMusic(0);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta > 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}

	public void update() {
		if (gameState == playState) {
			player.update();

			for (int i = 0; i < npc.length; i++) {
				if (npc[i] != null) {
					npc[i].update();
				}
			}
		}
		if (gameState == pauseState) {

		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// DEBUG
		long drawStart = 0;
		if (keyH.checkDrawTime) {
			drawStart = System.nanoTime();
		}

		// TILEMAP
		tileM.draw(g2);

		// OBJECTS
		for (SuperObject o : obj) {
			if (o != null) {
				o.draw(g2, this);
			}

		}

		// PLAYER
		player.draw(g2);

		for (Entity e : npc) {
			if (e != null) {
				e.draw(g2);
			}
		}

		// UI
		ui.draw(g2);

		// DEBUG
		if (keyH.checkDrawTime) {
			long drawEnd = 0;
			drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.WHITE);
			g2.drawString("Draw Time: " + passed, 10, 400);
			System.out.println(passed);
		}

		g2.dispose();
	}

	public void playMusic(int i) {

		music.setFile(i);
		music.play();
		music.loop();
	}

	public void stopMusic() {
		music.stop();
	}

	public void playSE(int i) {

		se.setFile(i);
		se.play();
	}
}
