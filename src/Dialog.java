import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* Cette classe permet d'ouvrir 3 boites de dialogues permettant la communication entre l'utilisateur et le programme */

public class Dialog extends JFrame{
	
	
	/* Cette première boite de dialogue demande à l'utilisateur si il veut entamer une partie solo ou multijoueur */
	
	boolean firstDialog() {
		int reponse = JOptionPane.showConfirmDialog(this,
				"Souhaitez-vous jouer en multijoueurs ?",
	  				"Multi ?", 
	  			JOptionPane.YES_NO_OPTION);
	  	if (reponse == JOptionPane.YES_OPTION) {
	  		return true;                        // on retourne true si l'utilisateur veut jouer tout seul
	  	}
	  	return false;
	}
	
	
	/*La seconde boite de dialogue demande à l'utilisateur s'il veut être l'hôte. Bien que les deux joueurs seront serveurs, l'hôte représente le premier joueur, celui à
	 * qui le deuxième joueur va se connecter */
	
	  boolean secondDialog() {
	  	int reponse = JOptionPane.showConfirmDialog(this,
	  			"Souhaitez-vous acceuillir le jeu",
	  			"Host", 
	  			JOptionPane.YES_NO_OPTION);
	  	if (reponse == JOptionPane.YES_OPTION) {
	  		return true;
	  	}
	  	return false;
	  }
	  
	  	
	  /* La dernière boite de dialogue permet d'entrer soit l'adresse IP de lôte auquel on veut se connecter, soit le nom de la machine de l'hôte */
	  
	  String thirdDialog() {
	 		return JOptionPane.showInputDialog(this, 
	 				"veuillez entrer le nom ou l'adresse IP de la machine avec laquelle vous voulez vous connecter");
	 	}
	  	 
}
