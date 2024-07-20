package SnakeGame.view;

import SnakeGame.controller.MenuController;
import SnakeGame.controller.OptionController;
import SnakeGame.model.GameUtil;
import SnakeGame.model.ImageUtil;
import SnakeGame.model.movable;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;


    /**
     *This class extends {@code SnakeObject} and implements {@code movable}
     * initialize MySnake parameters and movements
     */
    public class MySnake extends SnakeObject implements movable
    {

        /**
         * speed for snake
         */
        int speed_XY;
        /**
         * length for snake
         */
        private int length;
        /**
         * @Description getter get the length value
         * @return length value
         */
        public int getLength()
        {
            return length;
        }

        /**
         * @Description setter set value for length
         * @param length set value
         */
        public void changeLength(int length)
        {
            this.length = length;
        }

        /**
         * num for length per speed
         */
        private static int num;

        /**
         * @Description getter
         * @return num
         */
        public static int getNum() {
            return num;
        }

        /***
         * Initialize score with 0
         */
        static int score = 0;
        /**
         * @Description getter get score value
         * @return score
         */
        public static int getScore() {
            return score;
        }

        /**
         * @Description setter set the score value
         * @param score
         */
        public static void setScore(int score) {
            MySnake.score = score;
        }

        /**
         * Initialize image to store snake head image
         */
        private static BufferedImage IMG_SNAKE_HEAD = null;
        /***
         * Initialize image to store snake head showing player1 image
         */
        private static BufferedImage IMG_SNAKE_HEAD_Player1 = null;
        /***
         * Initialize image to store snake head showing player2 image
         */
        private static BufferedImage IMG_SNAKE_HEAD_Player2 = null;
        /***
         * Initialize points array to store snake's body points
         */
        static java.util.List<Point> bodyPoints = new LinkedList<>();
        /***
         * Initialize points array to store snake's body points for player2
         */
        static List<Point> bodyPoints_player2 = new LinkedList<>();
        /**
         * Initialize bufferedImage for snake head for player1
         */
        private static BufferedImage newImgSnakeHead;
        /**
         * Initialize bufferedImage for snake head for player2
         */
        private static BufferedImage newImgSnakeHead2;
        /**
         * Intialize boolean values to identify keyPressed directions
         */
        boolean up, down, left, right = true;
        /***
         * Initialize flag to determine whether this snake is for player2
         */
        boolean isSecondSnake = false;
        final int LOWSPEED=5;
        final int HIGHSPEED=10;
        /***
         * @Description getter get the value for isSecondSnake
         * @return true if is for player2
         * false if isn't
         */
        public boolean isSecondSnake() {
            return isSecondSnake;
        }

        /**
         * This constructor reads options set from Option and Menu page and set snake's theme
         * and initialize w and h for snake image
         * @param x snake's location x
         * @param y snake's location y
         * @param isSecondSnake flag for whether this snake is for player2
         */
        public MySnake(int x, int y,boolean isSecondSnake)
        {
            this.l = true;
            this.x = x;
            this.y = y;
            this.isSecondSnake=isSecondSnake;
            if(MenuController.getIstwoplayer()){
                if(OptionController.getM_color()==OptionController.getM_red()){
                    this.i = ImageUtil.m_images.get("snake-body-red");
                    IMG_SNAKE_HEAD_Player1 = (BufferedImage) ImageUtil.m_images.get("snake-head-red-player1");
                    IMG_SNAKE_HEAD_Player2 = (BufferedImage) ImageUtil.m_images.get("snake-head-red-player2");
                    System.out.println("red");
                }else if(OptionController.getM_color()==OptionController.getM_yellow()){
                    this.i = ImageUtil.m_images.get("snake-body-yellow");
                    IMG_SNAKE_HEAD_Player1 = (BufferedImage) ImageUtil.m_images.get("snake-head-yellow-player1");
                    IMG_SNAKE_HEAD_Player2 = (BufferedImage) ImageUtil.m_images.get("snake-head-yellow-player2");
                    System.out.println("yellow");
                }else{
                    this.i = ImageUtil.m_images.get("snake-body-green");
                    IMG_SNAKE_HEAD_Player1 = (BufferedImage) ImageUtil.m_images.get("snake-head-green-player1");
                    IMG_SNAKE_HEAD_Player2 = (BufferedImage) ImageUtil.m_images.get("snake-head-green-player2");
                    System.out.println("green");
                }
            }else {
                if (OptionController.getM_color() == OptionController.getM_red()) {
                    this.i = ImageUtil.m_images.get("snake-body-red");
                    IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.m_images.get("snake-head-right-red");
                } else if (OptionController.getM_color() == OptionController.getM_yellow()) {
                    this.i = ImageUtil.m_images.get("snake-body-yellow");
                    IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.m_images.get("snake-head-right-yellow");
                } else {
                    this.i = ImageUtil.m_images.get("snake-body-green");
                    IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.m_images.get("snake-head-right-green");
                }
            }

            this.w = i.getWidth(null);
            this.h = i.getHeight(null);

            if(MenuController.getLevel())
                this.speed_XY = LOWSPEED;
            else
                this.speed_XY = HIGHSPEED;
            this.length = 1;

            this.num = w / speed_XY;
            if(MenuController.getIstwoplayer()) {
                newImgSnakeHead = IMG_SNAKE_HEAD_Player1;
                newImgSnakeHead2 = IMG_SNAKE_HEAD_Player2;
            }else
                newImgSnakeHead = IMG_SNAKE_HEAD;
        }

        /**
         * This method check which key is pressed, up, down, left or right
         * then rotate the snake head images and move the snake through flags for player1
         * @param e load which key is pressed
         */
        public void keyPressed(KeyEvent e)
        {
            // check KeyCode
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:
                    if (!down)
                    {
                        up = true;
                        down = false;
                        left = false;
                        right = false;
                        if(MenuController.getIstwoplayer())
                            newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD_Player1, -90);
                        else
                            newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if (!up)
                    {
                        up = false;
                        down = true;
                        left = false;
                        right = false;
                        if(MenuController.getIstwoplayer())
                            newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD_Player1, 90);
                        else
                            newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                    }
                    break;

                case KeyEvent.VK_LEFT:
                    if (!right)
                    {
                        up = false;
                        down = false;
                        left = true;
                        right = false;
                        if(MenuController.getIstwoplayer())
                            newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD_Player1, -180);
                        else
                            newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if (!left)
                    {
                        up = false;
                        down = false;
                        left = false;
                        right = true;
                        if(MenuController.getIstwoplayer())
                            newImgSnakeHead = IMG_SNAKE_HEAD_Player1;
                        else
                            newImgSnakeHead = IMG_SNAKE_HEAD;
                    }

                default:
                    break;
            }
        }
        /**
         * This method check which key is pressed, w/W, s/S, a/A, d/D,
         * then rotate the snake head images and move {@code move} the snake through flags for player1
         * @param e load which key is pressed
         */
        public void keyPressed_playertwo(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case 87:
                    if (!down)
                    {
                        up = true;
                        down = false;
                        left = false;
                        right = false;

                        newImgSnakeHead2 = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD_Player2, -90);
                    }
                    break;

                case 83:
                    if (!up)
                    {
                        up = false;
                        down = true;
                        left = false;
                        right = false;

                        newImgSnakeHead2 = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD_Player2, 90);
                    }
                    break;

                case 65:
                    if (!right)
                    {
                        up = false;
                        down = false;
                        left = true;
                        right = false;

                        newImgSnakeHead2 = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD_Player2, -180);

                    }
                    break;

                case 68:
                    if (!left)
                    {
                        up = false;
                        down = false;
                        left = false;
                        right = true;

                        newImgSnakeHead2 = IMG_SNAKE_HEAD_Player2;
                    }

                default:
                    break;
            }
        }

        /**
         * This method receives flags and move the snake in the speed of speed_XY
         */
        public void move()
        {
            if (up)
            {
                y -= speed_XY;
            } else if (down)
            {
                y += speed_XY;
            } else if (left)
            {
                x -= speed_XY;
            } else if (right)
            {
                x += speed_XY;
            }

        }

        /**
         * This method first check if snake hit boundary{@code outofBounds} or hit snake's body{@code eatBody},
         * if yes, flag l turns false and stop drawing
         * otherwise draws snake's head and body {@code drawBody}
         * and store points in different Link list for different player
         *
         * @param g
         */
        @Override
        public void draw(Graphics g)
        {
            outofBounds();
            eatBody();
            if(isSecondSnake()) {
                bodyPoints_player2.add(new Point(x, y));
                if (bodyPoints_player2.size() == (this.length + 1) * num)
                {
                    bodyPoints_player2.remove(0);
                }
            }
            else {
                bodyPoints.add(new Point(x, y));
                if (bodyPoints.size() == (this.length + 1) * num)
                {
                    bodyPoints.remove(0);
                }
            }


            if(isSecondSnake())
                g.drawImage(newImgSnakeHead2, x, y, null);
            else
                g.drawImage(newImgSnakeHead,x,y,null);
            drawBody(g);

            move();
        }

        /**
         * This method checks if snake touches itself or the other snake
         * if touches, flag l turns false
         * otherwise, remains true
         */
        public void eatBody()
        {
            for (Point point : bodyPoints)
            {
                for (Point point2 : bodyPoints)
                {
                    if (point.equals(point2) && point != point2)
                    {
                        this.l = false;
                    }
                }
            }
            if(isSecondSnake()) {
                for (Point point : bodyPoints)
                {
                    for (Point point2 : bodyPoints_player2)
                    {
                        if (point.equals(point2) && point != point2) {this.l= false;}
                    }
                }
            }
        }

        /**
         * This method draws MySnake's body in g
         * @param g
         */
        public void drawBody(Graphics g)
        {
            if(isSecondSnake()){
                int length = bodyPoints_player2.size() - 1 - num;
                for (int i = length; i >= num; i -= num) {
                    Point point = bodyPoints_player2.get(i);
                    g.drawImage(this.i, point.x, point.y, null);
                }
            }else {
                int length = bodyPoints.size() - 1 - num;

                for (int i = length; i >= num; i -= num) {
                    Point point = bodyPoints.get(i);
                    g.drawImage(this.i, point.x, point.y, null);
                }
            }
        }

        /**
         * This method check if the snake hit the boundary of the snake
         * if location for snake x or y is out, turns the flag to false
         * otherwise, l remains true
         */
        private void outofBounds()
        {
            boolean xOut = (x <= 0 || x >= (870 - w));
            boolean yOut = (y <= 0 || y >= (520 - h));
            if (xOut || yOut)
            {
                l = false;
            }
        }
    }


