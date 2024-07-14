package Model;

import Controller.SnakeController;

import java.awt.*;

/**
 * This class models the data needed for the objects model. It is used by both
 * the FoodModel and the SnakeModel.
 */

public class ObjectsModel {

    public abstract static class Objects extends SnakeController
    {
        //all of objects dimensions & its animated image
        private int x;
        private int y;
        private Image i; //the food or snakes photo
        private int w;
        private int h;

       private boolean exists;

        /**
         * Constructor for draw which is used for different objects Food and Snake
         * @param g component that java draws too
         */
        public abstract void draw(Graphics g);

        /**
         * This creates a new rectangle for the object.
         * @return new Rectangle This makes a new rectangle object for the objects.
         * It is used to check if a point should be given for the rectangles of objects
         * food and snake touching
         */
        public Rectangle getRectangle()
        {
            return new Rectangle(getX(), getY(), getW(), getH()); //makes a rectangle for position of GameObjects, where xy is location of upper left corner
        }

        /**
         * This gets whether the snake exists as a bool
         * @return exists
         */
        public boolean isExists() {
            return exists;
        }

        /**
         * This sets the snake to exist as a bool
         * @param exists
         */
        public void setExists(boolean exists) {
            this.exists = exists;
        }

        /**
         * This gets the x coordinate of the object
         * @return x coordinate
         */
        public int getX() {
            return x;
        }

        /**
         * This sets the x coordinate to the parameter passed in x
         * @param x
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * This gets the y coordinate of the object
         * @return y
         */
        public int getY() {
            return y;
        }

        /**
         * This sets the x coordinate to the parameter passed in x
         * @param y
         */
        public void setY(int y) {
            this.y = y;
        }

        /**
         * This gets the Width of the object
         */

        public int getW() {
            return w;
        }

        /**
         * This sets the width of the object
         * @param w being width of object
         */

        public void setW(int w) {
            this.w = w;
        }
        /**
         * This gets the width of the object
         *
         */
        public int getH() {
            return h;
        }
        /**
         * This sets the height of the object
         * @param h being height of object
         */
        public void setH(int h) {
            this.h = h;
        }

        /**
         * This gets the image of the object
         * @return i
         */
        public Image getI() {
            return i;
        }
        /**
         * This sets the image of the object
         * @param i being the passed in image of the object
         */
        public void setI(Image i) {
            this.i = i;
        }
    }
}
