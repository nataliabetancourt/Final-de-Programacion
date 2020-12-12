package Tira_La_Naranja;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class CollisionEx extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CollisionEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new ventana());
        
        setResizable(false);
        pack();
        
        setTitle("Dispara a las naranjas");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CollisionEx ex = new CollisionEx();
                ex.setVisible(true);
            }
        });
    } 
}
