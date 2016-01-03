import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int SCORE_J1 = 0;

	public static int SCORE_J2 = 0;
	
	/* Width of area */
	public static final int SIZE_PONG_X = 800;

	/*Height of area */
	public static final int SIZE_PONG_Y = 600;
	
	/*background color or the area*/
	private static final Color backgroundColor = new Color(0xFF, 0x40, 0);
	
	public final int timestep = 10;
	
	private Image buffer = null;
	
	private Graphics graphicContext = null;
	private Racket racketGauche;
	public static ArrayList <PongItem> list;
	private Ball ball;
	private Network network;
	private PlayerCommunication player2;
	
	
	public void playerInPong (PlayerCommunication p) {
		player2 = p;
	}
	
	public Pong() {
		
		racketGauche = new Racket ("img/racket.png",0,300,0);
		ball = new Ball ("img/ball.png",400,300);
		list = new ArrayList<PongItem>();
		list.add(ball);
		list.add(racketGauche);
		this.addKeyListener(this);
		//network = new Network();
	}
	
	public void paint(Graphics g) {
		g.drawImage(buffer, 0, 0, this);
	}

	
	public void updateScreen() {
		if (buffer == null) {
			buffer =  createImage(SIZE_PONG_X, SIZE_PONG_Y);
			if (buffer == null)
				throw new RuntimeException("no buffer");
			else
				graphicContext = buffer.getGraphics();
		}
			
			graphicContext.setColor(backgroundColor);
			graphicContext.fillRect(0, 0, SIZE_PONG_X, SIZE_PONG_Y);
			
			/* Draw Images */
			graphicContext.drawImage(ball.getSprite(), ball.getPosX(), ball.getPosY(), ball.getWidth(), ball.getHeight(), null);
			graphicContext.drawImage(racketGauche.getSprite(), racketGauche.getPosX(), racketGauche.getPosY(), racketGauche.getWidth(), racketGauche.getHeight(), null);
			Font font = new Font("Courier", Font.BOLD, 20);
		    graphicContext.setFont(font);
		    graphicContext.setColor(Color.white);          
		    graphicContext.drawString("J2: " + Pong.SCORE_J2, 500, 20);
		    graphicContext.drawString("J1: " + Pong.SCORE_J1, 50, 20);
			this.repaint();
		}
	
		public void keyPressed (KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_KP_UP:
					racketGauche.setSpeedY(- 4);
					break;
				case KeyEvent.VK_DOWN:
				case KeyEvent.VK_KP_DOWN:
					racketGauche.setSpeedY(4);
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
				ball.rebound(list);
				for (int i =0 ;i<list.size(); i++) {
					list.get(i).move(); 
					if(racketGauche.getPosY()<0)
						racketGauche.setPosY(0);
					if(racketGauche.getPosY()+racketGauche.getHeight()>SIZE_PONG_Y){
						racketGauche.setPosY(SIZE_PONG_Y-racketGauche.getHeight());
					}
				if(ball.getPosX() <= 0 ){
					SCORE_J2++;
					//System.out.println("Score J2 :" + SCORE_J2);
					ball.setPosY(300);
					ball.setPosX(400);
					ball.setSpeedX(-ball.getSpeedX());
				}
				updateScreen();
				}
	}
	
	

	
}