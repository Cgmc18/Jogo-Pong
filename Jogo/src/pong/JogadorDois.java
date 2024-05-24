package pong;

import java.awt.Color;
import java.awt.Graphics;

public class JogadorDois {
	public boolean up;
	public boolean down;
	public double x;
	public double y;
	public int larguraJogadorDois;
	public int alturaJogadorDois;
	
	public JogadorDois(int x, int y) {
		this.x = x;
		this.y = y;
		this.larguraJogadorDois = 10;
		this.alturaJogadorDois = 100;
	}
	
	public void desenhar(Graphics g) {
		g.setColor(new Color(180, 0, 255));
		g.fillRect((int)x, (int)y, larguraJogadorDois, alturaJogadorDois);
	}
	
	public void atualizar() {
		if(up) {
			y=y-4;
		}else if(down) {
			y=y+4;
		}
		
		if(y+alturaJogadorDois > Jogo.altura) {
			y = Jogo.altura - alturaJogadorDois;
		}else if(y < 0) {
			y = 0;
		}
	}
}
