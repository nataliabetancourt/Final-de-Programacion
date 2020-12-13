package Principal;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Inventario {
	
	private int x;
	private int y;
	private int col;
	private int fil;
	private PImage img;
	
	public Inventario(int col, int fil, PImage img) {
		this.x = 25 + (col*50);
		this.y = 25 + (fil*50);
		this.col = col;
		this.fil = fil;
		this.img = img;
		
	}
	
	public void pintar(PApplet app) {
		app.imageMode(PConstants.CENTER);
		app.image(img, x, y, 50, 50);
	}
	
	public void pintar2(PApplet app, int x, int y) {
		app.imageMode(PConstants.CENTER);
		app.image(img, x, y, 50, 50);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getFil() {
		return fil;
	}

}
