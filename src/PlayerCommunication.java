import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PlayerCommunication {

	private InputStream input;
	private OutputStream output;

	/* Constructeur de PlayerCommunication qui récupère les InputStream et OutputStream à partir de l'objet Network */
	public PlayerCommunication(Network net) throws IOException {
			input = net.getInputStream();
			output = net.getOutputStream();
		
	}
	/* Méthode permettant d'envoyer la position de la raquette controlé par le joueur */
	public void sendRacketPosition(int pos) {
		OutputStreamWriter osw = new OutputStreamWriter(output);
		try {
			
			osw.write(pos);
			osw.flush();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Méthode permettant de récupérer la position de la raquette de l'adversaire */
	public int readRacketPosition() {
		InputStreamReader isr = new InputStreamReader(input);
		int pos = 0;
		try {
			pos = isr.read();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return pos;
	}
			
}