package SnakeGame.view;

import SnakeGame.view.MyFrame;

import java.awt.*;

/**
 * This is the interface object for food and object as they share commons in drawing
 */
public interface Object {
    /**
     * This method draws the object in g
     * @param g
     */
    void draw(Graphics g);

    /**
     * This method check whether two objects
     * with location (check_x,check_y),(init_x,init_y)
     * overlaps
     * @param check_x
     * @param check_y
     * @param init_x
     * @param init_y
     * @return
     */
    boolean overlapping(int check_x, int check_y, int init_x, int init_y);

    /**
     * This method checks if mysnake hits the object
     * @param mySnake
     */
    boolean hit(MySnake mySnake);
}