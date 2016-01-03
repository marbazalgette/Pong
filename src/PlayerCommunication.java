import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PlayerCommunication {

	private InputStream input;
	private OutputStream output;
	private Network net;

	
	public PlayerCommunication(Network net) throws IOException {
			input = net.getInputStream();
			output = net.getOutputStream();
			System.out.println(output == null);
			System.out.println(input == null);
			//racket = new Racket ("img/racket.png",0,300,0);
		
	}
	
	public void sendRacketPosition(int pos) {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(pos);
		try {
			
			output.write(strBuff.toString().getBytes());
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int readRacketPosition() {
		int pos = 0;
		try {
			pos = (int)input.read();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return pos;
	}
	/*
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
*/		
		
}