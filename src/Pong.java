	import java.awt.*;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.io.IOException;
	import java.net.InetAddress;
	import java.util.ArrayList;
	
	import javax.swing.JPanel;
	
	public class Pong extends JPanel implements KeyListener{
		
		/**
		 * Declaration des variables
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
		/*interval de temps entre chaque rafraichissement de l'écran */
		public final int timestep = 10;
		
		private Image buffer = null;
		
		private Graphics graphicContext = null;
		private Racket racketGauche;
		private Racket racketDroite;
		public static ArrayList <PongItem> list;
		private Ball ball;
		private Network network;
		private PlayerCommunication player2;
		public static boolean host = true;
		public static boolean solo;
		
		
		/*constructeur utilisé lors du jeu solo ou par l'host de la partie */
		public Pong() {
			
			racketGauche = new Racket ("img/racket.png",0,SIZE_PONG_Y/2,0);
			ball = new Ball ("img/ball.png",400,300, host);
			list = new ArrayList<PongItem>();
			list.add(ball);
			list.add(racketGauche);
			this.addKeyListener(this);
			if (!solo) {
				host = true;
				racketDroite = new Racket("img/racket.png",SIZE_PONG_X - racketGauche.getWidth() , SIZE_PONG_Y/2, 0);
				list.add(racketDroite);
				network = new Network();
			}
		}
		/*constructeur utilisé par la personne qui se connecte */
		public Pong(InetAddress address) {
			
			host = false;
			racketGauche = new Racket ("img/racket.png",0,SIZE_PONG_Y/2,0);
			racketDroite = new Racket ("img/racket.png",SIZE_PONG_X - racketGauche.getWidth() ,SIZE_PONG_Y/2,0);
			ball = new Ball ("img/ball.png",400,300, host);
			list = new ArrayList<PongItem>();
			list.add(ball);
			list.add(racketGauche);
			list.add(racketDroite);
			network = new Network();
			network.connection(address);
			try {
				player2 = new PlayerCommunication(network);
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.addKeyListener(this);
	
		}

		
		public void paint(Graphics g) {
			g.drawImage(buffer, 0, 0, this);
		}
	
		/*met à jour l'intégralité des éléments graphique */
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
				if(!host && !solo)
					graphicContext.drawImage(racketDroite.getSprite(), racketDroite.getPosX(), racketDroite.getPosY(), racketDroite.getWidth(), racketDroite.getHeight(), null);
				Font font = new Font("Courier", Font.BOLD, 20);
			    graphicContext.setFont(font);
			    graphicContext.setColor(Color.white);          
			    graphicContext.drawString("J2: " + Pong.SCORE_J2, 500, 20);
			    graphicContext.drawString("J1: " + Pong.SCORE_J1, 50, 20);
				this.repaint();
			}
		/* augmente la vitesse de la rackette lorsque l'on appuie sur une flèche */
			public void keyPressed (KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP:
					case KeyEvent.VK_KP_UP:
						racketGauche.setSpeedY(-4);
						break;
					case KeyEvent.VK_DOWN:
					case KeyEvent.VK_KP_DOWN:
						racketGauche.setSpeedY(4);
						break;
					default:
						System.out.println("got press "+e);
				}
			}
			/* remet à 0 la vitesse de la rackette lorsque la flèche est relachée */
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
	
		/* boucle principale qui met à jour l'ensemble des éléments du Pong */
			public void animate() {
				if(!host){
					if (!solo) {
					try {
						player2 = new PlayerCommunication(network); /*met à jour les InputStream et OutputStream */
					} catch (IOException e) {
						e.printStackTrace();
					}
					player2.sendRacketPosition(racketGauche.getPosY()); /*Envoie la nouvelle position de la Rackette */
						racketDroite.setPosY(player2.readRacketPosition()); /* Met à jour la position de la Rackette de l'adversaire */
					}
						ball.rebound(list); 
						for (int i =0 ;i<list.size(); i++) {
							list.get(i).move(); 
							if(racketGauche.getPosY()<0)
								racketGauche.setPosY(0);
							if(racketGauche.getPosY()+racketGauche.getHeight()>SIZE_PONG_Y){
								racketGauche.setPosY(SIZE_PONG_Y-racketGauche.getHeight());
								
							}
							if(!host && !solo){
								if(racketDroite.getPosY()<0)
									racketDroite.setPosY(0);
								if(racketDroite.getPosY()+racketDroite.getHeight()>SIZE_PONG_Y){
									racketDroite.setPosY(SIZE_PONG_Y-racketDroite.getHeight());
								}
							}
							
							/* Permet de voir si un but a été marqué et remet la balle en jeu */
						if(ball.getPosX() <= 0){ 
							SCORE_J2++;
							ball.setPosY(300);
							ball.setPosX(400);
							ball.setSpeedX(-ball.getSpeedX());
						}
						if(ball.getPosX() >= SIZE_PONG_X && !solo){
							SCORE_J1++;
							ball.setPosY(300);
							ball.setPosX(400);
							ball.setSpeedX(-ball.getSpeedX());
						}
						}updateScreen(); 
						}
			}
		
		
	
		
	}