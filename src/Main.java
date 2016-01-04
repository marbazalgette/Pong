import java.net.InetAddress;
import java.net.UnknownHostException;

//package pong;

//import pong.gui.Window;
//import Pong.java;

/**
 * Starting point of the Pong application
 */
public class Main  {
	
	
	public static void main(String[] args) {
		Pong pong;
		Dialog dialog = new Dialog();
		if (!dialog.firstDialog()) {
			Pong.solo = true;
			pong = new Pong();
		}
		else if (dialog.secondDialog()) {     // si on veut jouer en solo
			pong = new Pong();
			System.out.println("Je joue en solo");
		
		}
		else {
			InetAddress player2address = null;
			try {
				player2address = player2address.getByName(dialog.thirdDialog());
			}
			catch (UnknownHostException e) {
				e.printStackTrace();
			}
			pong = new Pong(player2address);
			System.out.println("Je joue en multi");
		}
		Window window = new Window(pong);
		window.displayOnscreen();
	}
}
