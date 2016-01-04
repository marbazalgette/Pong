import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* Cette classe permet de gérer les serveurs Sockets, et également de créer des clients qui se connecteront aux serveurs */


public class Network {
	
	private ServerSocket server;
	private int port = 42420;
	private Socket client;
	OutputStream os;
	InputStream is;
	
	
	/* Constructeur de l'objet NetWork 
	 * On instancie la donnée membre server, qui recevra les informations du client de l'autre joueur */
	
	public Network() {
		try {
			server = new ServerSocket(port);
			if (Pong.host) {
				client = server.accept(); /* Si l'on choisit d'être host le ServerSocket se met en écoute */
				Pong.host = false;        /* le server n'est plus en écoute */
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/*Permet au joueur non host de se connecter au ServerSocket en écoute */
	
	public void connection(InetAddress address){
		try{
			client = new Socket(address, port);    // on se connecte au serveur avec l'addresse IP address, sur le port port
			os = client.getOutputStream();
			is = client.getInputStream();
			Pong.host = false;		               // pour que joueur non host ne se mette pas sur écoute, pour ne pas bloquer la connection
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public InputStream getInputStream () throws IOException{
		return client.getInputStream();
	}
	
	public OutputStream getOutputStream() throws IOException{
		return client.getOutputStream();
	}
	

		
}
