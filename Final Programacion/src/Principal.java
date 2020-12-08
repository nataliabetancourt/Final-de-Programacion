import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() {
		size(1200, 700);

	}

	// Fotos de fondo												// Fotos de obstaculos
	PImage cueva, dia1, dia2, tarde, noche;				PImage arbolD, arbolT, arbolN, ladrillo;
	// Matriz																
	Mapa mapa2, mapa3, mapa4, mapa5, mapa6, mapa7, mapa8, mapa9;		
	//Obstaculos	
	Obstaculos obs2, obs3, obs4, obs5, obs6, obs7, obs8, obs9;
	// Personaje	
	Personaje p;
	// Estado de las pantallas
	int pantallas;
	//Indicador de tiempo sobre circulo de salida para pantallas, al llegar a 100, cambia de pantalla
	int tiempoSalida;

	@Override
	public void setup() {
		//Pantalla 1														//Pantalla 2
																				cueva = loadImage("cueva_texturizado.png");
		// Pantalla 3 														//Pantalla 4
		dia1 = loadImage("Fondos-01.jpg");					dia2 = loadImage("Fondos-02.jpg");
		// Pantalla 5 														//Pantalla 6
		tarde = loadImage("Fondos-03.jpg");					noche = loadImage("Fondos-04.jpg");
		//Arbol Dia															//Arbol Tarde
		arbolD = loadImage("Arboles-05.png");				arbolT = loadImage("Arboles-06.png");
		//Arbol Noche														//Ladrillo
		arbolN = loadImage("Arboles-07.png");				ladrillo = loadImage("cuadro_texturizado.png");
		
		mapa2 = new Mapa(cueva, 2);							obs2 = new Obstaculos(2);
		mapa3 = new Mapa(dia1, 3);								obs3 = new Obstaculos(3);
		mapa4 = new Mapa(dia2, 4);								obs4 = new Obstaculos(4);
		mapa5 = new Mapa(tarde, 5);								obs5 = new Obstaculos(5);
		mapa6 = new Mapa(noche, 6);							obs6 = new Obstaculos(6);
		mapa7 = new Mapa(dia2, 7);								obs7 = new Obstaculos(7);
		mapa8 = new Mapa(tarde, 8);								obs8 = new Obstaculos(8);
		mapa9 = new Mapa(noche, 9);							obs9 = new Obstaculos(9);
		p = new Personaje(11, 1, mapa2, obs2);

		pantallas = 1;
		tiempoSalida = 0;

	}

	@Override
	public void draw() {
		background(0);
		switch (pantallas) {
		case 1:
			background(255);
			fill(0);
			rectMode(CENTER);
			rect(width/2, height/2, 150, 50);
			break;
		case 2:
			mapa2.pintar(this);
			validarSalida(3, 11, 1);
			obs2.pintar(this, ladrillo, 121, 92);
			if (dist(p.getX(), p.getY(), mapa3.getxSalida2(), mapa3.getySalida2())<25) {
				tiempoSalida++;
				if (tiempoSalida == 100) {
					p.setCol(11);
					p.setFil(1);
					pantallas = 3;
					tiempoSalida = 0;
				}
			}
			break;
		case 3:
			p.setRefMapa(mapa3);
			p.setObs(obs3);
			mapa3.pintar(this);
			obs3.pintar(this, arbolD, 80, 80);
			validarSalida(4, 1, 6);
			break;
		case 4:
			p.setRefMapa(mapa4);
			p.setObs(obs4);
			mapa4.pintar(this);
			obs4.pintar(this, arbolD, 80, 80);
			validarSalida(5, 1, 6);
			break;
		case 5:
			p.setRefMapa(mapa5);
			p.setObs(obs5);
			mapa5.pintar(this);
			obs5.pintar(this, arbolT, 80, 80);
			validarSalida(6, 1, 6);
			break;
		case 6:
			p.setRefMapa(mapa6);
			p.setObs(obs6);
			mapa6.pintar(this);
			obs6.pintar(this, arbolN, 80, 80);
			validarSalida(7, 1, 6);
			break;
		case 7:
			p.setRefMapa(mapa7);
			p.setObs(obs7);
			mapa7.pintar(this);
			obs7.pintar(this, arbolD, 80, 80);
			validarSalida(8, 1, 6);
			break;
		case 8:
			p.setRefMapa(mapa8);
			p.setObs(obs8);
			mapa8.pintar(this);
			obs8.pintar(this, arbolT, 80, 80);
			validarSalida(9, 1, 6);
			break;
		case 9:
			p.setRefMapa(mapa9);
			p.setObs(obs9);
			mapa9.pintar(this);
			obs9.pintar(this, arbolN, 80, 80);
			validarSalida(10, 1, 6);
			break;
			
		}
		
		if (pantallas > 1) {
			p.pintar(this);
		}
		

	}
	
	public void validarSalida(int pantalla, int col, int fil) {
		if (dist(p.getX(), p.getY(), mapa3.getxSalida(), mapa3.getySalida())<25) {
			tiempoSalida++;
			if (tiempoSalida == 100) {
				p.setCol(col);
				p.setFil(fil);
				pantallas = pantalla;
				tiempoSalida = 0;
			}
		}
	}

	@Override
	public void keyPressed() {
		switch (key) {
		case 'w':
			p.mover("arriba");
			break;
		case 's':
			p.mover("abajo");
			break;
		case 'a':
			p.mover("izquierda");
			break;
		case 'd':
			p.mover("derecha");
			break;

		}
	}
	
	@Override
	public void mousePressed() {
		if (mouseX > width/2-75 && mouseX < width/2+75 && mouseY > height/2-25 && mouseY < height/2+25) {
			pantallas = 2;
		}
	}

}
