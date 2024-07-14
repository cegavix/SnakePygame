package Model;

import View.FrameView;
import Utils.ImageUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class SnakeModel {
    public static class MySnake extends ObjectsModel.Objects
    {
        private int speed_XY;
        private int level_speed = 6;
        private int length;
        private int num;
        private int score = 0; //doc: convention 7 make private, creates error with Food.java. FIXED.
        /**
         * This sets the length of the snake
         */
        public int getLength() //doc: convention violation: getters should be at top. FIXED.
        {
            return length;
        }
        public int getScore(){ return score;}

        public void setScore(int score) { this.score = score;} //doc: made setter as a result of convention 7


        static BufferedImage head_right = (BufferedImage) ImageUtil.m_images.get("snake-head-right");
        private static final BufferedImage IMG_SNAKE_HEAD = head_right; //Code Violation 3. Fixed.

        public static List<Point> bodyPoints = new LinkedList<>(); //list of xy coordinates for snakes body

        public static BufferedImage newImgSnakeHead;

        private boolean up, down, left;
        private boolean right = true; //doc: violation 7, encapsulation throughout

        /**
         * This method sets snake to appear with initial location and sets up
         * the relevant size, length and image for the snake to hold for View to present.
         * @param x The x coordinate of the snake location. In this case the initial location is set
         * @param y The y coordinate of the snake location. In this case the initial
         *         location of the snake is set when MySnake is called
         */
        public MySnake(int x, int y) //MOVED
        {

            final int START_SPEED = level_speed;
            this.setExists(true);
            this.setX(x);
            this.setY(y);
            this.setI(ImageUtil.m_images.get("snake-body"));
            this.setW(getI().getWidth(null));
            this.setH(getI().getHeight(null));

            this.setSpeed_XY(START_SPEED);
            this.length = 1;

            this.num = getW() / getSpeed_XY();
            newImgSnakeHead = IMG_SNAKE_HEAD;

        }

        /**
         * The setter for length to allow the snake to change length as it gains points
         * @param length The length of the snake and as a result its Bodypoints
         * @link draw method and how it utilises the length
         */
        public void setLength(int length) //model MOVED
        {
            this.length = length;
        }

        /**
         * This method brings to view for the user the snake head and snake body
         * according to updates from the model, which is retrieved using getters and setters.
         * The method checks if game has failed using outofBounds() and eatBody() before updating
         * the model and moving the snake.
         * @param g The component object on which to draw the body parts
         */
        @Override
        public void draw(Graphics g) //view
        {
            outofBounds();
            eatBody();

            bodyPoints.add(new Point(getX(), getY()));

            if (bodyPoints.size() == (this.length + 1) * num)//if the size of bodypoints is equal to length of snake +1 * num
            {
                bodyPoints.remove(0);
            }
            g.drawImage(newImgSnakeHead, getX(), getY(), null);
            drawBody(g);

            move(this);
        }

        /**
         * This method checks to see if the snake has eaten itself using the
         * coordinates of the body points. If so, it sets the snake to not
         * exist, as a result ending the game
         */
        public void eatBody()
        {
            for (Point point : bodyPoints)
            {
                for (Point point2 : bodyPoints)
                {
                    if (point.equals(point2) && point != point2)
                    {
                        this.setExists(false);
                    }
                }
            }
        }

        /**
         * This method brings into view the body parts according to the BodyPoint
         * coordinates and updates length.
         * @param g The component object on which the method draws the body parts
         *
         */
        public void drawBody(Graphics g) //view
        {
            int length = bodyPoints.size() - 1 - num;

            for (int i = length; i >= num; i -= num)
            {
                Point point = bodyPoints.get(i);
                g.drawImage(this.getI(), point.x, point.y, null);
            }
        }

        /**
         * This method checks if the Snake's x coordinates are within the bounds
         * of the screen. If not the snake exists is set to false which ends the game.
         */
        private void outofBounds() //model MOVED
        {
            boolean xOut = (getX() <= 0 || getX() >= (FrameView.WINDOW_WIDTH - getW()));
            boolean yOut = (getY() <= 0 || getY() >= (FrameView.WINDOW_HEIGHT - getH()));
            if (xOut || yOut)
            {
                setExists(false);
            }
        }
        /**
         * This gets whether the snake is currently going right as a boolean.
         */
        public boolean isRight() {
            return right;
        }
        /**
         * This sets whether the snake is going right as a boolean.
         */
        public void setRight(boolean right) {
            this.right = right;
        }
        /**
         * This gets whether the snake is currently going up as a boolean.
         */
        public boolean isUp() {
            return up;
        }
        /**
         * This sets whether the snake is going up as a boolean.
         */
        public void setUp(boolean up) {
            this.up = up;
        }
        /**
         * This gets whether the snake is currently going down as a boolean.
         */
        public boolean isDown() {
            return down;
        }
        /**
         * This sets whether the snake is going down as a boolean.
         */
        public void setDown(boolean down) {
            this.down = down;
        }
        /**
         * This gets whether the snake is currently going left as a boolean.
         */
        public boolean isLeft() {
            return left;
        }
        /**
         * This sets whether the snake is going left as a boolean.
         */
        public void setLeft(boolean left) {
            this.left = left;
        }
        /**
         * This gets the speed of the snake
         */
        public int getSpeed_XY() {
            return speed_XY;
        }
        /**
         * This sets the speed of the snake
         */
        public void setSpeed_XY(int speed_XY) {
            this.speed_XY = speed_XY;
        }
        /**
         * @deprecated This gets the set level speed of the snake, whether its
         * level 10,15 or 20. This is currently has little use and relevant for
         * future updates

        public int getLevel_speed() {
            return level_speed;
        }*/

        /**
         * @deprecated This feature is not in use on current version.
         * @param level_speed The speed that corresponds to the level that the
         *                    snake is currently on.

        public void setLevel_speed(int level_speed) {
            this.level_speed = level_speed;
        }*?

        /**
         * @deprecated Method use for future versions to change difficulty level
         * @param level the level of the game, set by user input but initially
         *              will be equal to 1.

        public void setGameLevel(int level) {
            if (level == 1) {
                setLevel_speed(10);
            } else if (level == 2) {
                level_speed = 15;
            } else if (level == 3) {
                level_speed = 20;
            }
        }*/

    }



}
