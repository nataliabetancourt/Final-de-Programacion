package laberinto;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import Principal.Principal;
import processing.core.PApplet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class maze extends JPanel {
	laberinto Laberinto= new laberinto();
	personaje per = new personaje();
	public static int nivel = 1;
	public maze() {
		addKeyListener(new KeyListener(){ 
			@Override
			public void keyPressed(KeyEvent e) {
				per.teclapresione(e);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
		});
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		Laberinto.paint(g);
		per.paint(g);
	}
	
	public static int cambiaNivel() {
		return nivel++;
	}
	
	public static int obtieneNivel() {
		return nivel;
	}
	
public static void main(String[]args) {
	JOptionPane.showMessageDialog(null, "sal del laberinto");
	JFrame ventana = new JFrame("maze");
	maze game = new maze();
	ventana.add(game);
	ventana.setSize(920, 540);
	ventana.setLocation(300,200);
	ventana.setVisible(true);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	while (true) {
		 try {
             Thread.sleep(10);
         } catch (InterruptedException ex) {
             Logger.getLogger(maze.class.getName()).log(Level.SEVERE, null, ex);
         }
	game.repaint();
	if(obtieneNivel()>3) {
		String WIN	= JOptionPane.showInputDialog(null, "Ganaste");
		if(WIN.equals("123")) {
			PApplet.main("Principal");
		}else {
			JOptionPane.showMessageDialog(null, "PIN Incorrecto");
		}
	}
	}
}
}
