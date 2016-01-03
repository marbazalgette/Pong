import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PlayerCommunication {

	private InputStream input;
	private OutputStream output;
	private Network network;
	private Racket racket;
	
	public PlayerCommunication(Socket s) {
		try {
			input = s.getInputStream();
			output = s.getOutputStream();
			racket = new Racket ("img/racket.png",0,300,0);
		}
		catch (IOException e) {
			//
		}
	}
	
	public void protocol() {
		this.newPosition(racket, output);
		this.updatePosition(readStream(input));	
	}
	
	public void newPosition(Racket r, OutputStream output) {
		try {
			StringBuffer strBuff = new StringBuffer();
			strBuff.append(r.getPosY());
			output.write(strBuff.toString().getBytes());
			output.flush();
		}
		catch (IOException e) {
			//
		}
	}
	
	public void updatePosition (int pos) {
		racket.setPosY(pos);
	}
	

	public int readStream(InputStream input) { //peur etre a refaire avec des strings
		int racketPos = 0;
		try {
			racketPos = (int)input.read();
			}
		catch (IOException e) {
			//
		}
		return racketPos;
	}
		
		
}