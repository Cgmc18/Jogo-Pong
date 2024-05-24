package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola {
	public double x;
	public double y;
	public int larguraBola;
	public int alturaBola;
	public double dx;
	public double dy;
	public double speed = 6.5;
	
	public Bola(int x, int y) {
		this.x = x;
		this.y = y;
		this.larguraBola = 8;
		this.alturaBola = 8;
		
		int angulo = new Random().nextInt(80);
		dx = Math.cos(Math.toRadians(angulo));
		dy = Math.sin(Math.toRadians(angulo));
	}
	
	public void desenhar(Graphics g) {
		g.setColor(new Color(180, 0, 255));
		g.fillRect((int)x, (int)y, larguraBola, alturaBola);
	}
	
	public void atualizar() {
		if(y + (dy*speed) + alturaBola >= Jogo.altura) {
			dy*= -1;
		} else if(y + (dy*speed) < 0) {
			dy*= -1;
		}
		
		Rectangle bola = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), larguraBola, alturaBola);
		Rectangle jogadorUm = new Rectangle(Jogo.jogadorUm.x, Jogo.jogadorUm.y, Jogo.jogadorUm.larguraJogadorUm, Jogo.jogadorUm.alturaJogadorUm);
		Rectangle jogadorDois = new Rectangle((int)Jogo.jogadorDois.x, (int)Jogo.jogadorDois.y, Jogo.jogadorDois.larguraJogadorDois, Jogo.jogadorDois.alturaJogadorDois);
		
		if(bola.intersects(jogadorUm)) {
			int angulo = new Random().nextInt(80);
			dx = Math.cos(Math.toRadians(angulo));
			dy = Math.sin(Math.toRadians(angulo));
			if(dx < 0) {
				dx*= -1;
			}
		} else if(bola.intersects(jogadorDois)) {
			int angulo = new Random().nextInt(80);
			dx = Math.cos(Math.toRadians(angulo));
			dy = Math.sin(Math.toRadians(angulo));
			if(dx > 0) {
				dx*= -1;
			}
		}
		
		if(x <= 0) {
			System.out.println("Ponto do Jogador Dois");
			new Jogo();
		} else if(x >= 600) {
			System.out.println("Ponto do Jogador Um");
			new Jogo();
		}
		x+= dx*speed;
		y+= dy*speed;
	}
}
