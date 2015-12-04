import java.util.ArrayList;


public class Ball extends PongItem {
		

	public Ball (String Image,  int posX, int posY){
		super(Image, posX, posY);
		if(Math.random()>0.5)
			this.setSpeedX(2);
		else{
			this.setSpeedX(-2);
		}
		this.setSpeedY(2);
	}
	
	public void rebound (ArrayList<PongItem> t) {
		for (int i=1; i<t.size(); i++) {
			if (this.collision(t.get(i)) == true) {
				setSpeedX(- this.getSpeedX());
				setPosX(t.get(i).getPosX() + t.get(i).getWidth());
			}
		} 
		if ( this.getPosX() >= Pong.SIZE_PONG_X - this.getWidth()) {
			setSpeedX(- this.getSpeedX());
		}
		
		if (this.getPosY() <= 0 || this.getPosY() >= Pong.SIZE_PONG_Y - this.getHeight()) {
			setSpeedY(- this.getSpeedY());
			//System.out.println(this.getHeight());
		}
		
	}
}



