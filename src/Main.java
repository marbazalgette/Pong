//package pong;

//import pong.gui.Window;
//import Pong.java;

/**
 * Starting point of the Pong application
 */
public class Main  {
	
	public static void main(String[] args) {
		Pong pong = new Pong();
		Window window = new Window(pong);
		window.displayOnscreen();
	}
}
