package pong;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Jogo extends Canvas implements Runnable, KeyListener{
	public static int largura = 600;
	public static int altura = 500;
	public static JogadorUm jogadorUm;
	public static JogadorDois jogadorDois;
	public static Bola bola;
	
	public Jogo() {
		this.setPreferredSize(new Dimension(largura, altura));
		this.addKeyListener(this);
		jogadorUm = new JogadorUm(15, 200);
		jogadorDois = new JogadorDois(575, 200);
		bola = new Bola(295, 245);
	}
	
	public static void main(String args[]) {
		Jogo jogo = new Jogo();
		JFrame jframe = new JFrame();
		jframe.setVisible(true);
		jframe.add(jogo);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Thread(jogo).start();
	}

	@Override
	public void run() {
		try {
			while (true) {
				desenhar();
				atualizar();
				Thread.sleep(1000 / 30);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void desenhar() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, largura, altura);
		jogadorUm.desenhar(g);
		jogadorDois.desenhar(g);
		bola.desenhar(g);
		bs.show();

	}

	private void atualizar() {
		jogadorUm.atualizar();
		jogadorDois.atualizar();
		bola.atualizar();
	}

	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			jogadorUm.up = true;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			jogadorUm.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			jogadorDois.up = true;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			jogadorDois.down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			jogadorUm.up = false;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			jogadorUm.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			jogadorDois.up = false;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			jogadorDois.down = false;
		}
	}

}
