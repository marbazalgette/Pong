
public class Ball extends PongItem {
		

	public Ball (String Image,  int posX, int posY){
		super(Image, posX, posY);
		this.setSpeedX(2);
		this.setSpeedY(2);
		
	}
	
	public void rebound (PongItem t[]) {
		for (int i=0; i<t.length; i++) {
			if (this.collision(t[i]) == true) {
				setSpeedX(- this.getSpeedX());
			}
		} 
		if (this.getPosX() <= 0 || this.getPosX() >= Pong.SIZE_PONG_X - this.getWidth()) {
			setSpeedX(- this.getSpeedX());
		}
		
		if (this.getPosY() <= 0 || this.getPosY() >= Pong.SIZE_PONG_Y - this.getHeight()) {
			setSpeedY(- this.getSpeedY());
		}
		
	}
}

