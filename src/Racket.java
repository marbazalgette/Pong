
public class Racket extends PongItem{
	
	public Racket (String Image,  int posX, int posY, int speedY){
		super(Image, posX, posY);
		this.speedY = speedY;
	}
	
	public void move(){
		super.move();
		if(this.getPosY()<0)
			this.setPosX(0);
		if(this.getPosY()>Pong.SIZE_PONG_Y)
			this.setPosY(Pong.SIZE_PONG_Y);
			
	}

}
