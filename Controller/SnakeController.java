package Controller;

import Model.SnakeModel;
import Utils.GameUtil;
import Utils.ImageUtil;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * This class controls the movement of the snake by using getters and setters
 * from model to change the direction of the snake-head image displayed by listening to user key input.
 */
public class SnakeController { //another controller. length change
    static BufferedImage head_right = (BufferedImage) ImageUtil.m_images.get("snake-head-right");
    private static final BufferedImage IMG_SNAKE_HEAD = head_right; //Code Violation 3. Fixed.
    /** @param: KeyEvent e being the users input for snake direction
     * @param mySnake This is  thesnake object initialised by SnakeModel,
     *                which allows for single instantiation of snake
     * This method implements a listener that changes snake head direction
     * according to what arrow key is pressed. Accesses my
     */
    public void keyPressed(KeyEvent e, SnakeModel.MySnake mySnake) { //CHANGE

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (!mySnake.isDown()) //Snake can only turn 90 degrees at a time. Cannot turn UP when going DOWN.
                {
                    mySnake.setUp(true);
                    mySnake.setDown(false);
                    mySnake.setLeft(false);
                    mySnake.setRight(false);

                    mySnake.newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);

                }
                break;

            case KeyEvent.VK_DOWN:
                if (!mySnake.isUp()) {
                    mySnake.setUp(false);
                    mySnake.setDown(true);
                    mySnake.setLeft(false);
                    mySnake.setRight(false);

                    mySnake.newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case KeyEvent.VK_LEFT:
                if (!mySnake.isRight()) {
                    mySnake.setUp(false);
                    mySnake.setDown(false);
                    mySnake.setLeft(true);
                    mySnake.setRight(false);

                    mySnake.newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);
                }
                break;

            case KeyEvent.VK_RIGHT:
                if (!mySnake.isLeft()) {
                    mySnake.setUp(false);
                    mySnake.setDown(false);
                    mySnake.setLeft(false);
                    mySnake.setRight(true);

                    mySnake.newImgSnakeHead = IMG_SNAKE_HEAD;
                }

            default:
                break;
        }
    }

    /**
     * This method sends information to the model to be stored for the updated
     * direction of snake, which in turn updates View in FrameView
     * @param snake
     */
    public void move(SnakeModel.MySnake snake)
    {
        // explain this method
        if (snake.isUp())
        {
            snake.setY(snake.getY() - snake.getSpeed_XY());
        } else if (snake.isDown())
        {
            snake.setY(snake.getY() + snake.getSpeed_XY());
        } else if (snake.isLeft())
        {
            snake.setX(snake.getX() - snake.getSpeed_XY());
        } else if (snake.isRight())
        {
            snake.setX(snake.getX() + snake.getSpeed_XY());
        }

    }
}
