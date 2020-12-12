import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Obstaculos {

	private int casillas[][];
	private int col, fil;
	private int xObs, yObs;

	public Obstaculos(int pantalla) {
		casillas = new int[14][24];
		
		// Filas y columnas del mapa
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 24; j++) {
				casillas[i][j] = 0;
			}
		}
		
		//Filas y columnas de los obstaculos
		switch (pantalla) {
		case 2:
			fil = 5;		col = 22;
			casillas[fil][col] = 1;
			
			col = 21;
			casillas[fil][col] = 1;
			
			col = 20;
			casillas[fil][col] = 1;
	
			break;
		case 3:
			fil = 8;			col = 22;
			casillas[fil][col] = 1;
			
			fil = 10;			col = 1;
			casillas[fil][col] = 1;
			
			fil = 5;			col = 5;
			casillas[fil][col] = 1;
			
			fil = 12;			col = 16;
			casillas[fil][col] = 1;
			
			break;
		case 4:
			fil = 10;			col = 3;
			casillas[fil][col] = 1;
			
			fil = 13;			col = 20;
			casillas[fil][col] = 1;
			
			fil = 2;			col = 12;
			casillas[fil][col] = 1;
			
			fil = 3;			col = 22;
			casillas[fil][col] = 1;
			
			fil = 9;			col = 7;
			casillas[fil][col] = 1;
	
			break;
		case 5:
			fil = 9;			col = 10;
			casillas[fil][col] = 1;
			
			fil = 13;			col = 20;
			casillas[fil][col] = 1;
			
			fil = 2;			col = 12;
			casillas[fil][col] = 1;
			
			fil = 11;			col = 21;
			casillas[fil][col] = 1;
			
			fil = 9;			col = 7;
			casillas[fil][col] = 1;
			
			fil = 2;			col = 16;
			casillas[fil][col] = 1;

			break;
		case 6:
			fil = 10;			col = 10;
			casillas[fil][col] = 1;
			
			fil = 3;			col = 12;
			casillas[fil][col] = 1;
			
			fil = 2;			col = 3;
			casillas[fil][col] = 1;
			
			fil = 11;			col = 22;
			casillas[fil][col] = 1;
			
			fil = 9;			col = 3;
			casillas[fil][col] = 1;
			
			fil = 1;			col = 15;
			casillas[fil][col] = 1;
			
			fil = 11;			col = 4;
			casillas[fil][col] = 1;
	
			break;
		case 7:
			fil = 7;			col = 10;
			casillas[fil][col] = 1;
			
			fil = 3;			col = 19;
			casillas[fil][col] = 1;
			
			fil = 2;			col = 8;
			casillas[fil][col] = 1;
			
			fil = 2;			col = 16;
			casillas[fil][col] = 1;
			
			fil = 10;			col = 4;
			casillas[fil][col] = 1;
			
			fil = 9;			col = 21;
			casillas[fil][col] = 1;
			
			fil = 12;			col = 4;
			casillas[fil][col] = 1;
			
			fil = 5;			col = 10;
			casillas[fil][col] = 1;
			
			break;
		case 8:
			fil = 10;			col = 4;
			casillas[fil][col] = 1;
			
			fil = 11;			col = 10;
			casillas[fil][col] = 1;
			
			fil = 9;			col = 3;
			casillas[fil][col] = 1;
			
			fil = 3;			col = 4;
			casillas[fil][col] = 1;
			
			fil = 7;			col = 7;
			casillas[fil][col] = 1;
			
			fil = 12;			col = 5;
			casillas[fil][col] = 1;
			
			fil = 7;			col = 6;
			casillas[fil][col] = 1;
			
			fil = 9;			col = 20;
			casillas[fil][col] = 1;
			
			fil = 12;			col = 19;
			casillas[fil][col] = 1;
			
			break;
		}

	}

	public void pintar(PApplet app, PImage img, int ancho, int alto) {
		// Matriz del mapa
		for (int fil = 0; fil < 14; fil++) {
			for (int col = 0; col < 24; col++) {
				
				this.xObs = 25 + (col * 50);
				this.yObs = 25 + (fil * 50);
				
				switch (casillas[fil][col]) {
				case 0:
					app.noStroke();
					app.noFill();
					
					break;
				// Bordes
				case 1:
					app.imageMode(PConstants.CENTER);
					app.image(img, xObs, yObs, ancho, alto);
					app.fill(255,0,0);
					
					break;
				}
				xObs += 50;
			}
			xObs = 25;
			yObs += 50;
		}

	}
	// Devuelve el valor de la casillas --> 0 o 1
	public int getTipoCasilla(int fil, int col) {
		return casillas[fil][col];
	}
}
