
import java.awt.*;

import javax.swing.JFrame;
/*
  L'objet Window hérite des Jframes et contient le pong qui va être affiché
 */
public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	/*
	  Pong qui va être affiché
	 */
	private final Pong pong;

	/*
	 *  Constructeur de l'objet Pong
	 */
	public Window(Pong pong) {
		this.pong = pong;
		this.addKeyListener(pong);
		
	}
/*
 * Methode permettant d'afficher les scores 
 */
	static public void displayScore(Graphics g){
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.white);
	    g.drawString("J2: " + Pong.SCORE_J2, 500, 20);
	    g.drawString("J1: " + Pong.SCORE_J1, 50, 20);
	}
	
	/*
	 * Methode permettant d'afficher dans la fenetre l'item Pong en rappelant tout les "timestep" la méthode animate de Pong
	 */
	
	public void displayOnscreen() {
		add(pong);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		int borderSizeY = getContentPane().getHeight(); 
		int borderSizeX = getContentPane().getWidth();  
		setSize(Pong.SIZE_PONG_X - borderSizeX, Pong.SIZE_PONG_Y - borderSizeY);
		while(true) {
			pong.animate();
			try {
				Thread.sleep(pong.timestep);
			} catch (InterruptedException e) {};
		}
	}
}
