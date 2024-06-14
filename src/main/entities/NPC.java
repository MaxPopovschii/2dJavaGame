package main.entities;

import java.util.Random;

import main.GamePanel;

public class NPC extends Entity {

	public NPC(GamePanel gp) {
		super(gp);
		direction = "down";
		speed = 1;
		setImage();
		setDialogue();
	}

	public void setImage() {
		up1 = setup("/res/npc/oldman_up_1.png");
		up2 = setup("/res/npc/oldman_up_2.png");
		down1 = setup("/res/npc/oldman_down_1.png");
		down2 = setup("/res/npc/oldman_down_2.png");
		left1 = setup("/res/npc/oldman_left_1.png");
		left2 = setup("/res/npc/oldman_left_2.png");
		right1 = setup("/res/npc/oldman_right_1.png");
		right2 = setup("/res/npc/oldman_right_2.png");

	}

	public void setDialogue() {
		dialogues[0] = "Hello, hero. So you've come to this \nisland to find some treasure?";
		dialogues[1] = "I used to be a great wizard but now ... \nI'm a bit too old for taking an adventure.";
		dialogues[2] = "Well, good luck for you.";
	}

	public void setAction() {

		actionLockCounter++;

		if (actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1;

			if (i <= 25) {
				direction = "up";
			}
			if (i > 25 && i <= 50) {
				direction = "down";
			}
			if (i > 50 && i <= 75) {
				direction = "left";
			}
			if (i > 75) {
				direction = "right";
			}
			actionLockCounter = 0;

		}

	}

	public void speak() {
		if (dialogues[dialogueIndex] == null) {
			dialogueIndex = 0;
		}
		gp.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;

		switch (gp.player.direction) {
			case "up":
				gp.player.direction = "down";
				break;
			case "down":
				gp.player.direction = "up";
				break;
			case "left":
				gp.player.direction = "right";
				break;
			case "right":
				gp.player.direction = "left";
				break;
		}
	}
}
