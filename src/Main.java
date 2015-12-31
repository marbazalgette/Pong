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
			String computerName;               
			computerName = dialog.secondDialog();  // on récupère le nom de la machine de l'autre joueur
			Network network = new Network();     // on créé un serveur socket
			network.connection(computerName); // et un client
			Racket racketDroite = new Racket("img/racket.png",600,300,0);
			pong.list.add(racketDroite);
		}
	}
}
