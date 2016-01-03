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

		Dialog dialog = new Dialog();
		if (!dialog.firstDialog()) {     // si on veut jouer en solo
			Pong pong = new Pong();
			Window window = new Window(pong);
			window.displayOnscreen();
		}
		else {
			InetAddress player2address = null;
			try {
				player2address.getByName(dialog.secondDialog());
			}
			catch (UnknownHostException e) {
				//
			}
			Pong pong = new Pong();
			pong.setPlayer2Address(player2address);
			pong.play();
		}
	}
}
