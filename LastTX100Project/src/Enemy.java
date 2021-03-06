import java.awt.*;
import javax.swing.*;

/**Enemy Class<p>
  * This class is a sprite fot the enemies. It contains the position variales of the
  * enemies provides of painting and moving the enemies and for collision detecion.
  * <p>
  * <b>Instance Variables: </b>
  * <p>
  * x: x coordinate of the enemy
  * <p>
  * y: y coordinate of the enemy
  * <p>
  * speedX: horizontal displacement of the enemy
  * <p>
  * mainImage: main image that is currently shown
  * <p>
  * goingRight: image when ship is going right
  * <p>
  * goingLeft: image when ship if going left
  * <p>
  * height: height of the enemy ship
  * <p>
  * weight: weight of the enemy ship
  * 
  * @author Utkarsh Lamba
 * */
public class Enemy {
  
  private int x;
  private int y;
  private int speedX;
  private Image mainImage;
  private Image goingRight;
  private Image goingLeft;
  private int height;
  private int width;
  
  /**Constructor public Enemy()<p>
    * This constructor sets the initial variables of the enemy ship, loads the images.
    * It also strats off the ship in randomly either the right or the left direction
    * and sets the images accordingly..
   * */
  public Enemy(int speed){
    this.x = ((int)(Math.random() * (750))) + 5;
    this.y = 0;
    
    ImageIcon iR = new ImageIcon("resources\\images\\EnemyShipRight.png");
    goingRight = iR.getImage();
    ImageIcon iL = new ImageIcon("resources\\images\\EnemyShipLeft.png");
    goingLeft = iL.getImage();
    
    double randomSelection = Math.random();
    if (randomSelection<0.5) {
      speedX = speed;
      mainImage = goingRight;
    } else {
      speedX = -speed;
      mainImage = goingLeft;
    }
    this.width = iR.getIconWidth();
    this.height = iL.getIconHeight();
  }
  
  /**Method public void move (int speed)<p>
    * This method moves the ship across and down the ocean and changes direction
    * when the ship hits the boundaries.
    * 
    * @param speedY vertical displacement of the enemy ship
   * */
  public void move (int speedY){
    if (x<2 || x>(800-width-2)){
      speedX = -speedX; 
    }
    if (speedX>0) mainImage = goingRight;
    else mainImage = goingLeft;
    x += speedX;
    y += speedY;    
  }
  
  /**Method public void paint (Graphcis2D g)<p>
    * Paints the ship on the screen at the specified coordinates
    * @param g graphcis object used for painting
   * */
  public void paint(Graphics2D g) {
    g.drawImage(mainImage,x, y, null);
  }
  
  /**Method public int getY()<p>
    * Getter method for the y coordinate
    * @return y coordinate 
   * */
  public int getY(){
    return this.y;
  }
  
  /**Method public int getX()<p>
    * Getter method for the x coordinate
    * @return x coordinate 
   * */
  public int getX(){
    return this.x;
  }
  
  /**Method public Rectangle getRect()<p>
    * Creates a rectangle for collision detection
    * @return rectangle the surrounds the enemy ship
   * */
  public Rectangle getRect(){
    return new Rectangle (x,y, width, height);
  }
  
  
}