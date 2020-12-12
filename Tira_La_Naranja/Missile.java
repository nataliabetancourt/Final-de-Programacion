package Tira_La_Naranja;


public class Missile extends Sprite  {
	 private final int BOARD_WIDTH = 690;
	    private final int MISSILE_SPEED = 2;

	    public Missile(int x, int y) {
	        super(x, y);

	        initMissile();
	    }
	    
	    private void initMissile() {
	        
	    	loadImage("flecha.png");
	        getImageDimensions();
	        getImage();
	    }

	    public void move() {
	        
	        x += MISSILE_SPEED;
	        
	        if (x > BOARD_WIDTH)
	            vis = false;
	    }   
}
