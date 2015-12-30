import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialog extends JFrame{
	
	private boolean multi = false;
	private String computer_name;
  	
  	void firstDialog() {
  		int reponse = JOptionPane.showConfirmDialog(this,
  				"Souhaitez-vous jouer en multijoueurs ?",
  				"Multi ?", 
  				JOptionPane.YES_NO_OPTION);
  		if (reponse == JOptionPane.YES_OPTION) {
  			multi = true;
  		}
  	}
  	
  	void secondDialog() {
  		computer_name = JOptionPane.showInputDialog(this, 
  				"veuillez entrer le nom de la machine avec laquelle vous voulez vous connecter");
  	}
  	 
}
