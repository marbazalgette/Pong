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
		if (!dialog.firstDialog()) {     // si on veut jouer en solo
			pong = new Pong();
		
		}
		else {
			InetAddress player2address = null;
			try {
				player2address = player2address.getByName(dialog.secondDialog());
			}
			catch (UnknownHostException e) {
				//
			}
			pong = new Pong(player2address);
		}
		Window window = new Window(pong);
		window.displayOnscreen();
	}
}
