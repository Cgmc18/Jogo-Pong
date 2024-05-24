package pong;

import java.awt.Color;
import java.awt.Graphics;

public class JogadorUm {
	public boolean up;
	public boolean down;
	public int x;
	public int y;
	public int larguraJogadorUm;
	public int alturaJogadorUm;
	
	public JogadorUm(int x, int y) {
		this.x = x;
		this.y = y;
		this.larguraJogadorUm = 10;
		this.alturaJogadorUm = 100;
	}
	
	public void desenhar(Graphics g) {
		g.setColor(new Color(180, 0, 255));
		g.fillRect(x, y, larguraJogadorUm, alturaJogadorUm);
	}
	
	public void atualizar() {
		if(up) {
			y=y-4;
		}else if(down) {
			y=y+4;
		}
		
		if(y+alturaJogadorUm > Jogo.altura) {
			y = Jogo.altura - alturaJogadorUm;
		}else if(y < 0) {
			y = 0;
		}
	}
}
