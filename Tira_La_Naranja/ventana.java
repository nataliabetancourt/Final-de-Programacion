package Tira_La_Naranja;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import processing.core.PApplet;

public class ventana extends JPanel implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
    private Craft craft;
    private ArrayList<naranjas> naranja;
    private boolean ingame;
    private final int ICRAFT_X = 100;
    private final int ICRAFT_Y = 100;
    private final int B_WIDTH = 700;
    private final int B_HEIGHT = 500;
    private final int DELAY = 15;

    private final int[][] pos = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };
    
    
    public ventana() {
    	initventana();
    }
    
    public void initventana() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.cyan);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        craft = new Craft(ICRAFT_X, ICRAFT_Y);

        initnaranjas();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initnaranjas() {
    	naranja = new ArrayList<>();

        for (int[] p : pos) {
        	naranja.add(new naranjas(p[0], p[1]));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {
            if (naranja.size()==0){
                drawWin(g);
            }
            else {drawGameOver(g);}
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        if (craft.isVisible()) {
            g.drawImage(craft.getImage(), craft.getX(), craft.getY(),
                    this);
        }

        ArrayList<Missile> ms = craft.getMissiles();

        for (Missile m : ms) {
            if (m.isVisible()) {
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }

        for (naranjas a : naranja) {
            if (a.isVisible()) {
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }

        g.setColor(Color.black);
        Font medium = new Font("Helvetica", Font.BOLD, 16);
        g.setFont(medium);
        g.drawString("naranjas restantes: " + naranja.size(), 5, 15);
    }

    private void drawGameOver(Graphics g) {

        String msg = "Perdiste :'(";
        String msg2 = "[Enter] Nuevo juego  [Q] Salir";
        Font small = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(msg2, (B_WIDTH - fm.stringWidth(msg2)) / 2, (B_HEIGHT / 2) +30);
    }
    private void drawWin(Graphics g) {
        String msg = "Ganaste";
        String msg2 = "[Enter] Nuevo juego  [Q] Salir";
        String WIN	= JOptionPane.showInputDialog(null, "Ganaste");
		if(WIN.equals("123")) {
			PApplet.main("Principal");
		}else {
			JOptionPane.showMessageDialog(null, "PIN Incorrecto");
		}
        Font small = new Font("Helvetica", Font.BOLD, 16);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(msg2, (B_WIDTH - fm.stringWidth(msg2)) / 2, (B_HEIGHT / 2) +30);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateCraft();
        updateMissiles();
        updateAliens();

        checkCollisions();

        repaint();
    }
    private void inGame() {
        
        if (!ingame) {
            timer.stop();
        }
    }

    private void updateCraft() {

        if (craft.isVisible()) {
            craft.move();
        }
    }

    private void updateMissiles() {

        ArrayList<Missile> ms = craft.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = ms.get(i);

            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateAliens() {

        if (naranja.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < naranja.size(); i++) {

            naranjas a = naranja.get(i);
            if (a.isVisible()) {
                a.move();
            } else {
            	naranja.remove(i);
            }
        }
    }

    public void checkCollisions() {

        Rectangle r3 = craft.getBounds();

}
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            try {
                craft.keyPressed(e);
            } catch (Exception ex) {
                Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    }
