package Model;

import View.MusicPlayer;
import View.FrameView;
import Utils.ImageUtil;

import java.awt.*;
import java.util.Random;

/**
 * This class models the food objects and checks whether an object is eaten to update view
 */
public class FoodModel extends ObjectsModel.Objects {

    public static final int NUM_OF_FOOD = 16;
    public static final int BORDER = 10;

    /**
     * This method initialises a food object by randomising an image for it
     * and a location. Uses setters from GameObject to automatically update data
     * @link draw is used to display this image with generated layout information
     */
    public FoodModel()	{
        this.setExists(true);

        this.setI(ImageUtil.m_images.get(String.valueOf(new Random().nextInt(NUM_OF_FOOD))));

        this.setW(getI().getWidth(null)); //get snake width
        this.setH(getI().getHeight(null));
        //Where to place food on screen;
        this.setX((int) (Math.random() * (FrameView.WINDOW_WIDTH - getW() + BORDER)));
        this.setY((int) (Math.random() * (FrameView.WINDOW_HEIGHT - getH() - BORDER)));
    }

    /**
     * This checks whether the snake has intersected with a food object and whether the
     * point is valid. It updates the Score and calls for the +1 point audio to be played
     * @param mySnake
     */
     public void eaten(SnakeModel.MySnake mySnake) {

         final int SCORE_INCREASE = 521;//doc: Convention violation 10. Fixed.
         boolean objectsIntersect = mySnake.getRectangle().intersects(this.getRectangle());
         boolean objectsExist = isExists() && mySnake.isExists(); //doc: convention violation fixed
         if (objectsIntersect && objectsExist) {
             this.setExists(false);
             mySnake.setLength(mySnake.getLength() + 1);
             int score = mySnake.getScore();


             score += SCORE_INCREASE;
             mySnake.setScore(score);
             MusicPlayer.makeMusicPlay("src/main/resources/point.mp3");
         }
     }

    /**
     * This draws the food to screen using the information initialised in FoodModel
     * @param g The component on which the method will display graphics to screen
     */
     @Override
     public void draw(Graphics g)
     {
         g.drawImage(getI(), getX(), getY(), null);
     }

}

