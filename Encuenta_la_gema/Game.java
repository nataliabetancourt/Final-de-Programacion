package Encuenta_la_gema;
import Principal.Principal;
import processing.core.PApplet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game implements ActionListener {

boolean estado;

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

 

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1087, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setVisible(false);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Game.class.getResource("/recurso/ARBOL.png")));
		lblNewLabel.setBounds(468, 49, 648, 560);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_1.setVisible(false);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Game.class.getResource("/recurso/ARBOL.png")));
		lblNewLabel_1.setBounds(376, 10, 629, 599);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_2.setVisible(false);

			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(Game.class.getResource("/recurso/roca.png")));
		lblNewLabel_2.setBounds(706, 345, 222, 251);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_3.setVisible(false);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(Game.class.getResource("/recurso/roca.png")));
		lblNewLabel_3.setBounds(517, 365, 245, 182);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_4.setVisible(false);
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(Game.class.getResource("/recurso/arbol3.png")));
		lblNewLabel_4.setBounds(10, -57, 350, 319);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_5.setVisible(false);
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(Game.class.getResource("/recurso/roca.png")));
		lblNewLabel_5.setBounds(317, 250, 150, 99);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_6.setVisible(false);
			}
		});
		lblNewLabel_6.setIcon(new ImageIcon(Game.class.getResource("/recurso/roca.png")));
		lblNewLabel_6.setBounds(20, 237, 143, 99);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_7.setVisible(false);
			}
		});
		lblNewLabel_7.setIcon(new ImageIcon(Game.class.getResource("/recurso/arbol3.png")));
		lblNewLabel_7.setBounds(118, 31, 314, 326);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel_8.setVisible(false);
				String WIN = JOptionPane.showInputDialog(null, "Ganaste puedes continuar");
				if(WIN.equals("123")) {
					PApplet.main("Principal");
				}else {
					JOptionPane.showMessageDialog(null, "PIN Incorrecto");
				}
			}
		});
		lblNewLabel_8.setIcon(new ImageIcon(Game.class.getResource("/recurso/gema.png")));
		lblNewLabel_8.setBounds(-154, 126, 979, 127);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(Game.class.getResource("/recurso/fondo2.jpg")));
		lblNewLabel_9.setBounds(0, 0, 1063, 633);
		frame.getContentPane().add(lblNewLabel_9);
	}
	

	class fondoPanel extends JPanel{
	     private Image imagen;
	      @Override
	      public void paint(Graphics g) {
	       imagen= new ImageIcon(getClass().getResource("/recursos/892836338464818460f5c10e03c1acd7.jpg")).getImage();
	       
	      g.drawImage(imagen, 0, 0, getWidth(),getHeight(), this);
	      setOpaque(false);
	      super.paint(g);
	      }
	    }
		
	
	private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {                                     
	        // TODO add your handling code here:
	    }                                    

	    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {                                     
	        // TODO add your handling code here:
	    }                                    

	    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {                                     
	        // TODO add your handling code here:
	    }

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}                      
}
