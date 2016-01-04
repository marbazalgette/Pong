import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PlayerCommunication {

	private InputStream input;
	private OutputStream output;

	
	public PlayerCommunication(Network net) throws IOException {
			input = net.getInputStream();
			output = net.getOutputStream();
			System.out.println(output == null);
			System.out.println(input == null);
		
	}
	
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