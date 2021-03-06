import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Font;

/**MainMenu class<p>
  * This classs diaplays the Main Menu screen.
  * <p>
  * <b>Instance Variables: </b>
  * <p>
  * mainMenuBg: main menu background image
  * 
  * @author Nikita Lizogubenko
 * */
public class MainMenu
{
  public Image mainMenuBg;
  
  /**Constructor<p>
    * The constructor load the main menu image.
   * */
  public MainMenu () {
    mainMenuBg = (new ImageIcon ("resources\\images\\MainMenuBg.png")).getImage();
  }

  /**Method public void paint (Graphics2D g)<p>
    * Paints the image on the screen
    * 
    * @param g graphics object used to paint on the screen
   * */
  protected void paint(Graphics2D g)
  {    
    g.drawImage(mainMenuBg, 0, 0, null);
  }
}