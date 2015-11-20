import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener{
	
	/* Width of area */
	private static final int SIZE_PONG_X = 800;
	
	/*Height of area */
	private static final int SIZE_PONG_Y = 600;
	
	/*background color or the area*/
	private static final Color backgroundColor = new Color(0xFF, 0x40, 0);
	
	public final int timestep = 10;
	
	private Image buffer = null;
	
	private Graphics graphicContext = null;
	private Racket racketGauche = new Racket("racket.png", 0, 0, 0);
	private PongItem t[] = {racketGauche};
	
	private Ball ball = new Ball("ball.png", 0, 0);
	
	
	public Pong() {
		racketGauche = new Racket ("img/ball.png",0,300,4);
		ball = new Ball ("img/ball.png",400,300);
		this.addKeyListener(this);
	}
	

	
	public void updateScreen() {
		if (buffer == null) {
			buffer =  createImage(SIZE_PONG_X, SIZE_PONG_Y);
			if (buffer == null)
				throw new RuntimeException("no buffer");
			else
				graphicContext = buffer.getGraphics();
			
			graphicContext.setColor(backgroundColor);
			graphicContext.fillRect(0, 0, SIZE_PONG_X, SIZE_PONG_Y);
			
			/* Draw Images */
			graphicContext.drawImage(ball.getSprite(), ball.getPosX(), ball.getPosY(), ball.getWidth(), ball.getHeight(), null);
			graphicContext.drawImage(racketGauche.getSprite(), racketGauche.getPosX(), racketGauche.getPosY(), racketGauche.getWidth(), racketGauche.getHeight(), null);
		}
	}
	
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
				racketGauche.setSpeedY(- racketGauche.getSpeedY());
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
				racketGauche.setSpeedY(racketGauche.getSpeedY());
				break;
			default:
				System.out.println("got press "+e);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
				racketGauche.setSpeedY(0);
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
				racketGauche.setSpeedY(0);
				break;
			default:
				System.out.println("got release "+e);
		}
	}
	public void keyTyped(KeyEvent e) { }
	
	public void animate() {
			if (ball != null) {
				ball.rebound(t);
				t[0].setPosY(t[0].getPosY() + t[0].getSpeedY()); 
				updateScreen();
			}
		}
	

	
}
