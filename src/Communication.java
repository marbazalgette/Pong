import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Communication {

	private InputStream input;
	private OutputStream output;
	private Network network;
	private Communication communication;
	private Racket r;
	
	public Communication(Socket s) {
		try {
			input = s.getInputStream();
			output = s.getOutputStream();
		}
		catch (IOException e) {
			//
		}
	}
	
	public void protocol(Racket r) {
		communication.newPosition(r, output);
		communication.updatePosition(input);	
	}
	
	public void newPosition(Racket r, OutputStream output) {
		try {
			StringBuffer strBuff = new StringBuffer();
			strBuff.append(r.getPosX());
			strBuff.append('-');
			strBuff.append(r.getPosY());
			strBuff.append('/');
			output.write(strBuff.toString().getBytes());
			output.flush();
		}
		catch (IOException e) {
			//
		}
	}
	
	public void updatePosition (InputStream input) {
		
	}
}