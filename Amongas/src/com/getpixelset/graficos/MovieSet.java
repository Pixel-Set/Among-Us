package com.getpixelset.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MovieSet {

	private BufferedImage movieset;

	public MovieSet(String path) {
		try {
			movieset = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getSprite(int x, int y, int width, int height) {
		return movieset.getSubimage(x, y, width, height);
	}
}
