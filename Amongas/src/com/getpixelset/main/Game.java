package com.getpixelset.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import com.getpixelset.entities.Entity;
import com.getpixelset.entities.Player;
import com.getpixelset.entities.Tripulante;
import com.getpixelset.entities.Tripulante_Amarelo;
import com.getpixelset.entities.Tripulante_Azul;
import com.getpixelset.entities.Tripulante_Ciano;
import com.getpixelset.entities.Tripulante_Laranja;
import com.getpixelset.entities.Tripulante_Rosa;
import com.getpixelset.entities.Tripulante_Roxo;
import com.getpixelset.entities.Tripulante_VerdeClaro;
import com.getpixelset.graficos.MovieSet;
import com.getpixelset.graficos.Spritesheet;
import com.getpixelset.world.World;

public class Game extends Canvas implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	public static final int WIDTH = 450;
	public static final int HEIGHT = 250;
	public static final int SCALE = 3;

	private BufferedImage image;

	public static List<Entity> entities;

	public static Spritesheet spritesheet;
	public static MovieSet movieset;

	public static World world;

	public static Player player;
	public static Tripulante tripulante;
	public static Tripulante_Amarelo tripulante_amarelo;
	public static Tripulante_Azul tripulante_azul;
	public static Tripulante_Ciano tripulante_ciano;
	public static Tripulante_Laranja tripulante_laranja;
	public static Tripulante_Rosa tripulante_rosa;
	public static Tripulante_Roxo tripulante_roxo;
	public static Tripulante_VerdeClaro tripulante_verdeclaro;

	public static Image imagem;

	public BufferedImage luz;
	public int[] luzMapPixels;
	public int[] pixels;

	public static Random rand;

	public Game() {
		rand = new Random();
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		// Inicializando objetos.
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		try {
			luz = ImageIO.read(getClass().getResource("/luz.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		luzMapPixels = new int[luz.getWidth() * luz.getHeight()];
		luz.getRGB(0, 0, luz.getWidth(), luz.getHeight(), luzMapPixels, 0, luz.getWidth());
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		entities = new ArrayList<Entity>();
		spritesheet = new Spritesheet("/spritesheet.png");
		movieset = new MovieSet("/movieset.png");
		player = new Player(0, 0, 16, 16, 2, spritesheet.getSprite(32, 0, 16, 16));
		tripulante = new Tripulante(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		tripulante_amarelo = new Tripulante_Amarelo(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		tripulante_azul = new Tripulante_Azul(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		tripulante_ciano = new Tripulante_Ciano(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		tripulante_laranja = new Tripulante_Laranja(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		tripulante_rosa = new Tripulante_Rosa(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		tripulante_roxo = new Tripulante_Roxo(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		tripulante_verdeclaro = new Tripulante_VerdeClaro(0, 0, 16, 16, spritesheet.getSprite(32, 0, 16, 16));
		entities.add(player);
		entities.add(tripulante);
		entities.add(tripulante_amarelo);
		entities.add(tripulante_azul);
		entities.add(tripulante_ciano);
		entities.add(tripulante_laranja);
		entities.add(tripulante_rosa);
		entities.add(tripulante_roxo);
		entities.add(tripulante_verdeclaro);
		world = new World("/level1.png");

	}

	public void initFrame() {
		frame = new JFrame("Among Us");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();

	}

	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			if (e instanceof Player) {

			}
			e.tick();
		}
	}

	public void aplicarLuz() {
		for (int xx = 0; xx < Game.WIDTH; xx++) {
			for (int yy = 0; yy < Game.HEIGHT; yy++) {
				if (luzMapPixels[xx + (yy * Game.WIDTH)] == 0xffffffff) {
					pixels[xx + (yy * Game.WIDTH)] = 0;
				}
			}
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(102, 102, 102));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		/* Renderização do jogo */
		world.render(g);
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);

			e.render(g);
		}
		aplicarLuz();
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		bs.show();
	}

	public void run() {
		requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		requestFocus();
		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS: " + frames);
				frames = 0;
				timer += 1000;
			}
		}
		stop();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			player.down = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {
			player.attack = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			player.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			player.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			player.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			player.down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_C) {
			player.attack = false;
		}
	}
}