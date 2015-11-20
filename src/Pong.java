import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class Pong {
	
	/* Width of area */
	private static final int SIZE_PONG_X = 800;
	
	/*Height of area */
	private static final int SIZE_PONG_Y = 600;
	
	/*background color or the area*/
	private static final Color backgroundColor = new Color(0xFF, 0x40, 0);
	
	private Image buffer = null;
	
	private Graphics graphicContext = null;
	
	public void updateScreen() {
		if (buffer == null) {
			buffer =  new BufferedImage(SIZE_PONG_X, SIZE_PONG_Y, BufferedImage.TYPE_INT_ARGB);
			if (buffer == null)
				throw new RuntimeException("no buffer");
			else
				graphicContext = buffer.getGraphics();
			
			graphicContext.setColor(backgroundColor);
			graphicContext.fillRect(0, 0, SIZE_PONG_X, SIZE_PONG_Y);
			
			/* Draw Images */
			graphicContext.drawImage(Ball.getSprite(), Ball.getPosX(), Ball.getPosY(), Ball.getWidth(), Ball.getHeight(), null);
			graphicContext.drawImage(Racket.getSprite(), Racket.getPosX(), Racket.getPosY(), Racket.getWidth(), Racket.getHeight(), null);
		}
	}
	
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
			case KeyEvent.VK_KP_UP:
				Racket.setSpeedY(- Racket.getSpeedY());
				break;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_KP_DOWN:
				Racket.setSpeedY(Racket.getSpeedY());
				break;
			default:
				System.out.println("got press "+e);
		}
	}
	
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_KP_UP:
			Racket.setSpeedY(0);
			break;
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_KP_DOWN:
			Racket.setSpeedY(0);
			break;
		default:
			System.out.println("got press "+e);
	}
	}
	
}
