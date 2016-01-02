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
			Pong pong = new Pong();
			Window window = new Window(pong);
			InetAddress player2Address = null;               
			Network network = new Network();    
			try {
				player2Address.getByName(dialog.secondDialog());	
				network.connexion(player2Address); 
			}
			catch (UnknownHostException e) {
				//
			}
			Racket racketDroite = new Racket("img/racket.png",600,300,0);
			pong.list.add(racketDroite);
			
		}
	}
}
