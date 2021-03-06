import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;

/**
 * Class Animation<p>
 * This class is responsible for playing the explosion animation.
 * Credits go to www.gametutorial.net
 * <p>
 * <b>Instance variables: </b>
 * <p>
 * animImag: Image of animation.
 * <p>
 * frameWidth: Width of one frame in animated image.
 * <p>
 * frameHeight: Height of the frame(image)<p>
 * <p>
 * number of Frames: Number of frames in the animation image
 * <p>
 * frameTime: Amount of time between frames in milliseconds. (How many time in milliseconds will be one frame shown before showing next frame?)
 * <p>
 * startingFrameTime: Time when the frame started showing. (We use this to calculate the time for the next frame.)
 * <p>
 * timeForNextFrame: Time when we show next frame
 * (When current time is equal or greater then time in "timeForNextFrame", it's time to move to the next frame of the animation.)
 * <p>
 * currentFrameNumber: Current frame number
 * <p>
 * loop: Should animation repeat in loop?
 * <p>
 * x, y: x and y coordinates 
 * <p>
 * startingXOfFrame, endingXOfFrame: starting and ending x coordinates of the current frame in the animation image.
 * <p>
 * active: State of animation. Is it still active or is it finished? We need this so that we can check and delete animation when is it finished.
 * <p>
 * showDelay: In milliseconds. How long to wait before starting the animation and displaying it?
 * <p>
 * timeOfAnimationCreation: At what time was animation created.
 * 
 * @author www.gametutorial.net
 */

public class Animation {
   
    private Image animImage;
    private int frameWidth;
    private int frameHeight;
    private int numberOfFrames;
    private long frameTime;
    private long startingFrameTime;
    private long timeForNextFrame;
    private int currentFrameNumber;
    private boolean loop;
    public int x;
    public int y;
    private int startingXOfFrameInImage;
    private int endingXOfFrameInImage;
    public boolean active;
    private long showDelay;
    private long timeOfAnimationCration;


    /**Constructor<p>
     * Creates animation.
     * 
     * @param frameWidth Width of the frame in animation image "animImage".
     * @param frameHeight Height of the frame in animation image "animImage" - height of the animation image "animImage".
     * @param numberOfFrames Number of frames in the animation image.
     * @param frameTime Amount of time that each frame will be shown before moving to the next one in milliseconds.
     * @param loop Should animation repeat in loop?
     * @param x x coordinate. Where to draw the animation on the screen?
     * @param y y coordinate. Where to draw the animation on the screen?
     * @param showDelay In milliseconds. How long to wait before starting the animation and displaying it?
     */
    public Animation(int frameWidth, int frameHeight, int numberOfFrames, long frameTime, boolean loop, int x, int y, long showDelay)
    {
        this.animImage = (new ImageIcon ("resources\\images\\explosion.png")).getImage();
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.numberOfFrames = numberOfFrames;
        this.frameTime = frameTime;
        this.loop = loop;

        this.x = x;
        this.y = y;
        
        this.showDelay = showDelay;
        
        timeOfAnimationCration = System.currentTimeMillis();

        startingXOfFrameInImage = 0;
        endingXOfFrameInImage = frameWidth;

        startingFrameTime = System.currentTimeMillis() + showDelay;
        timeForNextFrame = startingFrameTime + this.frameTime;
        currentFrameNumber = 0;
        active = true;
    }


    /**Method changeCoordinates(int x, int y)
     * Changes the coordinates of the animation.
     * 
     * @param x x coordinate. Where to draw the animation on the screen?
     * @param y y coordinate. Where to draw the animation on the screen?
     */
    public void changeCoordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    /**Method Update()
     * It checks if it's time to show next frame of the animation.
     * It also checks if the animation is finished.
     */
    private void Update()
    {
        if(timeForNextFrame <= System.currentTimeMillis())
        {
            // Next frame.
            currentFrameNumber++;

            // If the animation is reached the end, we restart it by seting current frame to zero. If the animation isn't loop then we set that animation isn't active.
            if(currentFrameNumber >= numberOfFrames)
            {
                currentFrameNumber = 0;

                // If the animation isn't loop then we set that animation isn't active.
                if(!loop)
                    active = false;
            }

            // Starting and ending coordinates for cuting the current frame image out of the animation image.
            startingXOfFrameInImage = currentFrameNumber * frameWidth;
            endingXOfFrameInImage = startingXOfFrameInImage + frameWidth;

            // Set time for the next frame.
            startingFrameTime = System.currentTimeMillis();
            timeForNextFrame = startingFrameTime + frameTime;
        }
    }

    /**Method Paint (Graphics2D)
     * Draws current frame of the animation.
     * 
     * @param g2d Graphics2D
     */
    public void paint(Graphics2D g2d)
    {
        this.Update();
        
        // Checks if show delay is over.
        if(this.timeOfAnimationCration + this.showDelay <= System.currentTimeMillis()){
            g2d.drawImage(animImage, x, y, x + frameWidth, y + frameHeight, startingXOfFrameInImage, 0, endingXOfFrameInImage, frameHeight, null);
        }
        
    }
}