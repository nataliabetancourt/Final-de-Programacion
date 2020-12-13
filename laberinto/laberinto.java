package laberinto;

import java.awt.Color;
import java.awt.Graphics;

public class laberinto {
int[][]lab=new int [13][23];
int fila =0;
int columna =0;
int numerofialas=13;
int numeroColumnas=23;
int anchoBloque=40;
int altoBloque=40;

public void paint(Graphics g) {
	int laberinto[][]=obtenerLaberinto();
	for(fila=0;fila<numerofialas;fila++) {
		for(columna=0; columna<numeroColumnas;columna++) {
			if(laberinto [fila][columna]==1) {
			if(maze.obtieneNivel()==1) {g.setColor(Color.cyan);}
			if(maze.obtieneNivel()==2) {g.setColor(Color.green);}
			if(maze.obtieneNivel()==3) {}g.setColor(Color.magenta);
			g.fillRect(columna*40, fila*40, anchoBloque, altoBloque);
			g.setColor(Color.black);
		    g.drawRect(columna*40, fila*40, anchoBloque, altoBloque);
		}}
		
	}
	g.drawString("inicio", 5, 62);
	g.drawString("fin", 850, 462);
}

public int [][] obtenerLaberinto(){
	if(maze.obtieneNivel()==1) {
	int laberinto[][]=
		   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{0,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1},
        {1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1},
	    {1,1,0,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,0,1,1},
        {1,0,0,1,0,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1},
        {1,0,0,1,0,0,1,1,1,0,1,1,1,0,1,0,1,1,1,1,0,1,1},
        {1,1,0,1,1,0,0,0,1,0,1,0,1,0,1,0,0,1,1,0,0,1,1},
        {1,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,1,1,0,1,0,1,1},
        {1,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,1,1},
        {1,1,0,1,0,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1},
        {1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1,1,0,1,1},
        {1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,0,0,0,1},
        {1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};

		lab= laberinto;
	}
	if(maze.obtieneNivel()==2) {
		int laberinto[][]=
			   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,1,1,0,1,0,1,1},
	        {1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1},
		    {1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,1,0,1,1},
	        {1,0,0,1,0,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1,0,1,1},
	        {1,0,0,1,0,0,1,1,1,0,1,1,1,0,1,0,1,1,1,1,0,1,1},
	        {1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1,0,0,1,1},
	        {1,1,0,1,0,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1},
	        {1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
	        {1,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,0,1,1,0,0,0,1},
	        {1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1},
	        {1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1},
	        {1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,0,0,0,1},
	        {1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,1},
	        {1,0,0,1,0,0,1,0,0,0,0,1,1,0,1,0,0,0,1,1,1,0,1},
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		lab= laberinto;
	}
	if(maze.obtieneNivel()==3) {
		int laberinto[][]=
			   {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,1,0,1,0,1,1},
	        {1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1},
		    {1,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,1,1,0,1,1},
	        {1,0,0,1,0,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1},
	        {1,0,1,1,0,0,1,1,0,0,1,1,1,0,1,0,1,1,1,1,0,1,1},
	        {1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,0,1,1,0,0,1,1},
	        {1,1,0,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
	        {1,1,0,1,0,0,1,0,1,0,1,1,1,1,1,0,1,0,0,1,0,1,1},
	        {1,1,0,1,0,1,1,0,1,1,1,0,1,0,1,0,1,0,1,0,0,1,1},
	        {1,1,0,1,0,0,1,0,1,0,1,1,1,0,1,0,1,1,0,1,0,1,1},
	        {1,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1},
	        {1,0,0,0,0,1,1,0,1,1,0,0,1,0,1,0,1,0,0,1,0,1,1},
	        {1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,1,0,1,0,1,1},
	        {1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1},
	        {1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,1,1,0,1,0,1,1},
	        {1,1,0,1,0,0,1,1,1,0,0,0,1,0,1,0,0,0,1,0,0,1,1},
	        {1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,1,0,0,0,1},
	        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		lab= laberinto;
	}
	return lab;
}

}