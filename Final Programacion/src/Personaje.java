import processing.core.PApplet;

import processing.core.PImage;

public class Personaje {

	private int x;
	private int y;
	int col;
	int fil;
	private int dir;
	int life;

	private PImage frente;
	private PImage frente1;
	private PImage frente2;
	private PImage frente3;
	private PImage frente4;

	private PImage espalda;
	private PImage espalda1;
	private PImage espalda2;
	private PImage espalda3;
	private PImage espalda4;

	private PImage derecha;
	private PImage derecha1;
	private PImage derecha2;
	private PImage derecha3;
	private PImage derecha4;

	private PImage izquierda;
	private PImage izquierda1;
	private PImage izquierda2;
	private PImage izquierda3;
	private PImage izquierda4;

	private PImage atac0;
	private PImage atac1;
	private PImage atac2;
	private PImage atac3;

	private PImage korazon;

	Mapa refMapa;
	Obstaculos obs;

	public Personaje(int col, int fil, Mapa refMapa, Obstaculos obs, PApplet app, int life) {
		this.x = 25 + (col * 50);
		this.y = 25 + (fil * 50);
		this.col = col;
		this.fil = fil;
		this.refMapa = refMapa;
		this.obs = obs;

		this.life = life;
		this.dir = 0;

		this.frente = app.loadImage("0.png");
		this.frente1 = app.loadImage("01.png");
		this.frente2 = app.loadImage("02.png");
		this.frente3 = app.loadImage("03.png");
		this.frente4 = app.loadImage("04.png");

		this.espalda = app.loadImage("1.png");
		this.espalda1 = app.loadImage("11.png");
		this.espalda2 = app.loadImage("12.png");
		this.espalda3 = app.loadImage("13.png");
		this.espalda4 = app.loadImage("14.png");

		this.derecha = app.loadImage("3.png");
		this.derecha1 = app.loadImage("31.png");
		this.derecha2 = app.loadImage("32.png");
		this.derecha3 = app.loadImage("33.png");
		this.derecha4 = app.loadImage("34.png");

		this.izquierda = app.loadImage("2.png");
		this.izquierda1 = app.loadImage("21.png");
		this.izquierda2 = app.loadImage("22.png");
		this.izquierda3 = app.loadImage("23.png");
		this.izquierda4 = app.loadImage("24.png");

		this.atac0 = app.loadImage("A1.png");
		this.atac1 = app.loadImage("A2.png");
		this.atac2 = app.loadImage("A3.png");
		this.atac3 = app.loadImage("A4.png");

		this.korazon = app.loadImage("korazom.png");
	}

	public void pintarS(PApplet app) {
		app.image(frente, x, y-25, 66, 92);
	}

	public void pintarS1(PApplet app) {
		app.image(frente1, x, y-25, 66, 92);
	}

	public void pintarS2(PApplet app) {
		app.image(frente2, x, y-25, 66, 92);
	}

	public void pintarS3(PApplet app) {
		app.image(frente3, x, y-25, 66, 92);
	}

	public void pintarS4(PApplet app) {
		app.image(frente4, x, y-25, 66, 92);
	}

	public void pintarW(PApplet app) {
		app.image(espalda, x, y-25, 66, 92);
	}

	public void pintarW1(PApplet app) {
		app.image(espalda1, x, y-25, 70, 92);
	}

	public void pintarW2(PApplet app) {
		app.image(espalda2, x, y-25, 70, 92);
	}

	public void pintarW3(PApplet app) {
		app.image(espalda3, x, y-25, 70, 92);
	}

	public void pintarW4(PApplet app) {
		app.image(espalda4, x, y-25, 70, 92);
	}

	public void pintarD(PApplet app) {
		app.image(derecha, x, y-25, 66, 92);
	}

	public void pintarD1(PApplet app) {
		app.image(derecha1, x, y-25, 81, 92);
	}

	public void pintarD2(PApplet app) {
		app.image(derecha2, x, y-25, 81, 92);
	}

	public void pintarD3(PApplet app) {
		app.image(derecha3, x, y-25, 81, 92);
	}

	public void pintarD4(PApplet app) {
		app.image(derecha4, x, y-25, 81, 92);
	}

	public void pintarA(PApplet app) {
		app.image(izquierda, x, y-25, 66, 92);
	}

	public void pintarA1(PApplet app) {
		app.image(izquierda1, x, y-25, 81, 92);
	}

	public void pintarA2(PApplet app) {
		app.image(izquierda2, x, y-25, 81, 92);
	}

	public void pintarA3(PApplet app) {
		app.image(izquierda3, x, y-25, 81, 92);
	}

	public void pintarA4(PApplet app) {
		app.image(izquierda4, x, y-25, 81, 92);
	}

	public void atckw(PApplet app) {
		app.image(atac0, x, y - 50, 132, 92);
	}

	public void atcks(PApplet app) {
		app.image(atac2, x, y, 132, 92);
	}

	public void atckd(PApplet app) {
		app.image(atac1, x + 25, y - 25, 132, 92);
	}

	public void atcka(PApplet app) {
		app.image(atac3, x - 25, y - 25, 132, 92);
	}

	public void miraLife(PApplet app) {
		for (int i = 0; i < life; i++) {
			app.image(korazon, 50+(i*50), 25, 140,100);
		
		}
	}

	public void mover(String dir) {
		int destino = -1;
		int obstaculos = -1;
		switch (dir) {
		case "arriba":
			destino = refMapa.getTipoCasilla(fil - 1, col);
			obstaculos = obs.getTipoCasilla(fil - 1, col);
			if (destino == 0 && obstaculos == 0) {
				fil = fil - 1;
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50);
				this.dir = 2;
			}
			break;
		case "abajo":
			destino = refMapa.getTipoCasilla(fil + 1, col);
			obstaculos = obs.getTipoCasilla(fil + 1, col);
			if (destino == 0 && obstaculos == 0) {
				fil = fil + 1;
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50);
				this.dir = 0;
			}
			break;
		case "izquierda":
			destino = refMapa.getTipoCasilla(fil, col - 1);
			obstaculos = obs.getTipoCasilla(fil, col - 1);
			if (destino == 0 && obstaculos == 0) {
				col = col - 1;
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50);
				this.dir = 3;
			}
			break;
		case "derecha":
			destino = refMapa.getTipoCasilla(fil, col + 1);
			obstaculos = obs.getTipoCasilla(fil, col + 1);
			if (destino == 0 && obstaculos == 0) {
				col = col + 1;
				this.x = 25 + (col * 50);
				this.y = 25 + (fil * 50);
				this.dir = 1;
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

	public int getdir() {
		return dir;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setCol(int col) {
		this.col = col;
		this.x = 25 + (col * 50);
		this.y = 25 + (fil * 50);
	}

	public void setFil(int fil) {
		this.fil = fil;
		this.x = 25 + (col * 50);
		this.y = 25 + (fil * 50);
	}

	public void setRefMapa(Mapa refMapa) {
		this.refMapa = refMapa;
	}

	public void setObs(Obstaculos obs) {
		this.obs = obs;
	}
}