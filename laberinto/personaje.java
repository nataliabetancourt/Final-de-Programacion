package laberinto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class personaje {
laberinto lab = new laberinto();
int x=40;
int y=40;
int ancho=40;
int alto=40;
int movimiento=40;

public void paint(Graphics g) {
g.setColor(Color.orange);	
g.fillOval(x, y, ancho, alto);
g.setColor(Color.black);	
g.drawOval(x, y, ancho, alto);

// ojos
g.setColor(Color.white);
g.fillOval(x+7,y+8,13,13);
g.fillOval(x+21,y+8,13,13);
g.setColor(Color.black);
g.fillOval(x+11,y+12,5,5);
g.fillOval(x+25,y+12,5,5);
}
public void teclapresione(KeyEvent evt) {
	int [][]laberinto=lab.obtenerLaberinto();
	if(evt.getKeyCode()==37) {
		if(laberinto[y/40][(x/40)-1]!=1)
	          x=x-movimiento;
	}
	if(evt.getKeyCode()==39) {
		if(laberinto[y/40][(x/40)+1]!=1)
	          x=x+movimiento;
	}
	if(evt.getKeyCode()==40) {
		if(laberinto[(y/40)+1][x/40]!=1)
	          y=y+movimiento;
	}
	if(evt.getKeyCode()==38) {
		if(laberinto[(y/40)-1][x/40]!=1)
	          y=y-movimiento;
	}
if(x==840 && y==440) {
	maze.cambiaNivel();
	x= 40;
	y=40;
	
}

}


}

