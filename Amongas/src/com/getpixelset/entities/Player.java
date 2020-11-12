package com.getpixelset.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.getpixelset.main.Game;
import com.getpixelset.world.Camera;
import com.getpixelset.world.World;

public class Player extends Entity {

	public boolean right, up, left, down;

	public int right_dir = 0, left_dir = 1, up_dir = 0, down_dir = 1;
	public int dir = right_dir;
	private double speed = 3;

	private boolean moved = false;

	private BufferedImage rightPlayer;
	private BufferedImage leftPlayer;
	private BufferedImage AttackRight;
	private BufferedImage AttackLeft;
	private BufferedImage[] rightPlayerIdle;
	private BufferedImage[] leftPlayerIdle;

	private int frames = 0, maxFrames = 3, index = 0, maxIndex = 2;

	public boolean attack = false;
	public boolean isAttacking = false;
	public int attackFrames = 0;
	public int maxFramesAttack = 10;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		AttackRight = Game.spritesheet.getSprite(48, 0, 16, 16);
		AttackLeft = Game.spritesheet.getSprite(48, 16, 16, 16);
		rightPlayer = Game.spritesheet.getSprite(0, 0, 16, 16);
		leftPlayer = Game.spritesheet.getSprite(0, 16, 16, 16);
		rightPlayerIdle = new BufferedImage[3];
		leftPlayerIdle = new BufferedImage[3];

		for (int i = 0; i < 3; i++) {
			rightPlayerIdle[i] = Game.spritesheet.getSprite(0 + (i * 16), 0, 16, 16);
		}
		for (int i = 0; i < 3; i++) {
			leftPlayerIdle[i] = Game.spritesheet.getSprite(0 + (i * 16), 16, 16, 16);
		}
	}

	public void tick() {
		depth = 2;
		moved = false;
		if (right && World.isFreeDynamic((int) (x + speed), this.getY())) {
			moved = true;
			dir = right_dir;
			x += speed;
		} else if (left && World.isFreeDynamic((int) (x - speed), this.getY())) {
			moved = true;
			dir = left_dir;
			x -= speed;
		}
		if (up && World.isFreeDynamic(this.getX(), (int) (y - speed))) {
			moved = true;
			y -= speed;
		} else if (down && World.isFreeDynamic(this.getX(), (int) (y + speed))) {
			moved = true;
			y += speed;
		}

		frames++;
		if (frames == maxFrames) {
			frames = 0;
			index++;

			if (index > maxIndex)
				index = 0;
		}
		if (attack) {
			if (isAttacking == false) {
				attack = false;
				isAttacking = true;
			}
		}

		if (isAttacking) {
			attackFrames++;
			if (attackFrames == maxFramesAttack) {
				attackFrames = 0;
				isAttacking = false;
			}
		}

		collisionTripulante();
		collisionTripulante_Amarelo();
		collisionTripulante_Azul();
		collisionTripulante_Ciano();
		collisionTripulante_Laranja();
		collisionTripulante_Rosa();
		collisionTripulante_Roxo();
		collisionTripulante_VerdeClaro();

		Camera.x = Camera.clamp((int) x - Game.WIDTH / 2, 1, World.WIDTH * 16 - Game.WIDTH);
		Camera.y = Camera.clamp((int) y - Game.HEIGHT / 2, 1, World.HEIGHT * 16 - Game.HEIGHT);

	}

	// Kill Enemy
	public void collisionTripulante() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Tripulante) {
				if (Entity.isColidding(this, e)) {
					if (isAttacking) {
						Tripulante.life--;
						if (Tripulante.life == 0) {
							Game.entities.remove(i);
							break;
						}
					}
				}
			}
		}
	}

	public void collisionTripulante_Amarelo() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Tripulante_Amarelo) {
				if (Entity.isColidding(this, e)) {
					if (isAttacking) {
						Tripulante_Amarelo.life--;
						if (Tripulante_Amarelo.life == 0) {
							Game.entities.remove(i);
							break;
						}
					}
				}
			}
		}
	}

	public void collisionTripulante_Azul() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Tripulante_Azul) {
				if (Entity.isColidding(this, e)) {
					if (isAttacking) {
						Tripulante_Azul.life--;
						if (Tripulante_Azul.life == 0) {
							Game.entities.remove(i);
							break;
						}
					}
				}
			}
		}
	}

	public void collisionTripulante_Ciano() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Tripulante_Ciano) {
				if (Entity.isColidding(this, e)) {
					if (isAttacking) {
						Tripulante_Ciano.life--;
						if (Tripulante_Ciano.life == 0) {
							Game.entities.remove(i);
							break;
						}
					}
				}
			}
		}
	}

	public void collisionTripulante_Laranja() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Tripulante_Laranja) {
				if (Entity.isColidding(this, e)) {
					if (isAttacking) {
						Tripulante_Laranja.life--;
						if (Tripulante_Laranja.life == 0) {
							Game.entities.remove(i);
							break;
						}
					}
				}
			}
		}
	}

	public void collisionTripulante_Rosa() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Tripulante_Rosa) {
				if (Entity.isColidding(this, e)) {
					if (isAttacking) {
						Tripulante_Rosa.life--;
						if (Tripulante_Rosa.life == 0) {
							Game.entities.remove(i);
							break;
						}
					}
				}
			}
		}
	}

	public void collisionTripulante_Roxo() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Tripulante_Roxo) {
				if (Entity.isColidding(this, e)) {
					if (isAttacking) {
						Tripulante_Roxo.life--;
						if (Tripulante_Roxo.life == 0) {
							Game.entities.remove(i);
							break;
						}
					}
				}
			}
		}
	}

	public void collisionTripulante_VerdeClaro() {
		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Tripulante_VerdeClaro) {
				if (Entity.isColidding(this, e)) {
					if (isAttacking) {
						Tripulante_VerdeClaro.life--;
						if (Tripulante_VerdeClaro.life == 0) {
							Game.entities.remove(i);
							break;
						}
					}
				}
			}
		}
	}

	public void render(Graphics g) {
		if (isAttacking) {
			if (dir == right_dir) {
				g.drawImage(AttackRight, this.getX() + 10 - Camera.x, this.getY() - Camera.y, null);
			} else if (dir == left_dir) {
				g.drawImage(AttackLeft, this.getX() - 10 - Camera.x, this.getY() - Camera.y, null);
			}
		}
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
