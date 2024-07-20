package SnakeGame.view;

import SnakeGame.model.ImageUtil;
import SnakeGame.model.Play;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class is for obstacles drawing in graphics
 * @author: Jiahe Cai-modified
 * @program: SnakeGame
 */
public class Obstacle extends SnakeObject implements Object
{
	/**
	 * Initialize symbolic constants for number of obstacles
	 */
	final int NUM_OBSTACLES=5;

	/**
	 * @Description getter get number of obstacles
	 * @return number of obstacles
	 */
	public int getNum_Obstacles() {
		return NUM_OBSTACLES;
	}

	/**
	 * initialize array list for obstacle location x y
	 */
	ArrayList<Integer> xlocation_Array = new ArrayList<>();
	ArrayList<Integer> ylocation_Array = new ArrayList<>();

	/**
	 * This constructor initializes parameters for food object
	 * and check if food is overlapped with obstacles
	 */
	public Obstacle(){
		this.l = true;

		this.i = ImageUtil.m_images.get("obstacle");

		this.w = i.getWidth(null);
		this.h = i.getHeight(null);
		checkifOverlapping();
	}

	/**
	 * This method check whether each obstacle generated overlap with each other
	 * if is overlapped, random location x and y again and restore in array
	 */
	private void checkifOverlapping() {
		for (int m=0; m < NUM_OBSTACLES; m++){
			this.x = (int) (Math.random() * (870 - w + 10));
			this.y = (int) (Math.random() * (560 - h - 40));
			boolean isOverlapping=true;
			while(isOverlapping) {
				isOverlapping=false;
				for(int n = 0; n < m;n++) {
					isOverlapping=checkinDetail(n);
				}
			}
			xlocation_Array.add(x);
			ylocation_Array.add(y);
		}
	}

	/**
	 * This method separates one obstacle in arrays to check
	 * @param n index in array that overlapped with other
	 * @return	if it overlaps,random location x and y again and restore in array
	 */
	private boolean checkinDetail(int n) {
		if(overlapping(x,y,xlocation_Array.get(n),ylocation_Array.get(n))){
			this.x = (int) (Math.random() * (870 - w + 10));
			this.y = (int) (Math.random() * (560 - h - 40));
			xlocation_Array.set(n,this.x);
			ylocation_Array.set(n,this.y);
			return true;
		}else
			return false;
	}

	/**
	 * This method checks if two objects in form (x,y) is overlapped
	 * @param check_x
	 * @param check_y
	 * @param init_x
	 * @param init_y
	 * @return true if is overlapped
	 * false if isn't
	 */
	public boolean overlapping(int check_x, int check_y, int init_x, int init_y){
		if(check_x > init_x){
			if(check_y > init_y){
				if((check_x-init_x)<this.w && (check_y-init_y)<this.h){
					return true;
				}else
					return false;
			}else{
				if((check_x-init_x)<this.w && (init_y-check_y)<this.h){
					return true;
				}else
					return false;
			}
		}else{
			if(check_y > init_y){
				if((init_x-check_x)<this.w && (check_y-init_y)<this.h){
					return true;
				}else
					return false;
			}else{
				if((init_x-check_x)<this.w && (init_y-check_y)<this.h){
					return true;
				}else
					return false;
			}
		}
	}

	/**
	 * This hit method check if mysnake intersects with obstacle's rectangle
	 * if player 2's snake hits, set value of isFailplayer1 to be false, player 1 wins
	 * else isFailplayer1 remains the default value
	 * change the flag l to be false, ends the game
	 * @param mySnake
	 */
	public boolean hit(MySnake mySnake)	{
		for (int k = 0; k<NUM_OBSTACLES;k++){
		if (mySnake.getRectangle().intersects(new Rectangle(xlocation_Array.get(k), ylocation_Array.get(k), w, h)) && l && mySnake.l){
			this.l = false;
			if(mySnake.isSecondSnake())
				Play.setFailplayer1(false);
			break;
		}
		}
		return this.l;
	}
	/**
	 * draw onstacles image in location (x,y) in arrays in g
	 * @param g
	 */
	@Override
	public void draw(Graphics g)
	{
		for (int k = 0; k < NUM_OBSTACLES; k++) {

			g.drawImage(i, xlocation_Array.get(k), ylocation_Array.get(k), null);
		}
	}
}
