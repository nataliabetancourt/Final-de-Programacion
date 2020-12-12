package Principal;
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

	// Fotos de fondo												
	PImage portada, cueva, dia1, dia2, tarde, noche, castilloExterior, castilloInterior;		
	// Fotos de obstaculos
	PImage arbolD, arbolT, arbolN, ladrillo;
	//Foto de inventario										
	PImage m, nota;
	//Fotos botones
	PImage start, salida1, salida2, retorno1, retorno2;
	// Matriz																
	Mapa mapa2, mapa3, mapa4, mapa5, mapa6, mapa7, mapa8, mapa9, mapa10;		
	//Obstaculos	
	Obstaculos obs2, obs3, obs4, obs5, obs6, obs7, obs8, obs9;
	// Personaje	
	Personaje p;
	//Inventario
	Maletin maleta;
	Inventario elementos1;
	public ArrayList<Inventario> listaG, listaN, lista2G,  lista2N;
	public ArrayList<Inventario> lista3G, lista3N, lista4G,  lista4N;
	public ArrayList<Inventario> lista5G, lista5N, lista6G,  lista6N;
	public ArrayList<Inventario> lista7G, lista7N, lista8G,  lista8N;
	// Estado de las pantallas
	int pantallas;
	//Indicador de tiempo sobre circulo de salida para pantallas, al llegar a 100, cambia de pantalla
	int tiempoSalida;
	//Indicar de que si se hizo click sobre el maletin
	boolean clickMaleta;
	//Fotos inventario
	PImage gema, naranja;

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
		//Inventario														//Start		
		m = loadImage("Maletin-05.png");						start = loadImage("Start-02.png");
		//Gema																//Naranjas
		gema = loadImage("Inventario-02.png");				naranja = loadImage("Inventario-01.png");	
		//Salida1															//Salida2
		salida1 = loadImage("Salidas-06.png");				salida2 = loadImage("Salidas-07.png");
		//Retorno1															//Retorno2
		retorno1 = loadImage("Salidas-08.png");				retorno2 = loadImage("Salidas-09.png");		
		//Castillo por fuera												//Castillo por dentro
		castilloExterior = loadImage("castillos-01.jpg");	castilloInterior = loadImage("castillos-02.jpg");
	
		//Llamada de clases
		mapa2 = new Mapa(cueva, 2, salida2, retorno1);				obs2 = new Obstaculos(2);
		mapa3 = new Mapa(dia1, 3, salida1, retorno2);				obs3 = new Obstaculos(3);
		mapa4 = new Mapa(dia2, 4, salida1, retorno1);				obs4 = new Obstaculos(4);
		mapa5 = new Mapa(tarde, 5, salida1, retorno1);				obs5 = new Obstaculos(5);
		mapa6 = new Mapa(noche, 6, salida1, retorno1);				obs6 = new Obstaculos(6);
		mapa7 = new Mapa(dia2, 7, salida1, retorno1);				obs7 = new Obstaculos(7);
		mapa8 = new Mapa(tarde, 8, salida1, retorno1);				obs8 = new Obstaculos(8);
		mapa9 = new Mapa(castilloExterior, 9, salida1, retorno1);	obs9 = new Obstaculos(9);
		mapa10 = new Mapa(castilloInterior, 10, salida1, retorno1);
		p = new Personaje(11, 1, mapa2, obs2);
		maleta = new Maletin();
		listaG = new ArrayList<Inventario>();					listaN = new ArrayList<Inventario>();
		lista2G = new ArrayList<Inventario>();				lista2N = new ArrayList<Inventario>();
		lista3G = new ArrayList<Inventario>();				lista3N = new ArrayList<Inventario>();
		lista4G = new ArrayList<Inventario>();				lista4N = new ArrayList<Inventario>();
		lista5G = new ArrayList<Inventario>();				lista5N = new ArrayList<Inventario>();
		lista6G = new ArrayList<Inventario>();				lista6N = new ArrayList<Inventario>();
		lista7G = new ArrayList<Inventario>();				lista7N = new ArrayList<Inventario>();
		
		//Listas de gemas y naranjas para cada pantalla
		for (int i = 0; i < 3; i++) {
			int colTemp1 = (int) random (1, 22);
			int filTemp1 = (int) random (1,12);
			int colTemp2 = (int) random (1, 22);
			int filTemp2 = (int) random (1,12);
			listaG.add(new Inventario(colTemp1, filTemp1, gema));		listaN.add(new Inventario(colTemp2, filTemp2, naranja));
			lista2G.add(new Inventario(colTemp1, filTemp1, gema));	lista2N.add(new Inventario(colTemp2, filTemp2, naranja));
			lista3G.add(new Inventario(colTemp1, filTemp1, gema));	lista3N.add(new Inventario(colTemp2, filTemp2, naranja));
			lista4G.add(new Inventario(colTemp1, filTemp1, gema));	lista4N.add(new Inventario(colTemp2, filTemp2, naranja));
			lista5G.add(new Inventario(colTemp1, filTemp1, gema));	lista5N.add(new Inventario(colTemp2, filTemp2, naranja));
			lista6G.add(new Inventario(colTemp1, filTemp1, gema));	lista6N.add(new Inventario(colTemp2, filTemp2, naranja));
			lista7G.add(new Inventario(colTemp1, filTemp1, gema));	lista7N.add(new Inventario(colTemp2, filTemp2, naranja));
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
			
			//Gemas regados por mapa
			for (int i = 0; i < listaG.size(); i++) {
				Inventario actual = listaG.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarGema(listaG.get(i));
					listaG.remove(i);
				}
			}
			
			//Naranjas regados por el mapa
			for (int i = 0; i < listaN.size(); i++) {
				Inventario actual = listaN.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarNaranja(listaN.get(i));
					listaN.remove(i);
				}
			}
			
			obs2.pintar(this, ladrillo, 121, 92);

			//Validar salida especial por ubicacion del circulo
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
			
			//Gemas regados por mapa
			for (int i = 0; i < lista2G.size(); i++) {
				Inventario actual = lista2G.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarGema(lista2G.get(i));
					lista2G.remove(i);
				}
			}
			
			//Naranjas regados por el mapa
			for (int i = 0; i < lista2N.size(); i++) {
				Inventario actual = lista2N.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarNaranja(lista2N.get(i));
					lista2N.remove(i);
				}
			}
			
			obs3.pintar(this, arbolD, 80, 80);
			validarSalida(4, 1, 6);
			validarRetorno(2, 11, 1);
			break;
		case 4:
			p.setRefMapa(mapa4);
			p.setObs(obs4);
			mapa4.pintar(this);
			
			//Gemas regados por mapa
			for (int i = 0; i < lista3G.size(); i++) {
				Inventario actual = lista3G.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarGema(lista3G.get(i));
					lista3G.remove(i);
				}
			}
			
			//Naranjas regados por el mapa
			for (int i = 0; i < lista3N.size(); i++) {
				Inventario actual = lista3N.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarNaranja(lista3N.get(i));
					lista3N.remove(i);
				}
			}
			
			obs4.pintar(this, arbolD, 80, 80);
			validarSalida(5, 1, 6);
			validarRetorno(3, 1, 6);
			break;
		case 5:
			p.setRefMapa(mapa5);
			p.setObs(obs5);
			mapa5.pintar(this);
		
			//Gemas regados por mapa
			for (int i = 0; i < lista4G.size(); i++) {
				Inventario actual = lista4G.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarGema(lista4G.get(i));
					lista4G.remove(i);
				}
			}
			
			//Naranjas regados por el mapa
			for (int i = 0; i < lista4N.size(); i++) {
				Inventario actual = lista4N.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarNaranja(lista4N.get(i));
					lista4N.remove(i);
				}
			}
			
			obs5.pintar(this, arbolT, 80, 80);
			validarSalida(6, 1, 6);
			validarRetorno(4, 1, 6);
			break;
		case 6:
			p.setRefMapa(mapa6);
			p.setObs(obs6);
			mapa6.pintar(this);
			
			//Gemas regados por mapa
			for (int i = 0; i < lista5G.size(); i++) {
				Inventario actual = lista5G.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarGema(lista5G.get(i));
					lista5G.remove(i);
				}
			}
			
			//Naranjas regados por el mapa
			for (int i = 0; i < lista5N.size(); i++) {
				Inventario actual = lista5N.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarNaranja(lista5N.get(i));
					lista5N.remove(i);
				}
			}
			
			obs6.pintar(this, arbolN, 80, 80);
			validarSalida(7, 1, 6);
			validarRetorno(5, 1, 6);
			break;
		case 7:
			p.setRefMapa(mapa7);
			p.setObs(obs7);
			mapa7.pintar(this);
			
			//Gemas regados por mapa
			for (int i = 0; i < lista6G.size(); i++) {
				Inventario actual = lista6G.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarGema(lista6G.get(i));
					lista6G.remove(i);
				}
			}
			
			//Naranjas regados por el mapa
			for (int i = 0; i < lista6N.size(); i++) {
				Inventario actual = lista6N.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarNaranja(lista6N.get(i));
					lista6N.remove(i);
				}
			}
			
			obs7.pintar(this, arbolD, 80, 80);
			validarSalida(8, 1, 6);
			validarRetorno(6, 1, 6);
			break;
		case 8:
			p.setRefMapa(mapa8);
			p.setObs(obs8);
			mapa8.pintar(this);
			
			//Gemas regados por mapa
			for (int i = 0; i < lista7G.size(); i++) {
				Inventario actual = lista7G.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarGema(lista7G.get(i));
					lista7G.remove(i);
				}
			}
			
			//Naranjas regados por el mapa
			for (int i = 0; i < lista7N.size(); i++) {
				Inventario actual = lista7N.get(i);
				actual.pintar(this);
				
				if (dist(p.getX(), p.getY(), actual.getX(), actual.getY())<5) {
					maleta.agregarNaranja(lista7N.get(i));
					lista7N.remove(i);
				}
			}
			
			obs8.pintar(this, arbolT, 80, 80);
			validarSalida(9, 1, 6);
			validarRetorno(7, 1, 6);
			break;
		case 9:
			p.setRefMapa(mapa9);
			p.setObs(obs9);
			mapa9.pintar(this);
			obs9.pintar(this, arbolN, 80, 80);
			
			//Validar salida especial por ubicacion del circulo
			if (dist(p.getX(), p.getY(), mapa3.getxSalida3(), mapa3.getySalida3())<25) {
				tiempoSalida++;
				if (tiempoSalida == 100) {
					p.setCol(1);
					p.setFil(6);
					pantallas = 10;
					tiempoSalida = 0;
				}
			}
		
			validarRetorno(8, 1, 6);
			break;
		case 10:
			p.setRefMapa(mapa10);
			mapa10.pintar(this);
			break;
		}
		
		if (pantallas > 1) {
			p.pintar(this);
			maleta.pintar(this, m);
		}
		
		if (clickMaleta == true) {
			maleta.pintarAbierto(this, gema, naranja);
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
