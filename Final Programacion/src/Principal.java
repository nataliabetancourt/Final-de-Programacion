import java.util.ArrayList;

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

	// Fotos de fondo													// Fotos de obstaculos
	PImage portada, cueva, dia1, dia2, tarde, noche;		PImage arbolD, arbolT, arbolN, ladrillo;
	//Foto de inventario												//Fotos botones
	PImage m, nota;													PImage start;
	// Matriz																
	Mapa mapa2, mapa3, mapa4, mapa5, mapa6, mapa7, mapa8, mapa9;		
	//Obstaculos	
	Obstaculos obs2, obs3, obs4, obs5, obs6, obs7, obs8, obs9;
	// Personaje	
	Personaje p;
	//Inventario
	Maletin maleta;
	Inventario elementos1;
	public ArrayList<Inventario> eleInventario, eleInventario2, eleInventario3,  eleInventario4,  eleInventario5,  eleInventario6,  eleInventario7,  eleInventario8;
	// Estado de las pantallas
	int pantallas;
	//Indicador de tiempo sobre circulo de salida para pantallas, al llegar a 100, cambia de pantalla
	int tiempoSalida;
	//Indicar de que si se hizo click sobre el maletin
	boolean clickMaleta;
	//Arreglo de fotos y contador de imagenes
	PImage [] imagenes;
	int contador;

	@Override
	public void setup() {
		//Pantalla 1														//Pantalla 2
		portada	= loadImage("Portada-01.jpg");				cueva = loadImage("cueva_texturizado.png");
		// Pantalla 3 														//Pantalla 4
		dia1 = loadImage("Fondos-01.jpg");					dia2 = loadImage("Fondos-02.jpg");
		// Pantalla 5 														//Pantalla 6
		tarde = loadImage("Fondos-03.jpg");					noche = loadImage("Fondos-04.jpg");
		//Arbol Dia															//Arbol Tarde
		arbolD = loadImage("Arboles-05.png");				arbolT = loadImage("Arboles-06.png");
		//Arbol Noche														//Ladrillo
		arbolN = loadImage("Arboles-07.png");				ladrillo = loadImage("cuadro_texturizado.png");
		//Inventario														//Nota			
		m = loadImage("Maletin-05.png");						nota = loadImage("Inventario-04.png");	
		//Start
		start = loadImage("Start-02.png");
	
		
		mapa2 = new Mapa(cueva, 2);							obs2 = new Obstaculos(2);
		mapa3 = new Mapa(dia1, 3);								obs3 = new Obstaculos(3);
		mapa4 = new Mapa(dia2, 4);								obs4 = new Obstaculos(4);
		mapa5 = new Mapa(tarde, 5);								obs5 = new Obstaculos(5);
		mapa6 = new Mapa(noche, 6);							obs6 = new Obstaculos(6);
		mapa7 = new Mapa(dia2, 7);								obs7 = new Obstaculos(7);
		mapa8 = new Mapa(tarde, 8);								obs8 = new Obstaculos(8);
		mapa9 = new Mapa(noche, 9);							obs9 = new Obstaculos(9);
		p = new Personaje(11, 1, mapa2, obs2);
		maleta = new Maletin();
		eleInventario = new ArrayList<Inventario>();		eleInventario2 = new ArrayList<Inventario>();
		eleInventario3 = new ArrayList<Inventario>();		eleInventario4 = new ArrayList<Inventario>();
		eleInventario5 = new ArrayList<Inventario>();		eleInventario6 = new ArrayList<Inventario>();
		eleInventario7 = new ArrayList<Inventario>();		eleInventario8 = new ArrayList<Inventario>();
		
		imagenes = new PImage [3];
		
		contador = 1;
		for (int i = 0; i < 3; i++) {
			imagenes[i] = loadImage("Inventario-0"+contador+".png");
			contador++;
		}
		

		for (int i = 0; i < 3; i++) {
			int colTemp = (int) random (1, 22);
			int filTemp = (int) random (1,12);
			int imagenElemento = (int) random(3);
			eleInventario.add(new Inventario(colTemp, filTemp, imagenes[imagenElemento]));
			eleInventario2.add(new Inventario(colTemp, filTemp, imagenes[imagenElemento]));
			eleInventario3.add(new Inventario(colTemp, filTemp, imagenes[imagenElemento]));
			eleInventario4.add(new Inventario(colTemp, filTemp, imagenes[imagenElemento]));
			eleInventario5.add(new Inventario(colTemp, filTemp, imagenes[imagenElemento]));
			eleInventario6.add(new Inventario(colTemp, filTemp, imagenes[imagenElemento]));
			eleInventario7.add(new Inventario(colTemp, filTemp, imagenes[imagenElemento]));
			eleInventario8.add(new Inventario(colTemp, filTemp, imagenes[imagenElemento]));
		}
		
		pantallas = 1;
		tiempoSalida = 0;
		clickMaleta = false;

	}

	@Override
	public void draw() {
		background(0);
		switch (pantallas) {
		case 1:
			imageMode(CORNER);
			image(portada, 0, 0);
			imageMode(CENTER);
			image(start, width/2, 500, 200, 50);
			break;
		case 2:
			mapa2.pintar(this);
			validarSalida(3, 11, 1);
			obs2.pintar(this, ladrillo, 121, 92);
			for (int i = 0; i < eleInventario.size(); i++) {
				Inventario actual = eleInventario.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarElemento(eleInventario.get(i));
					eleInventario.remove(i);
				}
			}

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
			for (int i = 0; i < eleInventario2.size(); i++) {
				Inventario actual = eleInventario2.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarElemento(eleInventario2.get(i));
					eleInventario2.remove(i);
				}
			}
			validarSalida(4, 1, 6);
			validarRetorno(2, 11, 1);
			break;
		case 4:
			p.setRefMapa(mapa4);
			p.setObs(obs4);
			mapa4.pintar(this);
			obs4.pintar(this, arbolD, 80, 80);
			for (int i = 0; i < eleInventario3.size(); i++) {
				Inventario actual = eleInventario3.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarElemento(eleInventario3.get(i));
					eleInventario3.remove(i);
				}
			}
			validarSalida(5, 1, 6);
			validarRetorno(3, 1, 6);
			break;
		case 5:
			p.setRefMapa(mapa5);
			p.setObs(obs5);
			mapa5.pintar(this);
			obs5.pintar(this, arbolT, 80, 80);
			for (int i = 0; i < eleInventario4.size(); i++) {
				Inventario actual = eleInventario4.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarElemento(eleInventario4.get(i));
					eleInventario4.remove(i);
				}
			}
			validarSalida(6, 1, 6);
			validarRetorno(4, 1, 6);
			break;
		case 6:
			p.setRefMapa(mapa6);
			p.setObs(obs6);
			mapa6.pintar(this);
			obs6.pintar(this, arbolN, 80, 80);
			for (int i = 0; i < eleInventario5.size(); i++) {
				Inventario actual = eleInventario5.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarElemento(eleInventario5.get(i));
					eleInventario5.remove(i);
				}
			}
			validarSalida(7, 1, 6);
			validarRetorno(5, 1, 6);
			break;
		case 7:
			p.setRefMapa(mapa7);
			p.setObs(obs7);
			mapa7.pintar(this);
			obs7.pintar(this, arbolD, 80, 80);
			for (int i = 0; i < eleInventario6.size(); i++) {
				Inventario actual = eleInventario6.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarElemento(eleInventario6.get(i));
					eleInventario6.remove(i);
				}
			}
			validarSalida(8, 1, 6);
			validarRetorno(6, 1, 6);
			break;
		case 8:
			p.setRefMapa(mapa8);
			p.setObs(obs8);
			mapa8.pintar(this);
			obs8.pintar(this, arbolT, 80, 80);
			for (int i = 0; i < eleInventario7.size(); i++) {
				Inventario actual = eleInventario7.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarElemento(eleInventario7.get(i));
					eleInventario7.remove(i);
				}
			}
			validarSalida(9, 1, 6);
			validarRetorno(7, 1, 6);
			break;
		case 9:
			p.setRefMapa(mapa9);
			p.setObs(obs9);
			mapa9.pintar(this);
			obs9.pintar(this, arbolN, 80, 80);
			for (int i = 0; i < eleInventario8.size(); i++) {
				Inventario actual = eleInventario8.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarElemento(eleInventario8.get(i));
					eleInventario8.remove(i);
				}
			}
			validarRetorno(8, 1, 6);
			break;
			
		}
		
		if (pantallas > 1) {
			p.pintar(this);
			maleta.pintar(this, m);
		}
		
		if (clickMaleta == true) {
			maleta.pintarAbierto(this);
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
	
	public void validarRetorno(int pantalla, int col, int fil) {
		if (dist(p.getX(), p.getY(), mapa3.getxRetorno(), mapa3.getyRetorno())<25) {
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
		if (mouseX > width/2-75 && mouseX < width/2+75 && mouseY >475 && mouseY < 525) {
			pantallas = 2;
		}
		if (dist(mouseX, mouseY, maleta.getX(), maleta.getY())<60) {
			clickMaleta = true;
		}
		if (dist(mouseX, mouseY, maleta.getX2(), maleta.getY2())<10) {
			clickMaleta = false;
		}
	}

}
