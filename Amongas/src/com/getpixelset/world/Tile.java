package com.getpixelset.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.getpixelset.main.Game;

public class Tile {

	public static BufferedImage TILE_FLOOR = Game.movieset.getSprite(0, 0, 16, 16);
	public static BufferedImage TILE_FLOOR1 = Game.movieset.getSprite(64, 0, 16, 16);
	public static BufferedImage TILE_FLOOR2 = Game.movieset.getSprite(80, 0, 16, 16);
	public static BufferedImage TILE_FLOOR3 = Game.movieset.getSprite(96, 0, 16, 16);
	public static BufferedImage TILE_FLOOR4 = Game.movieset.getSprite(112, 0, 16, 16);
	public static BufferedImage TILE_FLOOR5 = Game.movieset.getSprite(128, 0, 16, 16);
	public static BufferedImage TILE_FLOOR6 = Game.movieset.getSprite(144, 0, 16, 16);
	public static BufferedImage TILE_FLOOR7 = Game.movieset.getSprite(160, 0, 16, 16);
	public static BufferedImage TILE_FLOOR8 = Game.movieset.getSprite(176, 0, 16, 16);
	public static BufferedImage TILE_FLOOR9 = Game.movieset.getSprite(192, 0, 16, 16);
	public static BufferedImage TILE_FLOOR10 = Game.movieset.getSprite(208, 0, 16, 16);
	public static BufferedImage TILE_WALL = Game.movieset.getSprite(16, 0, 16, 16);
	public static BufferedImage TILE_WALLRIGHT = Game.movieset.getSprite(32, 0, 16, 16);
	public static BufferedImage TILE_WALLLEFT = Game.movieset.getSprite(48, 0, 16, 16);
	public static BufferedImage TILE_MESA = Game.movieset.getSprite(0, 16, 16, 16);
	public static BufferedImage TILE_MESA1 = Game.movieset.getSprite(16, 16, 16, 16);
	public static BufferedImage TILE_MESA2 = Game.movieset.getSprite(0, 32, 16, 16);
	public static BufferedImage TILE_MESA3 = Game.movieset.getSprite(16, 32, 16, 16);
	public static BufferedImage TILE_MESA_alert = Game.movieset.getSprite(32, 16, 16, 16);
	public static BufferedImage TILE_MESA_alert1 = Game.movieset.getSprite(48, 16, 16, 16);
	public static BufferedImage TILE_MESA_alert2 = Game.movieset.getSprite(32, 32, 16, 16);
	public static BufferedImage TILE_MESA_alert3 = Game.movieset.getSprite(48, 32, 16, 16);
	public static BufferedImage VENTILACAO = Game.movieset.getSprite(224, 0, 16, 16);
	public static BufferedImage CAIXA_ARMAZEM = Game.movieset.getSprite(240, 0, 16, 16);
	public static BufferedImage ELETRICA = Game.movieset.getSprite(256, 0, 16, 16);
	public static BufferedImage ELETRICA_ONE = Game.movieset.getSprite(272, 0, 16, 16);
	public static BufferedImage CAMA = Game.movieset.getSprite(288, 0, 16, 16);
	public static BufferedImage CAMA_ONE = Game.movieset.getSprite(304, 0, 16, 16);
	public static BufferedImage MESAC = Game.movieset.getSprite(64, 16, 16, 16);
	public static BufferedImage MESAC1 = Game.movieset.getSprite(80, 16, 16, 16);
	public static BufferedImage MESAC2 = Game.movieset.getSprite(96, 16, 16, 16);
	public static BufferedImage MESAC3 = Game.movieset.getSprite(64, 32, 16, 16);
	public static BufferedImage MESAC4 = Game.movieset.getSprite(80, 32, 16, 16);
	public static BufferedImage MESAC5 = Game.movieset.getSprite(96, 32, 16, 16);
	public static BufferedImage CADEIRA = Game.movieset.getSprite(320, 0, 16, 16);
	public static BufferedImage CONTRL = Game.movieset.getSprite(112, 16, 16, 16);
	public static BufferedImage CONTRL1 = Game.movieset.getSprite(112, 32, 16, 16);
	public static BufferedImage TV = Game.movieset.getSprite(128, 16, 16, 16);

	private BufferedImage sprite;
	private int x, y;

	public Tile(int x, int y, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;

	}

	public void render(Graphics g) {
		g.drawImage(sprite, x - Camera.x, y - Camera.y, null);
	}
}
