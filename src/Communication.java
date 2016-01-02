import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Communication {

	private InputStream input;
	private OutputStream output;
	private Network network;
	private Communication communication;
	private Racket racket;
	
	public Communication(Socket s) {
		try {
			input = s.getInputStream();
			output = s.getOutputStream();
		}
		catch (IOException e) {
			//
		}
	}
	
	public void protocol() {
		this.communication.newPosition(racket, output);
		this.communication.updatePosition(readStream(input));	
	}
	
	public void newPosition(Racket r, OutputStream output) {
		try {
			StringBuffer strBuff = new StringBuffer();
			strBuff.append(r.getPosX());
			strBuff.append((int)1);
			strBuff.append(r.getPosY());
			strBuff.append((int)2);
			output.write(strBuff.toString().getBytes());
			output.flush();
		}
		catch (IOException e) {
			//
		}
	}
	
	public void updatePosition (int[] intTab) {
		racket.setPosX(intTab[0]);
		racket.setPosX(intTab[1]);
	}
	

	public int[] readStream(InputStream input) { //peur etre a refaire avec des strings
		int [] intTab = new int[2];
		int tmp = 0;
		try {
			while (tmp != 2) {
				int cpt=0;
				tmp = (int)input.read();
				if (tmp != 1 && tmp != 2) {
				intTab[cpt] = tmp;
				cpt++;
				}
			}
		}
		catch (IOException e) {
			//
		}
		return intTab;
	}
		
		
}