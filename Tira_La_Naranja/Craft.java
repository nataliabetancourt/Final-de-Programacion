package Tira_La_Naranja;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Craft extends Sprite {
	private int dx;
    private int dy;
    private ArrayList<Missile> missiles;

    public Craft(int x, int y) {
        super(x, y);

        initCraft();
    }

    private void initCraft() {
        
        missiles = new ArrayList<>();
        loadImage("arquro fin.png");
        getImageDimensions();
        getImage();
    }

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) throws Exception {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
        if (key == KeyEvent.VK_ENTER) {
            String args[]={"hola"};
            CollisionEx.main(args);
        }
        if (key == KeyEvent.VK_Q) {
            System.exit(0);
        }
    }


    public void fire() throws Exception {
        String[] arg={"hola"};
        
        missiles.add(new Missile(x + width, y + height / 2));
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }   
}
