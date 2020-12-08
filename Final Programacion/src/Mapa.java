import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Mapa {

	private int[][] casillas;
	private PImage img;
	private int xSalida, ySalida, xSalida2, ySalida2;
	private int col, fil, col2, fil2;
	private int pantalla;

	public Mapa(PImage img, int pantalla) {
		casillas = new int[14][24];
		this.pantalla = pantalla;

		// Fondo
		this.img = img;

		// Filas y columnas del mapa
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 24; j++) {
				casillas[i][j] = 0;
			}
		}

		// Borde superior e inferior
		for (int i = 0; i < 24; i++) {
			casillas[0][i] = 1;
			casillas[13][i] = 1;
		}

		// Borde izquierdo
		for (int j = 0; j < 14; j++) {
			casillas[j][0] = 1;
			casillas[j][23] = 1;
		}

		//Salida pantallas 3-6
		this.col = 22;
		this.fil = 6;
		this.xSalida = 25 + (col * 50);
		this.ySalida = 25 + (fil * 50);
		
		//Salida pantalla 1
		this.col2 = 11;
		this.fil2 = 12;
		this.xSalida2 = 25 + (col2 * 50);
		this.ySalida2 = 25 + (fil2 * 50);

	}

	public void pintar(PApplet app) {
		// Coordenadas de inicio de la matriz
		int x = 25;
		int y = 25;

		// Matriz del mapa
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 24; j++) {

				switch (casillas[i][j]) {
				case 0:
					app.noStroke();
					app.noFill();
					break;
				// Bordes
				case 1:
					app.fill(0);
					break;
			}
				app.rectMode(PConstants.CENTER);
				app.rect(x, y, 50, 50);
				app.rectMode(PConstants.CORNER);
				x += 50;
			}
			x = 25;
			y += 50;
		}
		
		// Imagen de fondo
		app.imageMode(PConstants.CORNER);
		app.image(img, 0, 0);

		// Circulo salida
		app.noStroke();
		app.fill(0, 255, 0);
		if (pantalla == 2) {
			app.circle(xSalida2, ySalida2, 50);
		} else {
			app.circle(xSalida, ySalida, 50);
		}

	}

	// Devuelve el valor de la casillas --> 0 o 1
	public int getTipoCasilla(int fil, int col) {
		return casillas[fil][col];
	}

	// Sirve para calcular la distancia entre el personaje y el circulo de salida
	public int getxSalida() {
		return xSalida;
	}

	public int getySalida() {
		return ySalida;
	}
	
	public int getxSalida2() {
		return xSalida2;
	}
	
	public int getySalida2() {
		return ySalida2;
	}

	// Sirve para reacomodar el circulo de salida, dependiendo de la pantalla
	public void setCol(int col) {
		this.col = col;
	}

	public void setFil(int fil) {
		this.fil = fil;
	}
}
