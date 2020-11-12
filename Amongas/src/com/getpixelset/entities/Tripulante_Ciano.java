package com.getpixelset.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.getpixelset.main.Game;
import com.getpixelset.world.Camera;
import com.getpixelset.world.World;

public class Tripulante_Ciano extends Entity {

	public int right_dir = 0, left_dir = 1, up_dir = 0, down_dir = 1;
	public int dir = right_dir;
	public int dir_IA = 1;
	private double speed = 6;

	private boolean moved = false;

	private BufferedImage rightPlayer;
	private BufferedImage leftPlayer;

	private BufferedImage[] rightPlayerIdle;
	private BufferedImage[] leftPlayerIdle;

	public static double life = 1;

	private int frames = 0, maxFrames = 2, index = 0, maxIndex = 1;

	public Tripulante_Ciano(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		rightPlayer = Game.spritesheet.getSprite(32, 128, 16, 16);
		leftPlayer = Game.spritesheet.getSprite(32, 144, 16, 16);
		rightPlayerIdle = new BufferedImage[2];
		leftPlayerIdle = new BufferedImage[2];

		for (int i = 0; i < 2; i++) {
			rightPlayerIdle[i] = Game.spritesheet.getSprite(0 + (i * 16), 128, 16, 16);
		}
		for (int i = 0; i < 2; i++) {
			leftPlayerIdle[i] = Game.spritesheet.getSprite(0 + (i * 16), 144, 16, 16);
		}
	}

	public void tick() {
		depth = 0;
		moved = false;
		dir_IA = rand.nextInt(2 / 1);
		if (rand.nextInt(100) < 18) {
			if (dir_IA == 0 && World.isFreeDynamic((int) (x + speed), this.getY())) {
				moved = true;
				x += speed;
				dir = right_dir;
			}
			if (rand.nextInt(100) < 18) {
			} else if (dir_IA == 1 && World.isFreeDynamic((int) (x - speed), this.getY())) {
				moved = true;
				x -= speed;
				dir = left_dir;
			}
			if (rand.nextInt(100) < 18) {
				if (dir_IA == 0 && World.isFreeDynamic(this.getX(), (int) (y - speed))) {
					moved = true;
					y -= speed;
				}
				if (rand.nextInt(100) < 20) {
				} else if (dir_IA == 1 && World.isFreeDynamic(this.getX(), (int) (y + speed))) {
					moved = true;
					y += speed;
				}
			}
		}
		frames++;
		if (frames == maxFrames) {
			frames = 0;
			index++;

			if (index > maxIndex)
				index = 0;
		}

	}

	public void render(Graphics g) {
		if (moved) {
			if (dir == right_dir) {
				g.drawImage(rightPlayerIdle[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			} else if (dir == left_dir) {
				g.drawImage(leftPlayerIdle[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
		} else {
			if (dir == right_dir) {
				g.drawImage(rightPlayer, this.getX() - Camera.x, this.getY() - Camera.y, null);
			} else if (dir == left_dir) {
				g.drawImage(leftPlayer, this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
		}
	}
}
