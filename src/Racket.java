
public class Racket extends PongItem{
	
	public Racket (String Image,  int posX, int posY, int speedY){
		super(Image, posX, posY);
		this.speedY = speedY;
	}
	
	
	/*
	 Méthode plus addaptée pour faire bouger la Raquette qui permet de s'assurer qu'elle ne sorte pas de l'aire de jeu
	 */
	
	public void move(){
		super.move();
		if(this.getPosY()<0)
			this.setPosX(0);
		if(this.getPosY()>Pong.SIZE_PONG_Y)
			this.setPosY(Pong.SIZE_PONG_Y-this.getHeight());
			
	}

}
