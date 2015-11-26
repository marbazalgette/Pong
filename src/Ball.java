
public class Ball extends PongItem {
		
	public Ball (String Image,  int posX, int posY){
		super(Image, posX, posY);
	}
	
	public void rebound (PongItem t[]) {
		for (int i=0; i<t.length; i++) {
			if (this.collision(t[i]) == true) {
				setSpeedX(- this.getSpeedX());
			}
		}
		if (this.getPosY() == 0 || this.getPosY() == 600) {
			setSpeedY(- this.getSpeedY());
		}
	}
}

