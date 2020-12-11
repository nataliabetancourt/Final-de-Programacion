import processing.core.PApplet;
import processing.core.PImage;

public class Enemigos {

	private int x;
	private int y;
	private boolean direccion1, direccion2, direccion3;
	private int life;
	private int zigzag, contador;

	Mapa refMapa;
	PImage m1Frente, m1Detras, m1LadoD, m1LadoI;
	PImage m2Frente;
	PImage jefeI, jefeD;

	public Enemigos(int col, int fil, Mapa refMapa, PApplet app, int life) {
		this.x = 25 + (col * 50);
		this.y = 25 + (fil * 50);
		this.refMapa = refMapa;
		this.life = life;
		this.direccion1 = true;
		this.direccion2 = true;
		this.direccion3 = true;
		this.m1Frente = app.loadImage("monstruo-1.png");
		this.m1Detras = app.loadImage("monstruo-3.png");
		this.m1LadoD = app.loadImage("monstruo-2.png");
		this.m1LadoI = app.loadImage("monstruo-4.png");
		this.m2Frente = app.loadImage("monstruos arreglados-09.png");
		this.jefeD = app.loadImage("derecha.png");
		this.jefeI = app.loadImage("izquierda (2).png");
	}

	public void pintarBasicoy(PApplet app) {
		if (direccion1 == true) {
			app.image(m1Frente, x, y, 150, 150);
		} else {
			app.image(m1Detras, x, y, 150, 150);
		}
	}

	public void pintarBasicox(PApplet app) {
		if (direccion2 == true) {
			app.image(m1LadoD, x, y, 150, 150);
		} else {
			app.image(m1LadoI, x, y, 150, 150);
		}
	}

	public void moverBasicoy(int velocidad) {
		if (direccion1 == true) {
			y += velocidad;
		} else {
			y -= velocidad;
		}

		if (y > 620) {
			direccion1 = false;
		}

		if (y < 80) {
			direccion1 = true;
		}
	}

	public void moverBasicox(int velocidad) {
		if (direccion2 == true) {
			x += velocidad;
		} else {
			x -= velocidad;
		}

		if (x > 1120) {
			direccion2 = false;
		}

		if (x < 80) {
			direccion2 = true;
		}

	}

	public void pintarQuieto(PApplet app) {
		app.image(m2Frente, x, y, 150, 200);

	}

	public void pintarJefe(PApplet app) {
		if (direccion3 == true) {
			app.image(jefeI, x, y, 200, 350);
		}
		
		if (direccion3 == false) {
			app.image(jefeD, x, y, 200, 350);
		}
		
	}

	public void moverJefe() {
		contador++;
		
		if (contador>=20) {
			contador = 0;
			zigzag++;
		}
		
		if (zigzag>=3) {
			zigzag = 0;
		}
		
		if (x<80) {
			direccion3 = false;
		}
		
		if (x>1000) {
			direccion3 = true;
		}

		if (direccion3 == false) {
			switch (zigzag) {
			case 1:
				x+=3;
				y+=10;
				break;
			case 2:
				x+=3;
				y-=10;
				break;
			case 3:
				x-=3;
				y+=10;
				break;
			case 4:
				x-=3;
				y-=10;
				break;
			}
		}
		
		if (direccion3==true) {
			switch (zigzag) {
			case 1:
				x-=3;
				y-=10;
				break;
			case 2:
				x-=3;
				y+=10;
				break;
			case 3:
				x+=3;
				y-=10;
				break;
			case 4:
				x+=3;
				y+=10;
				break;
			}
		}

		
	}

	public void setLife(int life) {
		this.life = life;
	}

}
