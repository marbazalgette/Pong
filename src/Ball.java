
public class Ball extends PongItem {
		
	public Ball (String Image,  int posX, int posY){
		super(Image, posX, posY);
		this.setSpeedX(4);
		this.setSpeedY(4);
		
	}
	
	public void rebound (PongItem t[]) {
		for (int i=0; i<t.length; i++) {
			if (this.collision(t[i]) == true) {
				setSpeedX(- this.getSpeedX());
			}
		} 
		if (this.getPosX() <= 0 || this.getPosX() >= 800 - this.getWidth()) {
			setSpeedX(- this.getSpeedX());
		}
		
		if (this.getPosY() <= 0 || this.getPosY() >= 600 - this.getHeight()) {
			setSpeedY(- this.getSpeedY());
			System.out.println(this.getHeight());
		}
		
	}
}

