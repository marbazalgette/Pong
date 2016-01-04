import java.net.InetAddress;
import java.net.UnknownHostException;




public class Main  {
	
	
	public static void main(String[] args) {
		Pong pong; 
		/*
		 * affiche l'ensemble des fenetres permettant de jouer en solo ou non et d'etre hote ou non
		 */
		Dialog dialog = new Dialog();
		if (!dialog.firstDialog()) {
			Pong.solo = true;
			Pong.host = false;
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
