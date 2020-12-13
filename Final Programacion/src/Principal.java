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
	PImage portada, cueva, dia1, dia2, tarde, noche, castilloExterior, castilloInterior, gameOver, win;		
	// Fotos de obstaculos
	PImage arbolD, arbolT, arbolN, ladrillo;
	//Foto de inventario										
	PImage m, nota, notaG;
	//Foto decoracion
	PImage cama, tapete, closet, instrucciones;
	//Fotos botones
	PImage start, salida1, salida2, retorno1, retorno2, restart;
	// Matriz																
	Mapa mapa2, mapa3, mapa4, mapa5, mapa6, mapa7, mapa8, mapa9, mapa10;		
	//Obstaculos	
	Obstaculos obs2, obs3, obs4, obs5, obs6, obs7, obs8, obs9;
	// Personaje	
	Personaje p;
	//bala
	Bala B;
	//Enemigos
	Enemigos eB1, eB2, eB31, eB32, eB41, eB42, eB51, eB52, eB53, eB61, eB62;
	Enemigos eQ1, eQ21, eQ22, eQ31, eQ32, eQ41, eQ42, eQ43, eQ51, eQ52, eQ53, eQ61, eQ62, eQ63;
	Enemigos jefe;
	//Inventario
	Maletin maleta;
	Inventario elementos1;
	//Rompecabeza
	Rompecabeza dispararGemas, buscarGemas, combinacion;
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
	// contadores y swiches para verificar estados
	int cont1, cont11, cont2, cont22, cont3, cont33, cont4, cont44, contA, contB;
	boolean donw, up, izq, der, atack, atack2, atack3, shot, ofensivo;
	boolean daño, vidas;
	int contadorDaño, contadorAtack, contadorAtack3, contadorVidas;
	int naranjasVida;
	//Boolean juegos
	boolean disparoCompleto, buscarCompleto, combinacionCompleto;
	//Nota
	int x;
	int y;
	int contadorNota;
	boolean verNota;
	//Variables Rompecabezas Combinacion
	int combi, conter1, conter2, conter3, conter4,comcont;
	boolean pin1, pin2, pin3, pin4;
	String var1, var2, var3, var4;	
	int contadorColor;
	

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
		//Decoracion interior cueva
		cama = loadImage("Cueva-02.png");					tapete = loadImage("Cueva-03.png");
		closet = loadImage("Cueva-04.png");
		//Gameover														//Restart
		gameOver = loadImage("Gameover-01.png");		restart = loadImage("Restart-02.png");
		//Instrucciones													//Tesoro Final
		instrucciones = loadImage("TECLAS.png");			win = loadImage("You win.jpg");
		//Nota																//Nota Grande
		nota = loadImage("note-02.png");						notaG = loadImage("Nota-02.jpg");
		
		restart();
	}

	public void restart() {
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
		p = new Personaje(11, 1, mapa2, obs2,this,5);
		B = new Bala(p.getX(), p.getY(), this);
		maleta = new Maletin();
		listaG = new ArrayList<Inventario>();					listaN = new ArrayList<Inventario>();
		lista2G = new ArrayList<Inventario>();				lista2N = new ArrayList<Inventario>();
		lista3G = new ArrayList<Inventario>();				lista3N = new ArrayList<Inventario>();
		lista4G = new ArrayList<Inventario>();				lista4N = new ArrayList<Inventario>();
		lista5G = new ArrayList<Inventario>();				lista5N = new ArrayList<Inventario>();
		lista6G = new ArrayList<Inventario>();				lista6N = new ArrayList<Inventario>();
		lista7G = new ArrayList<Inventario>();				lista7N = new ArrayList<Inventario>();
		eB1 = new Enemigos(14, 1, mapa3, this, 10);
		eB2 = new Enemigos(22, 1, mapa4, this, 10);
		eB31 = new Enemigos(22, 1, mapa5, this, 10);
		eB32 = new Enemigos(4, 1, mapa5, this, 10);
		eB41 = new Enemigos(22, 6, mapa6, this, 10);
		eB42 = new Enemigos(22, 1, mapa6, this, 10);
		eB51 = new Enemigos(22, 1, mapa7, this, 10);
		eB52 = new Enemigos(22, 4, mapa7,  this, 10);
		eB53 = new Enemigos(22, 8, mapa7,  this, 10);
		eB61 = new Enemigos(22, 1, mapa8,  this, 10);
		eB62 = new Enemigos(22, 4, mapa8,  this, 10);
		eQ1 = new Enemigos(14, 4, mapa4, this, 15);
		eQ21 = new Enemigos(14, 4, mapa4, this, 15);
		eQ22 = new Enemigos(3, 8, mapa4, this, 15);
		eQ31 = new Enemigos(17, 9, mapa4, this, 15);
		eQ32 = new Enemigos(2, 10, mapa4, this, 15);
		eQ41 = new Enemigos(5, 6, mapa4, this, 15);
		eQ42 = new Enemigos(18, 5, mapa4, this, 15);
		eQ43 = new Enemigos(4, 7, mapa4, this, 15);
		eQ51 = new Enemigos(9, 6, mapa5, this, 15);
		eQ52 = new Enemigos(2, 7, mapa5, this, 15);
		eQ53 = new Enemigos(16, 4, mapa5, this, 15);
		eQ61 = new Enemigos(2, 7, mapa6, this, 15);
		eQ62 = new Enemigos(16, 4, mapa6, this, 15);
		eQ63 = new Enemigos(16, 4, mapa6, this, 15);
		jefe = new Enemigos(20, 6, mapa10, this, 50);
		dispararGemas = new Rompecabeza(this);
		buscarGemas = new Rompecabeza(this);
		combinacion = new Rompecabeza(600, 350);
		
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
		daño = true;
		atack2 = false;
		contadorDaño = 0;
		contadorAtack = 0;
		naranjasVida = 0;
		contadorVidas = 0;
		vidas = false;
		atack3 = false;
		contadorAtack3 = 0;
		disparoCompleto = false;
		buscarCompleto = false;
		combinacionCompleto = false;
		x = 175;
		y = 275;
		contadorNota = 0;
		verNota = false;
		combi = 0;
		comcont = 0;
		conter1 = 0;
		conter2 = 0;
		conter3 = 0;
		conter4 = 0;
		var1 = "1";
		var2 = "2";
		var3 = "3";
		var4 = "4";
		pin1 = false;
		pin2 = false;
		pin3 = false;
		pin4 = false;
		contadorColor = 0;
		ofensivo = false;

	}
	
	@Override
	public void draw() {
		background(0);
		
		if (shot == false) {
			B.setX(p.getX());
			B.setY(p.getY());
		}
		
		//Regula la quitada de vida
		if (daño == false) {
			contadorDaño++;
			if (contadorDaño >= 50) {
				daño = true;
				contadorDaño = 0;
			}
		}
		
		if (atack3 == false) {
			contadorAtack3++;
			if (contadorAtack3 >= 50) {
				atack3 = true;
				contadorAtack3 = 0;
			}
		}
		
		if (atack2 == true) {
			contadorAtack++;
			if (contadorAtack >= 2) {
				atack2 = false;
				contadorAtack = 0;
			}
		}
		
		if (vidas == true) {
			contadorVidas++;
			if (contadorVidas >= 2) {
				vidas = false;
				contadorVidas = 0;
	
			}
		}
		
		//Aumentar vida personaje
		naranjasVida = maleta.getNaranjasInventario().size();
	
		if (naranjasVida == 5) {
			vidas = true;
			if (vidas == true) {
				p.setLife(p.getLife()+1);
				maleta.removerNaranja();
			}
		}
		
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
			imageMode(CORNER);
			image(cama, 50, 50, 315, 315);
			image(tapete, 325, 150, 95, 125);
			image(closet, 1100, 50, 100, 200);
			
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
			
			//Instrucciones del juego
			imageMode(CENTER);
			image(instrucciones, 900, 500, 500, 300);
			
			//Validar salida rompecabezas
			if (dist(p.getX(), p.getY(), mapa3.getxSalida2(), mapa3.getySalida2())<25) {
				tiempoSalida++;
				if (tiempoSalida >= 100) {
					buscarGemas.pintarBuscarGema(this);
					if (buscarGemas.getClickA() == false && buscarGemas.getClickAm() == false && buscarGemas.getClickR() == false && buscarGemas.getClickV() == false) {
						buscarCompleto = true;
						if (buscarCompleto == true) {
							p.setCol(11);
							p.setFil(1);
							pantallas = 3;
							tiempoSalida = 0;
						}
					}
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
			
			if (atack3 == true) {
				validarFuego(eB1, shot);
			}
			
			if (atack2 == true) {
				validarEspada(eB1);
			}
			obs3.pintar(this, arbolD, 80, 80);
			if (daño==true) {
				validarEnemigo(eB1);
			}
			eB1.pintarBasicoy(this);
			eB1.moverBasicoy(2);
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
			
			if (atack3 == true) {
				validarFuego(eB2, shot);
				validarFuego(eQ1, shot);
			}
			
			if (atack2 == true) {
				validarEspada(eB2);
				validarEspada(eQ1);
			}
			if (daño==true) {
				validarEnemigo(eB2);
				validarEnemigo(eQ1);
			}
			obs4.pintar(this, arbolD, 80, 80);
			eB2.pintarBasicoy(this);
			eB2.moverBasicoy(3);
			eQ1.pintarQuieto(this);
			validarSalidaDisparar(dispararGemas, 5, 1, 6);
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
			
			if (atack3 == true) {
				validarFuego(eB31, shot);
				validarFuego(eB32, shot);
				validarFuego(eQ21, shot);
				validarFuego(eQ22, shot);
			}
			
			if (atack2 == true) {
				validarEspada(eB31);
				validarEspada(eB32);
				validarEspada(eQ21);
				validarEspada(eQ22);
			}
			if (daño==true) {
				validarEnemigo(eB31);
				validarEnemigo(eB32);
				validarEnemigo(eQ21);
				validarEnemigo(eQ22);
			}
			obs5.pintar(this, arbolT, 80, 80);
			eB31.pintarBasicoy(this);
			eB32.pintarBasicoy(this);
			eB31.moverBasicoy(4);
			eB32.moverBasicoy(4);
			eQ21.pintarQuieto(this);
			eQ22.pintarQuieto(this);
			validarSalida(6, 1, 6);
			validarRetorno(4, 1, 6);
			break;
		case 6:
			p.setRefMapa(mapa6);
			p.setObs(obs6);
			mapa6.pintar(this);
			image(nota, x, y, 50, 50);
			
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
			
			if (atack3 == true) {
				validarFuego(eB41, shot);
				validarFuego(eB42, shot);
				validarFuego(eQ31, shot);
				validarFuego(eQ32, shot);
			}
			
			if (atack2 == true) {
				validarEspada(eB41);
				validarEspada(eB42);
				validarEspada(eQ31);
				validarEspada(eQ32);
			}
			if (daño==true) {
				validarEnemigo(eB41);
				validarEnemigo(eB42);
				validarEnemigo(eQ31);
				validarEnemigo(eQ32);
			}
			eB41.pintarBasicox(this);
			eB42.pintarBasicoy(this);
			eB41.moverBasicox(5);
			eB42.moverBasicoy(5);
			eQ31.pintarQuieto(this);
			eQ32.pintarQuieto(this);
			obs6.pintar(this, arbolN, 80, 80);
			validarRetorno(5, 1, 6);
			
			
			//Recoger y mostrar nota
			if (dist(p.getX(), p.getY(), x, y)<25) {
				contadorNota++;
				if (contadorNota > 10) {
					verNota = true;
					if (verNota == true) {
						imageMode(CENTER);
						image(notaG, width/2, height/2, 480, 480);
						if (contadorNota > 50) {
							verNota = false;
						}
					}
				}
			}
			
			//Validar salida rompecabezas
			if (dist(p.getX(), p.getY(), mapa3.getxSalida(), mapa3.getySalida())<25) {
				tiempoSalida++;
				if (tiempoSalida >= 100) {
					combinacion.pintarCombinacion(this);

					if (combi >= 5) {
						combi = 0;
					}
					
					if(combi==4) {
						comcont++;
						if (comcont>=20) {
							comcont=0;
							combi++;
						}
					}

					combinacion.pintarRojoC(this, pin1);
					combinacion.pintarVerdeC(this, pin2);
					combinacion.pintarAzulC(this, pin3);
					combinacion.pintarPurpuraC(this, pin4);

					if (pin1 == true) {
						conter1++;
						if (conter1 >= 20) {
							conter1 = 0;
							pin1 = false;
						}
					}

					if (pin2 == true) {
						conter2++;
						if (conter2 >= 20) {
							conter2 = 0;
							pin2 = false;
						}
					}

					if (pin3 == true) {
						conter3++;
						if (conter3 >= 20) {
							conter3 = 0;
							pin3 = false;
						}
					}

					if (pin4 == true) {
						conter4++;
						if (conter4 >= 20) {
							conter4 = 0;
							pin4 = false;
						}
					}

					if (var1 == "rojo" && var2 == "rojo" && var3 == "verde" && var4 == "purpura") {
						combinacionCompleto = true;
					}else if(combi>=4) {
						textSize(32);
						fill(255, 0, 0);
						textAlign(CENTER);
						text("WRONG CODE", 600, 550);
					}
					
						if (combinacionCompleto == true) {
							p.setCol(1);
							p.setFil(6);
							pantallas = 7;
							tiempoSalida = 0;
						}
					}
				}	
			
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
			
			if (atack3 == true) {
				validarFuego(eB51, shot);
				validarFuego(eB52, shot);
				validarFuego(eB53, shot);
				validarFuego(eQ41, shot);
				validarFuego(eQ42, shot);
				validarFuego(eQ43, shot);
			}
			if (atack2 == true) {
				validarEspada(eB51);
				validarEspada(eB52);
				validarEspada(eB53);
				validarEspada(eQ41);
				validarEspada(eQ42);
				validarEspada(eQ43);
			}
			if (daño==true) {
				validarEnemigo(eB51);
				validarEnemigo(eB52);
				validarEnemigo(eB53);
				validarEnemigo(eQ41);
				validarEnemigo(eQ42);
				validarEnemigo(eQ43);
			}
			obs7.pintar(this, arbolD, 80, 80);
			eB51.pintarBasicoy(this);
			eB52.pintarBasicox(this);
			eB53.pintarBasicox(this);
			eB51.moverBasicoy(6);
			eB52.moverBasicox(6);
			eB53.moverBasicox(6);
			eQ41.pintarQuieto(this);
			eQ42.pintarQuieto(this);
			eQ43.pintarQuieto(this);
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
			
			if (atack3 == true) {
				validarFuego(eB61, shot);
				validarFuego(eB62, shot);
				validarFuego(eQ61, shot);
				validarFuego(eQ62, shot);
				validarFuego(eQ63, shot);
			}
			if (atack2 == true) {
				validarEspada(eB61);
				validarEspada(eB62);
				validarEspada(eQ61);
				validarEspada(eQ62);
				validarEspada(eQ63);
			}
			if (daño==true) {
				validarEnemigo(eB61);
				validarEnemigo(eB62);
				validarEnemigo(eQ41);
				validarEnemigo(eQ42);
				validarEnemigo(eQ43);
			}
			eB61.pintarBasicoy(this);
			eB62.pintarBasicox(this);
			eB61.moverBasicoy(6);
			eB62.moverBasicox(6);
			eQ61.pintarQuieto(this);
			eQ62.pintarQuieto(this);
			eQ63.pintarQuieto(this);
			obs8.pintar(this, arbolT, 80, 80);
			validarSalida(9, 1, 6);
			validarRetorno(7, 1, 6);
			break;
		case 9:
			p.setRefMapa(mapa9);
			p.setObs(obs9);
			mapa9.pintar(this);
			
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
			jefe.pintarJefe(this);
			jefe.moverJefe();
			
			//Validar distancia enemigo
			if (daño==true) {
				if (dist(p.getX(), p.getY(), jefe.getX(), jefe.getY())<80) {
					daño = false;
					p.setLife(p.getLife()-1);
				}
				if (p.getLife() == 0) {
					pantallas = 12;
				}
			}
		
			//Validar distancia ataque
			if (atack2 == true&& jefe.getLife() != 0) {
				switch (p.getdir()) {
				case 0: //Adelante
					if (dist(p.getX(), p.getY()+40, jefe.getX(), jefe.getY())<100) {
						jefe.setLife(jefe.getLife()-1);
					}
					break; 
				case 1: //Derecha
					if (dist(p.getX()+40, p.getY(), jefe.getX(), jefe.getY())<100) {
						jefe.setLife(jefe.getLife()-1);
					}
					break;
				case 2: //Atras
					if (dist(p.getX(), p.getY()-40, jefe.getX(), jefe.getY())<100) {
						jefe.setLife(jefe.getLife()-1);
					}
					break;
				case 3: //Izquierda
					if (dist(p.getX()-40, p.getY(), jefe.getX(), jefe.getY())<100) {
						jefe.setLife(jefe.getLife()-1);
					}
					break;
				}
			}

				if (atack3 == true && jefe.getLife() != 0) {
					if (shot == true) {
						switch (p.getdir()) {
						case 0: //Adelante
							if (dist(B.getX(), B.getY()+40, jefe.getX(), jefe.getY())<100) {
								jefe.setLife(jefe.getLife()-1);
							}
							break; 
						case 1: //Derecha
							if (dist(B.getX()+40, B.getY(), jefe.getX(), jefe.getY())<100) {
								jefe.setLife(jefe.getLife()-1);
							}
							break;
						case 2: //Atras
							if (dist(B.getX(), B.getY()-40, jefe.getX(), jefe.getY())<100) {
								jefe.setLife(jefe.getLife()-1);
							}
							break;
						case 3: //Izquierda
							if (dist(B.getX()-40, B.getY(), jefe.getX(), jefe.getY())<100) {
								jefe.setLife(jefe.getLife()-1);
							}
							break;
						}
					}
				}
				

				if (jefe.getLife() == 0) {
					jefe.setVivo(false);
					jefe.setX(10000);
				}
				
			break;
		case 12:
			background(0);
			imageMode(CENTER);
			image(gameOver, width/2, 300, 500, 130);
			image(restart, 1050, 630, 200, 50);
			break;
		case 13:
			background(0);
			imageMode(CORNER);
			image(win, 0, 0);
			rectMode(CORNER);
			fill(0, 80);
			stroke(255, 204, 44);
			strokeWeight(3);
			rect(25, 25, 270, 80);
			fill(255, 204, 44);
			textSize(34);
			textAlign(CORNER);
			imageMode(CENTER);
			image(gema, 60, 65, 60, 60);
			text("Gem: " + (maleta.getGemasInventario().size()*100), 100, 74);
			image(restart, 1050, 630, 200, 50);
			break;
		}
		
		if (pantallas > 1 && pantallas < 11) {
			maleta.pintar(this, m);
			p.miraLife(this);
			
			if (atack == true && p.getdir() == 2) {
				contA++;
				p.atckw(this);

				if (contA >= 30) {
					atack = false;
					contA = 0;
				}
			}

			if (atack == true && p.getdir() == 3) {
				contA++;
				p.atcka(this);

				if (contA >= 30) {
					atack = false;
					contA = 0;
				}
			}

			if (pantallas > 1) {

				switch (p.getdir()) {
				case 0:
					if (donw == false) {
						p.pintarS(this);
					}
					if (donw == true) {

						switch (cont11) {

						case 0:
							p.pintarS1(this);
							break;
						case 1:
							p.pintarS2(this);
							break;
						case 2:
							p.pintarS3(this);
							break;
						case 3:
							p.pintarS4(this);
							break;
						case 4:
							p.pintarS4(this);
							break;
						case 5:
							p.pintarS3(this);
							break;
						case 6:
							p.pintarS2(this);
							break;
						case 7:
							p.pintarS1(this);
							break;

						default:
							break;
						}

						cont1++;
						if (cont1 >= 10) {
							cont1 = 0;
						}
						if (cont1 == 9) {
							cont11++;
							if (cont11 >= 8) {
								cont11 = 0;
							}
						}

					}
					break;
				case 1:

					if (der == false) {
						p.pintarD(this);
					}
					if (der == true) {

						switch (cont44) {

						case 0:
							p.pintarA1(this);
							break;
						case 1:
							p.pintarA2(this);
							break;
						case 2:
							p.pintarA3(this);
							break;
						case 3:
							p.pintarA4(this);
							break;
						case 4:
							p.pintarA4(this);
							break;
						case 5:
							p.pintarA3(this);
							break;
						case 6:
							p.pintarA2(this);
							break;
						case 7:
							p.pintarA1(this);
							break;

						default:
							break;
						}

						cont4++;
						if (cont4 >= 10) {
							cont4 = 0;
						}
						if (cont4 == 9) {
							cont44++;
							if (cont44 >= 8) {
								cont44 = 0;
							}
						}

					}

					break;
				case 2:
					if (up == false) {
						p.pintarW(this);
					}
					if (up == true) {

						switch (cont22) {

						case 0:
							p.pintarW1(this);
							break;
						case 1:
							p.pintarW2(this);
							break;
						case 2:
							p.pintarW3(this);
							break;
						case 3:
							p.pintarW4(this);
							break;
						case 4:
							p.pintarW4(this);
							break;
						case 5:
							p.pintarW3(this);
							break;
						case 6:
							p.pintarW2(this);
							break;
						case 7:
							p.pintarW1(this);
							break;

						default:
							break;
						}

						cont2++;
						if (cont2 >= 10) {
							cont2 = 0;
						}
						if (cont2 == 9) {
							cont22++;
							if (cont22 >= 8) {
								cont22 = 0;
							}
						}

					}
					break;
				case 3:
					if (izq == false) {
						p.pintarA(this);
					}
					if (izq == true) {

						switch (cont33) {

						case 0:
							p.pintarD1(this);
							break;
						case 1:
							p.pintarD2(this);
							break;
						case 2:
							p.pintarD3(this);
							break;
						case 3:
							p.pintarD4(this);
							break;
						case 4:
							p.pintarD4(this);
							break;
						case 5:
							p.pintarD3(this);
							break;
						case 6:
							p.pintarD2(this);
							break;
						case 7:
							p.pintarD1(this);
							break;

						default:
							break;
						}

						cont3++;
						if (cont3 >= 10) {
							cont3 = 0;
						}
						if (cont3 == 9) {
							cont33++;
							if (cont33 >= 8) {
								cont33 = 0;
							}
						}

					}
					break;

				default:
					break;
				}
			}

			if (atack == true && p.getdir() == 0) {
				contA++;
				p.atcks(this);

				if (contA >= 30) {
					atack = false;
					contA = 0;
				}

			}

			if (atack == true && p.getdir() == 1) {
				contA++;
				p.atckd(this);

				if (contA >= 30) {
					atack = false;
					contA = 0;
				}
			}

			if (shot == true) {
				contB++;
				B.shot(this, p.getdir());

				if (contB >= 40) {
					shot = false;
					contB = 0;
					B.setX(p.getX());
					B.setY(p.getY());
				
				}
			}
			
			//Ganar
			if (jefe.getLife() == 0) {
				pantallas = 13;
			}
		}
		
		if (clickMaleta == true && pantallas < 11) {
			maleta.pintarAbierto(this, gema, naranja);
			
		}
	}
	
	//Circulo para seguir a otros pantallas
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
	
	//Circulo para seguir con juego
	public void validarSalidaDisparar(Rompecabeza ref, int pantalla, int col, int fil) {
		if (dist(p.getX(), p.getY(), mapa3.getxSalida(), mapa3.getySalida())<25) {
			tiempoSalida++;
			if (tiempoSalida >= 100) {
				dispararGemas.pintardispararGemas(this);
				if (dispararGemas.getPintado1() == false && dispararGemas.getPintado2() == false && dispararGemas.getPintado3() == false
					&& dispararGemas.getPintado4() == false && dispararGemas.getPintado5() == false && dispararGemas.getPintado6() == false
					&& dispararGemas.getPintado7()== false && dispararGemas.getPintado8() == false) {
					disparoCompleto = true;
					if (disparoCompleto == true) {
						p.setCol(col);
						p.setFil(fil);
						pantallas = pantalla;
						tiempoSalida = 0;
					}
				}
			}	
		}

	}
	
	//Circulo para regresar a otras pantallas
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
	
	//Enemigo le quita vida al personaje
	public  void validarEnemigo(Enemigos ref) {
		if (dist(p.getX(), p.getY(), ref.getX(), ref.getY())<50) {
			daño = false;
			p.setLife(p.getLife()-1);
		}
		
		if (p.getLife() == 0) {
			pantallas = 12;
		}
	}
	
	//Personaje le quita vida el enemigo con espada
	public void validarEspada(Enemigos ref) {
		switch (p.getdir()) {
		case 0: //Adelante
			if (dist(p.getX(), p.getY()+40, ref.getX(), ref.getY())<60) {
				ref.setLife(ref.getLife()-1);
			}
			break; 
		case 1: //Derecha
			if (dist(p.getX()+40, p.getY(), ref.getX(), ref.getY())<60) {
				ref.setLife(ref.getLife()-1);
			}
			break;
		case 2: //Atras
			if (dist(p.getX(), p.getY()-40, ref.getX(), ref.getY())<60) {
				ref.setLife(ref.getLife()-1);
			}
			break;
		case 3: //Izquierda
			if (dist(p.getX()-40, p.getY(), ref.getX(), ref.getY())<60) {
				ref.setLife(ref.getLife()-1);
			}
			break;
		}

		if (ref.getLife() == 0) {
			ref.setVivo(false);
			ref.setX(10000);
		}
	}
	
	public void validarFuego(Enemigos ref, boolean ofensivo) {
		if (ofensivo == true) {
			switch (p.getdir()) {
			case 0: //Adelante
				if (dist(B.getX(), B.getY(), ref.getX(), ref.getY())<20) {
					ref.setLife(ref.getLife()-1);
				}
				break; 
			case 1: //Derecha
				if (dist(B.getX(), B.getY(), ref.getX(), ref.getY())<20) {
					ref.setLife(ref.getLife()-1);
				}
				break;
			case 2: //Atras
				if (dist(B.getX(), B.getY(), ref.getX(), ref.getY())<20) {
					ref.setLife(ref.getLife()-1);
				}
				break;
			case 3: //Izquierda
				if (dist(B.getX(), B.getY(), ref.getX(), ref.getY())<20) {
					ref.setLife(ref.getLife()-1);
				}
				break;
			}
		}

		if (ref.getLife() == 0) {
			ref.setVivo(false);
			ref.setX(10000);
		}
	}

	
	@Override
	public void keyPressed() {
		switch (key) {
		case 'w':
			p.mover("arriba");
			
			up = true;
			break;
		case 's':
			p.mover("abajo");
			donw = true;
			break;
		case 'a':
			p.mover("izquierda");
			izq = true;
			break;
		case 'd':
			p.mover("derecha");
			der = true;
			break;
		case 'p':
			atack = true;
			atack2 = true;
			break;
		case 'o':
			shot = true;
			atack3 = true;
			break;
		}
	}

	public void keyReleased() {
		if (key == 's') {
			donw = false;
			cont1 = 0;
		}
		if (key == 'w') {
			up = false;
			cont2 = 0;
		}
		if (key == 'd') {
			der = false;
			cont4 = 0;

		}
		if (key == 'a') {
			izq = false;
			cont3 = 0;
		}
	}

	@Override
	public void mousePressed() {
		//Start
		if (mouseX > width/2-75 && mouseX < width/2+75 && mouseY >475 && mouseY < 525) {
			pantallas = 2;
		}
		
		//Restart
		if (mouseX > 950 && mouseX < 1150 && mouseY > 605 && mouseY < 655 && pantallas == 13 || pantallas == 12) {
			pantallas = 1;
			restart();
		}
		
		//Maleta
		if (dist(mouseX, mouseY, maleta.getX(), maleta.getY())<60) {
			clickMaleta = true;
		}
		if (dist(mouseX, mouseY, maleta.getX2(), maleta.getY2())<10) {
			clickMaleta = false;
		}
		
		//Rompecabezas disparo
		if (disparoCompleto == false) {
			if (dist(mouseX, mouseY, dispararGemas.getX1(), dispararGemas.getY()) < dispararGemas.getMinDist()) {
				dispararGemas.setPintado1(false);
			}

			if (dist(mouseX, mouseY, dispararGemas.getX2(), dispararGemas.getY()) < dispararGemas.getMinDist()) {
				dispararGemas.setPintado2(false);
			}

			if (dist(mouseX, mouseY, dispararGemas.getX3(), dispararGemas.getY()) < dispararGemas.getMinDist()) {
				dispararGemas.setPintado3(false);
			}

			if (dist(mouseX, mouseY, dispararGemas.getX4(), dispararGemas.getY()) < dispararGemas.getMinDist()) {
				dispararGemas.setPintado4(false);
			}

			if (dist(mouseX, mouseY, dispararGemas.getX5(), dispararGemas.getY()) < dispararGemas.getMinDist()) {
				dispararGemas.setPintado5(false);
			}

			if (dist(mouseX, mouseY, dispararGemas.getX6(), dispararGemas.getY()) < dispararGemas.getMinDist()) {
				dispararGemas.setPintado6(false);
			}
			
			if (dist(mouseX, mouseY, dispararGemas.getX7(), dispararGemas.getY()) < dispararGemas.getMinDist()) {
				dispararGemas.setPintado7(false);
			}
			
			if (dist(mouseX, mouseY, dispararGemas.getX8(), dispararGemas.getY()) < dispararGemas.getMinDist()) {
				dispararGemas.setPintado8(false);
			}
		}
		
		//Rompecabezas buscar
		if (buscarCompleto == false) {
			if (dist(mouseX, mouseY, buscarGemas.getXgA(), buscarGemas.getYgA())<10) {
				buscarGemas.setClickA(false);
			}
			if (dist(mouseX, mouseY, buscarGemas.getXgAm(), buscarGemas.getYgAm())<10) {
				buscarGemas.setClickAm(false);
			}
			if (dist(mouseX, mouseY, buscarGemas.getXgR(), buscarGemas.getYgR())<10) {
				buscarGemas.setClickR(false);
			}
			if (dist(mouseX, mouseY, buscarGemas.getXgV(), buscarGemas.getYgV())<10) {
				buscarGemas.setClickV(false);
			}
		}
		
		if (combinacionCompleto == false) {
			if (dist(mouseX, mouseY, combinacion.getBlock1x(), combinacion.getBlock1y()) < 50 && combi == 0) {
				var1 = "rojo";
				pin1 = true;

			}
			if (dist(mouseX, mouseY, combinacion.getBlock2x(), combinacion.getBlock2y()) < 50 && combi == 0) {

				var1 = "verde";
				pin2 = true;

			}

			if (dist(mouseX, mouseY, combinacion.getBlock3x(), combinacion.getBlock3y()) < 50 && combi == 0) {
				var1 = "azul";
				pin3 = true;

			}

			if (dist(mouseX, mouseY, combinacion.getBlock4x(), combinacion.getBlock4y()) < 50 && combi == 0) {
				var1 = "purpura";
				pin4 = true;
			}

			if (dist(mouseX, mouseY, combinacion.getBlock1x(), combinacion.getBlock1y()) < 50 && combi == 1) {
				var2 = "rojo";
				pin1 = true;

			}
			if (dist(mouseX, mouseY, combinacion.getBlock2x(), combinacion.getBlock2y()) < 50 && combi == 1) {
				var2 = "verde";
				pin2 = true;

			}

			if (dist(mouseX, mouseY, combinacion.getBlock3x(), combinacion.getBlock3y()) < 50 && combi == 1) {
				var2 = "azul";
				pin3 = true;

			}

			if (dist(mouseX, mouseY, combinacion.getBlock4x(), combinacion.getBlock4y()) < 50 && combi == 1) {
				var2 = "purpura";
				pin4 = true;
				
			}
			if (dist(mouseX, mouseY, combinacion.getBlock1x(), combinacion.getBlock1y()) < 50 && combi == 2) {
				var3 = "rojo";
				pin1 = true;

			}
			if (dist(mouseX, mouseY, combinacion.getBlock2x(), combinacion.getBlock2y()) < 50 && combi == 2) {
				var3 = "verde";
				pin2 = true;

			}

			if (dist(mouseX, mouseY, combinacion.getBlock3x(), combinacion.getBlock3y()) < 50 && combi == 2) {
				var3 = "azul";
				pin3 = true;

			}

			if (dist(mouseX, mouseY, combinacion.getBlock4x(), combinacion.getBlock4y()) < 50 && combi == 2) {
				var3 = "purpura";
				pin4 = true;
			}
			
			if (dist(mouseX, mouseY, combinacion.getBlock1x(), combinacion.getBlock1y()) < 50 && combi == 3) {
				var4 = "rojo";
				pin1 = true;

			}
			
			if (dist(mouseX, mouseY, combinacion.getBlock2x(), combinacion.getBlock2y()) < 50 && combi == 3) {
				var4 = "verde";
				pin2 = true;

			}

			if (dist(mouseX, mouseY, combinacion.getBlock3x(), combinacion.getBlock3y()) < 50 && combi == 3) {
				var4 = "azul";
				pin3 = true;

			}

			if (dist(mouseX, mouseY, combinacion.getBlock4x(), combinacion.getBlock4y()) < 50 && combi == 3) {
				var4 = "purpura";
				pin4 = true;
			}
			
		}
	}
	
	@Override
	public void mouseClicked() {	
		if (dist(mouseX, mouseY, combinacion.getXColor(), combinacion.getYColor()) < 100 ) {
			combi++;
		}
	}

}

