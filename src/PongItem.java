import java.awt.Image;
import java.awt.Rectangle;


import javax.swing.ImageIcon;

public abstract class PongItem {
	/*
	 ensemble des paramètres commun à l'ensembles des objets d'un Pong
	 */
	protected int posX;
	protected int posY;
	protected int width;
	protected int height;
	protected int speedX;
	protected int speedY;
	protected ImageIcon sprite;
	/*
	 Constructeur de l'objet Pong
	 */
	protected PongItem (String Image, int posX, int posY){
		this.sprite = new ImageIcon(Image);
		this.posX = posX;
		this.posY = posY;
		this.height = sprite.getIconHeight();
		this.width = sprite.getIconWidth();
		this.speedX = 0;
		this.speedY = 0;
	}
	/*
	 Ensemble des getter et setter 
	 */

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public  int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public Image getSprite() {
		return sprite.getImage();
	}

	public void setSprite(String sprite) {
		this.sprite = new ImageIcon(sprite);
	}
	
	/*
	 Methode permettant de gérer les collisions à l'aide de hitbox 
	 */
	protected boolean collision(PongItem p){
		Rectangle a = new Rectangle (this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
		Rectangle b = new Rectangle (p.getPosX(), p.getPosY(), p.getWidth(), p.getHeight());
		if(a.intersects(b)){
			return true;
		}
		return false;
	}
	
	/*
	 Méthode permettant de bouger un PongItem
	 */
	protected void move(){
		posX += speedX;
		posY += speedY;
	}
	
}
