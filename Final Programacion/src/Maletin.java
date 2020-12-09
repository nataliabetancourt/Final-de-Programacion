import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Maletin {

	private int x, y, x2, y2, xImagen, yImagen;
	private int[][] casillas;
	private ArrayList<Inventario> elementosInventario;

	Inventario refInventario;

	public Maletin() {
		this.x = 80;
		this.y = 620;
		this.x2 = 550;
		this.y2 = 550;
		this.elementosInventario = new ArrayList<Inventario>();

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

	public void pintarAbierto(PApplet app) {
		// Coordenadas de inicio de la matriz
		int x = 175;
		int y = 575;

		// Matriz del maletin
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {

				this.xImagen = 25 + (i * 50);
				this.yImagen = 25 + (j * 50);

				for (int j2 = 0; j2 < elementosInventario.size(); j2++) {
					elementosInventario.get(j2).pintar2(app, xImagen, yImagen);
				}

				app.rectMode(PConstants.CENTER);
				app.rect(x, y, 50, 50);
				app.rectMode(PConstants.CORNER);
				x += 50;
			}
			x = 175;
			y += 50;
		}

		// Salida maletin
		app.fill(232, 17, 46);
		app.noStroke();
		app.circle(x2, y2, 20);

	}

	public void agregarElemento(Inventario ref) {
		elementosInventario.add(ref);
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
