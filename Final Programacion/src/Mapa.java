import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Mapa {

	private int[][] casillas;
	private PImage img, salida, retorno;
	private int xSalida, ySalida, xSalida2, ySalida2, xRetorno, yRetorno, xSalida3, ySalida3;
	private int col, fil, col2, fil2, col3, fil3;
	private int pantalla;

	public Mapa(PImage img, int pantalla, PImage salida, PImage retorno) {
		casillas = new int[14][24];
		this.pantalla = pantalla;

		// Imagenes
		this.img = img;
		this.salida = salida;
		this.retorno = retorno;

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
		
		//Borde castillo
		if (pantalla == 9) {
			for (int j = 0; j < 14; j++) {
				casillas[j][0] = 1;
				casillas[j][21] = 1;
			}
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
		
		//Salida pantalla 9
		this.col3 = 20;
		this.fil3 = 6;
		this.xSalida3 = 25 + (col3 * 50);
		this.ySalida3 = 25 + (fil3 * 50);
		
		//Retorno pantallas
		this.col3 = 2;
		this.fil3 = 2;
		this.xRetorno = 25 + (col3 * 50);
		this.yRetorno = 25 + (fil3 * 50);

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
					app.stroke(255);
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
		app.imageMode(PConstants.CENTER);
		if (pantalla == 2) {
			app.image(salida, xSalida2, ySalida2, 50, 50);
		} else if (pantalla == 9) {
			app.image(salida, xSalida3, ySalida3, 50, 50);
		} else if (pantalla < 10) {
			app.image(salida, xSalida, ySalida, 50, 50);
		}
		
		//Circulo retorno
		if (pantalla > 2) {
			if (pantalla == 3) {
				app.image(retorno, xRetorno, yRetorno, 40, 40);
			} else if (pantalla<10) {
				app.image(retorno, xRetorno, yRetorno, 40, 40);
			}
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
	
	public int getxRetorno() {
		return xRetorno;
	}
	
	public int getyRetorno() {
		return yRetorno;
	}
	
	public int getxSalida3() {
		return xSalida3;
	}
	
	public int getySalida3() {
		return ySalida3;
	}
}
