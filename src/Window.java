//package pong.gui;

import java.awt.*;

import javax.swing.JFrame;
/**
 * A Window is a Java frame containing an Pong
 */
public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Pong component to be displayed
	 */
	private final Pong pong;

	/**
	 * Constructor
	 */
	public Window(Pong pong) {
		this.pong = pong;
		this.addKeyListener(pong);
		
	}

	static public void displayScore(Graphics g){
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.white);          
	    g.drawString("J2: " + Pong.SCORE_J2, 500, 20);
	    g.drawString("J1: " + Pong.SCORE_J1, 50, 20);
	}
	
	/**
	 * Displays the Window using the defined margins, and call the
	 * {@link Pong#animate()} method of the {@link Pong} every 100ms
	 */
	
	public void displayOnscreen() {
		add(pong);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(Pong.SIZE_PONG_X,Pong.SIZE_PONG_Y);
		while(true) {
			//displayScore(getGraphics());
			pong.animate();
			try {
				Thread.sleep(pong.timestep);
			} catch (InterruptedException e) {};
		}
	}
}
