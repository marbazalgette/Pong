import java.util.ArrayList;


public class Ball extends PongItem {
		

	public Ball (String Image,  int posX, int posY, boolean j1){
		super(Image, posX, posY);
		/*if(Math.random()>0.5)
			this.setSpeedX(2);
		else{
			this.setSpeedX(-2);
		}*/
		if (j1) {
			this.setSpeedX(4);
			this.setSpeedY(4);
		}
		else {
			this.setSpeedX(-4);
			this.setSpeedY(-4);
		}
	}
	
	public void rebound (ArrayList<PongItem> t) {
		for (int i=1; i<t.size(); i++) {
			if (this.collision(t.get(i)) == true) {
				setSpeedX(- this.getSpeedX());
				setPosX(t.get(i).getPosX() + t.get(i).getWidth());
			}
		} 
		
		
		if (this.getPosY() <= 0 || this.getPosY() >= Pong.SIZE_PONG_Y - this.getHeight()) {
			setSpeedY(- this.getSpeedY());
			//System.out.println(this.getHeight());
		}
		
	}
}



