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
			InetAddress player2Address = null;             
			try {
				player2Address = InetAddress.getByName(dialog.secondDialog()); // on récupère l'ip du player 2
			}
			catch (UnknownHostException e) {
				System.out.println("unknown host");   
			}            
			Network network = new Network();  // nouveau network (serveur)
			if (network.canBeConnected()) {
				while (!network.connexion(player2Address)) {   // nouveau client
					System.out.println("en attente d'un ami");
				}
			}
			else {
				System.out.println("problème de connexion...");
			}
			PlayerCommunication player2 = new PlayerCommunication(network.getPlayer2());
			Pong pong = new Pong();
			pong.playerInPong(player2);
			Window window = new Window(pong);  
		}
	}
}
