import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	int x, y;
	int cont1, cont11, cont2, cont22, cont3, cont33, cont4, cont44, contA, contB;
	boolean donw, up, izq, der, atack, shot;

	@Override
	public void settings() {
		size(1200, 700);

		x = 600;
		y = 450;
		donw = false;
		cont1 = 0;
		cont11 = 0;
		up = false;
		cont2 = 0;
		cont22 = 0;
		izq = false;
		cont3 = 0;
		cont33 = 0;
		der = false;
		cont4 = 0;
		cont44 = 0;

		atack = false;
		contA = 0;
		shot = false;
		contB = 0;

	}

	// Fotos de fondo // Fotos de obstaculos
	PImage cueva, dia1, dia2, tarde, noche;
	PImage arbolD, arbolT, arbolN, ladrillo;
	// Matriz //Obstaculos
	Mapa mapa2, mapa3, mapa4, mapa5, mapa6;
	Obstaculos obs2, obs3, obs4, obs5, obs6;
	// Personaje
	Personaje p;
	// Estado de las pantallas
	int pantallas;
	// Indicador de tiempo sobre circulo de salida para pantallas, al llegar a 100,
	// cambia de pantalla
	int tiempoSalida;
	Bala B;

	@Override
	public void setup() {
		// Pantalla 1 //Pantalla 2
		cueva = loadImage("cueva_texturizado.png");
		// Pantalla 3 //Pantalla 4
		dia1 = loadImage("Fondos-01.jpg");
		dia2 = loadImage("Fondos-02.jpg");
		// Pantalla 5 //Pantalla 6
		tarde = loadImage("Fondos-03.jpg");
		noche = loadImage("Fondos-04.jpg");
		// Arbol Dia //Arbol Tarde
		arbolD = loadImage("Arboles-05.png");
		arbolT = loadImage("Arboles-06.png");
		// Arbol Noche //Ladrillo
		arbolN = loadImage("Arboles-07.png");
		ladrillo = loadImage("cuadro_texturizado.png");

		mapa2 = new Mapa(cueva, 2);
		obs2 = new Obstaculos(2);
		mapa3 = new Mapa(dia1, 3);
		obs3 = new Obstaculos(3);
		mapa4 = new Mapa(dia2, 4);
		obs4 = new Obstaculos(4);
		mapa5 = new Mapa(tarde, 5);
		obs5 = new Obstaculos(5);
		mapa6 = new Mapa(noche, 6);
		obs6 = new Obstaculos(6);
		p = new Personaje(11, 1, mapa2, obs2, this, 5);

		B = new Bala(p.getX(), p.getY(), this);

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
			rect(width / 2, height / 2, 150, 50);
			break;
		case 2:
			mapa2.pintar(this, ladrillo);
			validarSalida(3, 11, 1);
			obs2.pintar(this, ladrillo, 121, 92);
			if (dist(p.getX(), p.getY(), mapa3.getxSalida2(), mapa3.getySalida2()) < 25) {
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
			mapa3.pintar(this, arbolD);
			obs3.pintar(this, arbolD, 80, 80);
			validarSalida(4, 1, 6);
			break;
		case 4:
			p.setRefMapa(mapa4);
			p.setObs(obs4);
			mapa4.pintar(this, arbolD);
			obs4.pintar(this, arbolD, 80, 80);
			validarSalida(5, 1, 6);
			break;
		case 5:
			p.setRefMapa(mapa5);
			p.setObs(obs5);
			mapa5.pintar(this, arbolT);
			obs5.pintar(this, arbolT, 80, 80);
			validarSalida(6, 1, 6);
			break;
		case 6:
			p.setRefMapa(mapa6);
			p.setObs(obs6);
			mapa6.pintar(this, arbolN);
			obs6.pintar(this, arbolN, 80, 80);
			break;

		}

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
			p.pintar(this);

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
		p.miraLife(this);

	}

	public void validarSalida(int pantalla, int col, int fil) {
		if (dist(p.getX(), p.getY(), mapa3.getxSalida(), mapa3.getySalida()) < 25) {
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
			break;
		case 'o':
			shot = true;
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
		if (mouseX > width / 2 - 75 && mouseX < width / 2 + 75 && mouseY > height / 2 - 25
				&& mouseY < height / 2 + 25) {
			pantallas = 2;
		}
	}

}
