package Principal;
import processing.core.PApplet;

public class Personaje {
	
	private int x;
	private int y;
	int col;
	int fil;
	
	Mapa refMapa;
	Obstaculos obs;
	
	public Personaje(int col, int fil, Mapa refMapa, Obstaculos obs) {
		this.x = 25 + (col*50);
		this.y = 25 + (fil*50);
		this.col = col;
		this.fil = fil;
		this.refMapa = refMapa;
		this.obs = obs;
	}
	
	public void pintar(PApplet app) {
		app.noStroke();
		app.fill(255, 0, 0);
		app.circle(x, y, 25);
	}
	
	public void mover(String dir) {
		int destino = -1;
		int obstaculos = -1;
		switch (dir) {
		case "arriba":
			destino = refMapa.getTipoCasilla(fil-1,col);
			obstaculos = obs.getTipoCasilla(fil-1, col);
			if(destino == 0 && obstaculos == 0) {
				fil = fil-1;
				this.x = 25 + (col*50);
				this.y = 25 + (fil*50);
			}
			break;
		case "abajo":
			destino = refMapa.getTipoCasilla(fil+1,col);
			obstaculos = obs.getTipoCasilla(fil+1, col);
			if(destino == 0 && obstaculos == 0) {
				fil = fil+1;
				this.x = 25 + (col*50);
				this.y = 25 + (fil*50);
			}
			break;
		case "izquierda":
			destino = refMapa.getTipoCasilla(fil,col-1);
			obstaculos = obs.getTipoCasilla(fil, col-1);
			if(destino == 0 && obstaculos == 0) {
				col = col-1;
				this.x = 25 + (col*50);
				this.y = 25 + (fil*50);
			}
			break;
		case "derecha":
			destino = refMapa.getTipoCasilla(fil,col+1);
			obstaculos = obs.getTipoCasilla(fil, col+1);
			if(destino == 0 && obstaculos == 0) {
				col= col+1;
				this.x = 25 + (col*50);
				this.y = 25 + (fil*50);
			}
			break;

		}

	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setCol(int col) {
		this.col = col;
		this.x = 25 + (col*50);
		this.y = 25 + (fil*50);
	}
	
	public void setFil(int fil) {
		this.fil = fil;
		this.x = 25 + (col*50);
		this.y = 25 + (fil*50);
	}

	public void setRefMapa(Mapa refMapa) {
		this.refMapa = refMapa;
	}
	
	public void setObs(Obstaculos obs) {
		this.obs = obs;
	}
}
