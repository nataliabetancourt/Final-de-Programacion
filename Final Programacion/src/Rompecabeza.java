import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Rompecabeza {
	
	private int x1, x2, x3, x4, x5, x6, x7, x8;
	private int xgR, xgA, xgAm, xgV;
	private int y, ygR, ygA, ygAm, ygV;
	private int minDist;
	private boolean pintado1, pintado2, pintado3, pintado4, pintado5, pintado6, pintado7, pintado8;
	private boolean clickR, clickA, clickAm, clickV;
	private int xColor, yColor, combination;
	private int block1x, block1y;
	private int block2x, block2y;
	private int block3x, block3y;
	private int block4x, block4y;
	private int r;

	PImage naranja, fondoBuscar, gemaR, gemaA, gemaAm, gemaV;
	
	public Rompecabeza(PApplet app) {
		//Naranjas Disparo			//Ubicacion gemas
		x1 = 0;							xgR = 881;
		x2 = 90;						xgA = 420;
		x3 = 180;						xgAm = 578;
		x4 = 270;						xgV = 493;
		x5 = 360;						ygR = 250;
		x6 = 450;						ygA = 459;
		x7 = 540;						ygAm = 390;
		x8 = 630;						ygV =220;

		//Naranjas en Y
		y = 250;

		//Visibilidad Naranjas		/Validacion click gemas
		pintado1 = true;				clickR = true;
		pintado2 = true;				clickA = true;
		pintado3 = true;				clickAm = true;
		pintado4 = true;				clickV = true;
		pintado5 = true;
		pintado6 = true;
		pintado7 = true;
		pintado8 = true;
		
		//Imagenes
		naranja = app.loadImage("Inventario-01.png");
		fondoBuscar = app.loadImage("Bosque.jpg");
		gemaR = app.loadImage("Inventario-02.png");
		gemaA = app.loadImage("Inventario-04.png");
		gemaAm = app.loadImage("Inventario-11.png");
		gemaV = app.loadImage("Inventario-10.png");
		minDist = 20;
	}
	
	public Rompecabeza(int x, int y) {
		//Variables combinacion
		this.xColor = x;
		this.yColor = y;
		this.block1x = x + 55;
		this.block2x = x - 55;
		this.block3x = x + 55;
		this.block4x = x - 55;

		this.block1y = y + 55;
		this.block2y = y - 55;
		this.block3y = y - 55;
		this.block4y = y + 55;
		
		this.r = 0;
	}
	
	public void pintarBuscarGema(PApplet app) {
		app.rectMode(PConstants.CENTER);
		app.stroke(255, 204, 44);
		app.strokeWeight(3);
		app.fill(0, 90);
		app.rect(600, 350, 1200, 500);
		app.imageMode(PConstants.CENTER);
		app.image(fondoBuscar, 600, 350, 600, 300);
		app.image(gemaR, xgR, ygR, 20, 20);
		app.image(gemaA, xgA, ygA, 20, 20);
		app.image(gemaAm, xgAm, ygAm, 20, 20);
		app.image(gemaV, xgV, ygV, 20, 20);
		if (clickR == false) {
			app.noFill();
			app.circle(xgR, ygR, 20);
		}
		if (clickA == false) {
			app.circle(xgA, ygA, 20);
		}
		if (clickAm == false) {
			app.circle(xgAm, ygAm, 20);
		}
		if (clickV == false) {
			app.circle(xgV, ygV, 20);
		}
	}
	
	public void pintardispararGemas(PApplet app) {
		app.rectMode(PConstants.CENTER);
		app.stroke(255, 204, 44);
		app.strokeWeight(3);
		app.fill(0, 90);
		app.rect(600, 350, 1200, 500);
		if (pintado1) {
			app.imageMode(PConstants.CENTER);
			app.image(naranja, x1, y, 80, 80);
			app.imageMode(PConstants.CENTER);
			x1+=5;
		}
		if (pintado2) {
			app.imageMode(PConstants.CENTER);
			app.image(naranja, x2, y, 80, 80);
			app.imageMode(PConstants.CENTER);
			x2+=5;
		}
		if (pintado3) {
			app.imageMode(PConstants.CENTER);
			app.image(naranja, x3, y, 80, 80);
			app.imageMode(PConstants.CENTER);
			x3+=5;
		}
		if (pintado4) {
			app.imageMode(PConstants.CENTER);
			app.image(naranja, x4, y, 80, 80);
			app.imageMode(PConstants.CENTER);
			x4+=5;
		}
		if (pintado5) {
			app.imageMode(PConstants.CENTER);
			app.image(naranja, x5, y, 80, 80);
			app.imageMode(PConstants.CENTER);
			x5+=5;
		}
		if (pintado6) {
			app.imageMode(PConstants.CENTER);
			app.image(naranja, x6, y, 80, 80);
			app.imageMode(PConstants.CENTER);
			x6+=5;
		}
		if (pintado7) {
			app.imageMode(PConstants.CENTER);
			app.image(naranja, x7, y, 80, 80);
			app.imageMode(PConstants.CENTER);
			x7+=5;
		}
		if (pintado8) {
			app.imageMode(PConstants.CENTER);
			app.image(naranja, x8, y, 80, 80);
			app.imageMode(PConstants.CENTER);
			x8+=5;
		}

		if (x1 == 1200) {
			x1 = 0;
			y = 250;
		}
		if (x2 == 1200) {
			x2 = 0;
			y = 250;
		}
		if (x3 == 1200) {
			x3 = 0;
			y = 250;
		}
		if (x4 == 1200) {
			x4 = 0;
			y = 250;
		}
		if (x5 == 1200) {
			x5 = 0;
			y = 250;
		}
		if (x6 == 1200) {
			x6 = 0;
			y = 250;
		}
		if (x7 == 1200) {
			x7 = 0;
			y = 250;
		}
		if (x8 == 1200) {
			x8 = 0;
			y = 250;
		}
		
	}
	
	public void pintarCombinacion(PApplet app) {
		app.rectMode(PConstants.CENTER);
		app.stroke(255, 204, 44);
		app.strokeWeight(3);
		app.fill(r, 0, 0, 90);
		app.rect(600, 350, 1200, 500);
		app.fill(255, 0, 0);
		app.rect(block1x, block1y, 100, 100);
		app.fill(0, 255, 0);
		app.rect(block2x, block2y, 100, 100);
		app.fill(0, 0, 255);
		app.rect(block3x, block3y, 100, 100);
		app.fill(255, 0, 255);
		app.rect(block4x, block4y, 100, 100);
	}
	
	public void pintarRojoC (PApplet app, Boolean miro) {
		if (miro == true) {
			app.rectMode(PConstants.CENTER);
			app.fill(100, 0, 0);
			app.rect(block1x, block1y, 80, 80);
		}
	}
	
	public void pintarVerdeC (PApplet app, Boolean miro) {
		if (miro == true) {
			app.rectMode(PConstants.CENTER);
			app.fill(0, 100, 0);
			app.rect(block2x, block2y, 80, 80);
		}
	}
	
	public void pintarAzulC (PApplet app, Boolean miro) {
		if (miro == true) {
			app.rectMode(PConstants.CENTER);
			app.fill(0, 0, 100);
			app.rect(block3x, block3y, 80, 80);
		}
	}
	
	public void pintarPurpuraC(PApplet app, Boolean miro) {
		if (miro == true) {
			app.rectMode(PConstants.CENTER);
			app.fill(100, 0, 100);
			app.rect(block4x, block4y, 80, 80);
		}
	}
	
	public void combine(int num1, int num2, int num3, int num4) {
		combination = num1 + num2 + num3 + num4;
	}
	
	public void setR(int r) {
		this.r = r;
	}

	public int getXColor() {
		return xColor;
	}

	public int getYColor() {
		return yColor;
	}

	public int getBlock1x() {
		return block1x;
	}

	public int getBlock2x() {
		return block2x;
	}

	public int getBlock3x() {
		return block3x;
	}

	public int getBlock4x() {
		return block4x;
	}

	public int getBlock1y() {
		return block1y;
	}

	public int getBlock2y() {
		return block2y;
	}

	public int getBlock3y() {
		return block3y;
	}

	public int getBlock4y() {
		return block4y;
	}

	public void setXColor(int x) {
		this.xColor = x;
	}

	public void setYColor(int y) {
		this.yColor = y;
	}

	public int getX1() {
		return x1;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getX3() {
		return x3;
	}
	
	public int getX4() {
		return x4;
	}
	
	public int getX5() {
		return x5;
	}
	
	public int getX6() {
		return x6;
	}
	
	public int getX7() {
		return x7;
	}
	
	public int getX8() {
		return x8;
	}
	
	public int getY() {
		return y;
	}
	
	public int getMinDist() {
		return minDist;
	}
	
	public boolean getPintado1() {
		return pintado1;
	}
	
	public boolean getPintado2() {
		return pintado2;
	}
	
	public boolean getPintado3() {
		return pintado3;
	}
	
	public boolean getPintado4() {
		return pintado4;
	}
	
	public boolean getPintado5() {
		return pintado5;
	}

	public boolean getPintado6() {
		return pintado5;
	}
	public boolean getPintado7() {
		return pintado5;
	}
	public boolean getPintado8() {
		return pintado5;
	}

	public void setPintado1(boolean pintado1) {
		this.pintado1 = pintado1;
	}
	
	public void setPintado2(boolean pintado2) {
		this.pintado2 = pintado2;
	}
	
	public void setPintado3(boolean pintado3) {
		this.pintado3 = pintado3;
	}
	
	public void setPintado4(boolean pintado4) {
		this.pintado4 = pintado4;
	}
	
	public void setPintado5(boolean pintado5) {
		this.pintado5 = pintado5;
	}
	
	public void setPintado6(boolean pintado6) {
		this.pintado6 = pintado6;
	}
	
	public void setPintado7(boolean pintado7) {
		this.pintado7 = pintado7;
	}
	
	public void setPintado8(boolean pintado8) {
		this.pintado8 = pintado8;
	}
	
	public int getXgA() {
		return xgA;
	}
	
	public int getXgAm() {
		return xgAm;
	}
	
	public int getXgR() {
		return xgR;
	}
	
	public int getXgV() {
		return xgV;
	}
	
	public int getYgA() {
		return ygA;
	}
	
	public int getYgAm() {
		return ygAm;
	}
	
	public int getYgR() {
		return ygR;
	}
	
	public int getYgV() {
		return ygV;
	}
	
	public boolean getClickR() {
		return clickR;
	}
	
	public boolean getClickA() {
		return clickA;
	}
	
	public boolean getClickAm() {
		return clickAm;
	}
	
	public boolean getClickV() {
		return clickV;
	}
	
	public void setClickA(boolean clickA) {
		this.clickA = clickA;
	}
	
	public void setClickAm(boolean clickAm) {
		this.clickAm = clickAm;
	}
	
	public void setClickR(boolean clickR) {
		this.clickR = clickR;
	}
	
	public void setClickV(boolean clickV) {
		this.clickV = clickV;
	}
}


