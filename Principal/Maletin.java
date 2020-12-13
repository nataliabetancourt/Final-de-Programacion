package Principal;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Maletin {

	private int x, y, x2, y2;
	private int[][] casillas;
	private ArrayList<Inventario> naranjasInventario, gemasInventario;

	Inventario refInventario;
	Mapa refMapa;
	Obstaculos refObs;

	public Maletin() {
		this.x = 80;
		this.y = 620;
		this.x2 = 375;
		this.y2 = 575;
		this.naranjasInventario = new ArrayList<Inventario>();
		this.gemasInventario = new ArrayList<Inventario>();

		casillas = new int[3][8];

		// Filas y columnas del maletin
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				casillas[i][j] = 0;
			}
		}

	}

	// Boton del maletin
	public void pintar(PApplet app, PImage img) {
		app.fill(0, 80);
		app.stroke(255, 204, 44);
		app.strokeWeight(3);
		app.ellipse(x, y, 120, 120);
		app.image(img, x, y - 10, 100, 100);
	}

	public void pintarAbierto(PApplet app, PImage gema, PImage naranja) {
		int x = 175;
		int y = 575;
		
		//Cuadros maletin
		app.rectMode(PConstants.CORNER);
		app.rect(x, y, 200, 50);
		app.rect(x, y + 50, 200, 50);
		app.fill(0, 80);
		app.stroke(255, 204, 44);
		app.strokeWeight(3);
		
		//Numero de gemas y naranjas
		app.fill(255, 204, 44);
		app.image(gema, 250, 600, 50, 50);
		app.textSize(24);
		app.text(": " + gemasInventario.size(), 275, 608);
		app.image(naranja, 250, 650, 50, 50);
		app.text(": " + naranjasInventario.size(), 275, 658);

		// Salida maletin
		app.fill(232, 17, 46);
		app.noStroke();
		app.circle(x2, y2, 20);

	}

	public void agregarNaranja(Inventario ref) {
		naranjasInventario.add(ref);
	}
	
	public void agregarGema(Inventario ref) {
		gemasInventario.add(ref);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public void setCasillas(int fil, int col) {
		this.casillas[fil][col] = 1;
	}
}
