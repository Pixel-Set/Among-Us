package com.getpixelset.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.getpixelset.main.Game;

public class World {

	public static Tile[] tiles;
	public static int WIDTH, HEIGHT;
	public static final int TILE_SIZE = 16;

	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			for (int xx = 0; xx < map.getWidth(); xx++) {
				for (int yy = 0; yy < map.getHeight(); yy++) {
					int pixelAtual = pixels[xx + (yy * map.getWidth())];
					tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR);
					// Chão
					if (pixelAtual == 0xFF000000) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR);
					} else if (pixelAtual == 0xFFA5A5A5) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_FLOOR1);
					} else if (pixelAtual == 0xFF3EA5A5) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR2);
					} else if (pixelAtual == 0xFF04A3A3) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR3);
					} else if (pixelAtual == 0xFF604141) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR4);
					} else if (pixelAtual == 0xFFA0967D) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR5);
					} else if (pixelAtual == 0xFF5E1111) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR6);
					} else if (pixelAtual == 0xFF9E7A25) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR7);
					} else if (pixelAtual == 0xFFFFD800) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR8);
					} else if (pixelAtual == 0xFFFF9B00) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR9);
					} else if (pixelAtual == 0xFF382626) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.TILE_FLOOR10);

						// Parede

					} else if (pixelAtual == 0xFFFFFFFF) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_WALL);
					} else if (pixelAtual == 0xFF606060) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_WALLRIGHT);
					} else if (pixelAtual == 0xFF353535) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_WALLLEFT);
						// Player

					} else if (pixelAtual == 0xFF0026FF) {
						Game.player.setX(xx * 16);
						Game.player.setY(yy * 16);

						// Tripulante
					} else if (pixelAtual == 0xFF558A99) {
						Game.tripulante.setX(xx * 16);
						Game.tripulante.setY(yy * 16);
						// Tripulante_Amarelo
					} else if (pixelAtual == 0xFFFFD461) {
						Game.tripulante_amarelo.setX(xx * 16);
						Game.tripulante_amarelo.setY(yy * 16);
						// Tripulante_Azul
					} else if (pixelAtual == 0xFF000B4C) {
						Game.tripulante_azul.setX(xx * 16);
						Game.tripulante_azul.setY(yy * 16);
						// Tripulante_Ciano
					} else if (pixelAtual == 0xFF52AAD8) {
						Game.tripulante_ciano.setX(xx * 16);
						Game.tripulante_ciano.setY(yy * 16);
						// Tripulante_Laranja
					} else if (pixelAtual == 0xFFCE7235) {
						Game.tripulante_laranja.setX(xx * 16);
						Game.tripulante_laranja.setY(yy * 16);
						// Tripulante_Rosa
					} else if (pixelAtual == 0xFFFF2BD6) {
						Game.tripulante_rosa.setX(xx * 16);
						Game.tripulante_rosa.setY(yy * 16);
						// Tripulante_Roxo
					} else if (pixelAtual == 0xFF991A99) {
						Game.tripulante_roxo.setX(xx * 16);
						Game.tripulante_roxo.setY(yy * 16);
						// Tripulante_VerdeClaro
					} else if (pixelAtual == 0xFFD1FF00) {
						Game.tripulante_verdeclaro.setX(xx * 16);
						Game.tripulante_verdeclaro.setY(yy * 16);
						// Mesa

					} else if (pixelAtual == 0xFF267F00) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_MESA);
					} else if (pixelAtual == 0xFF267F93) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_MESA1);
					} else if (pixelAtual == 0xFF164A56) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_MESA2);
					} else if (pixelAtual == 0xFF103877) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_MESA3);
						// Mesa Alerta

					} else if (pixelAtual == 0xFFFF0C0C) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_MESA_alert);
					} else if (pixelAtual == 0xFFFF5E5E) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_MESA_alert1);
					} else if (pixelAtual == 0xFF8E3434) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_MESA_alert2);
					} else if (pixelAtual == 0xFF5B2121) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TILE_MESA_alert3);
						// Armazem
					} else if (pixelAtual == 0xFF4D38EA) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.CAIXA_ARMAZEM);
						// Ventilação
					} else if (pixelAtual == 0xFFA08645) {
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx * 16, yy * 16, Tile.VENTILAÇAO);
						// ELETRICA
					} else if (pixelAtual == 0xFFA56300) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.ELETRICA);
					} else if (pixelAtual == 0xFFFFC1C1) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.ELETRICA_ONE);
						// Cama
					} else if (pixelAtual == 0xFFBF5D80) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.CAMA);
					} else if (pixelAtual == 0xFF87425B) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.CAMA_ONE);
						// Mesa Cartão
					} else if (pixelAtual == 0xFFF600FF) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.MESAC);
					} else if (pixelAtual == 0xFFF600AE) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.MESAC1);
					} else if (pixelAtual == 0xFF9E0071) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.MESAC2);
					} else if (pixelAtual == 0xFFE5A023) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.MESAC3);
					} else if (pixelAtual == 0xFFE2C085) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.MESAC4);
					} else if (pixelAtual == 0xFFE2C000) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.MESAC5);
						// Cadeira
					} else if (pixelAtual == 0xFFB6FF00) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.CADEIRA);
						// Mesa de controle
					} else if (pixelAtual == 0xFF8056FF) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.CONTRL);
					} else if (pixelAtual == 0xFFA17FFF) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.CONTRL1);
					} else if (pixelAtual == 0xFF3B6E82) {
						tiles[xx + (yy * WIDTH)] = new WallTile(xx * 16, yy * 16, Tile.TV);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isFreeDynamic(int xnext, int ynext) {
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;

		int x2 = (xnext + TILE_SIZE - 1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;

		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext + TILE_SIZE - 1) / TILE_SIZE;

		int x4 = (xnext + TILE_SIZE - 1) / TILE_SIZE;
		int y4 = (ynext + TILE_SIZE - 1) / TILE_SIZE;

		return !(tiles[x1 + (y1 * World.WIDTH)] instanceof WallTile
				|| tiles[x2 + (y2 * World.WIDTH)] instanceof WallTile
				|| tiles[x3 + (y3 * World.WIDTH)] instanceof WallTile
				|| tiles[x4 + (y4 * World.WIDTH)] instanceof WallTile);
	}

	public void render(Graphics g) {
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;

		int xfinal = xstart + (Game.WIDTH >> 4) + 1;
		int yfinal = ystart + (Game.HEIGHT >> 4) + 1;

		for (int xx = xstart; xx <= xfinal; xx++) {
			for (int yy = ystart; yy <= yfinal; yy++) {
				if (xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy * WIDTH)];
				tile.render(g);
			}
		}
	}
}
