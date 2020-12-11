import processing.core.PApplet;
import processing.core.PImage;

public class Bala {
	protected int x, y;
	private PImage shot0;
	private PImage shot1;
	private PImage shot2;
	private PImage shot3;

	public Bala(int x, int y, PApplet app) {
		this.x = x;
		this.y = y;

		this.shot0 = app.loadImage("B1.png");
		this.shot1 = app.loadImage("B2.png");
		this.shot2 = app.loadImage("B3.png");
		this.shot3 = app.loadImage("B4.png");
	}

	public void shot(PApplet app, int dir) {

		switch (dir) {
		case 0:
			app.image(shot2, x, y, 132, 92);
			movertiro(dir);
			break;
		case 1:
			app.image(shot1, x, y, 132, 92);
			movertiro(dir);
			break;
		case 2:
			app.image(shot0, x, y, 132, 92);
			movertiro(dir);
			break;
		case 3:
			app.image(shot3, x, y, 132, 92);
			movertiro(dir);
			break;

		default:
			break;
		}

	}

	public void movertiro(int dir) {
		switch (dir) {
		case 0:
			y += 10;
			break;
		case 1:
			x += 10;
			break;
		case 2:
			y -= 10;
			break;
		case 3:
			x -= 10;
			break;
		default:
			break;
		}
	}

	public void nomover(int inxu, int exu) {
		y = inxu;
		x = exu;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}