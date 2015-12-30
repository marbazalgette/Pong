import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialog extends JFrame{
	
  	boolean firstDialog() {
  		int reponse = JOptionPane.showConfirmDialog(this,
  				"Souhaitez-vous jouer en multijoueurs ?",
  				"Multi ?", 
  				JOptionPane.YES_NO_OPTION);
  		if (reponse == JOptionPane.YES_OPTION) {
  			return true;
  		}
  		return false;
  	}
  	
  	String secondDialog() {
  		return JOptionPane.showInputDialog(this, 
  				"veuillez entrer le nom de la machine avec laquelle vous voulez vous connecter");
  	}
  	 
}
