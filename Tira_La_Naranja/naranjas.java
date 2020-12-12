package Tira_La_Naranja;

import javax.swing.ImageIcon;

public class naranjas extends Sprite{
	
	private final int INITIAL_X = 700;

    public naranjas(int x, int y) {
        super(x, y);

        initnaranjas();
    }

    private void initnaranjas() {

    	loadImage("Inventario-01.png");
    	getImageDimensions();
    	getImage();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1;
    }   
}
