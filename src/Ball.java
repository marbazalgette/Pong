import java.util.ArrayList;


public class Ball extends PongItem {
		
/* Constructeur de l'objet balle */
	
	public Ball (String Image,  int posX, int posY, boolean j1){
		super(Image, posX, posY);
		System.out.println(j1);
		if (j1) {
			this.setSpeedX(2);
			this.setSpeedY(2);
		}
		else {
			this.setSpeedX(-2);
			this.setSpeedY(-2);
		}
	}
	
	/* Fait rebondir la balle notament sur l'ensemble des PongItem du Pong */
	
	public void rebound (ArrayList<PongItem> t) {
		for (int i=1; i<t.size(); i++) {
			if (this.collision(t.get(i)) == true) {
				setSpeedX(- this.getSpeedX());
				setPosX(t.get(i).getPosX() + t.get(i).getWidth());
			}
		} 
		
		if (Pong.solo) { /* permet à la balle de rebondir sur le "mur" de droite si on joue en solo */
			if (this.getPosX() >= Pong.SIZE_PONG_X - this.getHeight()) {
				setSpeedX(- this.getSpeedX());
			}
		}
		/* Permet à la balle de rebondir sur les mur du haut et du bas */
		if (this.getPosY() <= 0 || this.getPosY() >= Pong.SIZE_PONG_Y - this.getHeight()) {
			setSpeedY(- this.getSpeedY());
		}
		
	}
}



