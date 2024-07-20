package SnakeGame.view;

import java.awt.*;

    /**
     * This class is the abstract class initialize parameters for snake
     */
    public abstract class SnakeObject
    {
        /**
         * Location x for snake
         */
        int x;
        /**
         * Location y for snake
         */
        int y;
        /**
         * Image to store snake's body image
         */
        Image i,j;
        /**
         * Width for the image
         */
        int w;
        /***
         * Height for image
         */
        int h;

        /**
         * @Description getter for l
         * @return flag l value
         */
        public boolean isL() {
            return l;
        }

        /**
         * Control flag for snake, identify if the next thread snake should be drawn
         */
        boolean l;


        /**
         * Draw snake in g
         * @param g
         */
        public abstract void draw(Graphics g);

        /**
         * @Description getter Get the rectangle
         * @return the rectangle in location (x,y) with width of w and height of h
         */
        public Rectangle getRectangle()
        {
            return new Rectangle(x, y, w, h);
        }
    }

