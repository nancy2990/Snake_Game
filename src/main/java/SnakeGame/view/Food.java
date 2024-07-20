package SnakeGame.view;

import SnakeGame.model.ImageUtil;

import java.awt.Graphics;
import java.util.Random;

/**
 * This class is for food drawing in graphics，it extends {@code Obstacle} and implements {@code Object}
 * @author: Jiahe Cai-modified
 * @program: SnakeGame
 */
public class Food extends Obstacle implements Object
{
	/**
	 * This constructor initialize parameters for food object
	 * and check if food is overlapped with obstacles
	 */
	public Food()	{
		this.l = true;

		this.i = ImageUtil.m_images.get(String.valueOf(new Random().nextInt(10)));

		this.w = i.getWidth(null);
		this.h = i.getHeight(null);

		this.x = (int) (Math.random() * (870 - w + 10));
		this.y = (int) (Math.random() * (560 - h - 40));
		checkifOverlapping();
	}

	/**
	 * This method check whether obstacles generated overlap with food
	 * if is overlapped, random location x and y again and restore in array
	 */
	private void checkifOverlapping() {
		boolean isOverlapping=true;
		while(isOverlapping) {
			for(int n = 0; n < getNum_Obstacles();n++) {
				if(overlapping(x,y,xlocation_Array.get(n),ylocation_Array.get(n))){
					isOverlapping = true;
					this.x = (int) (Math.random() * (870 - w + 10));
					this.y = (int) (Math.random() * (560 - h - 40));
					xlocation_Array.set(n,this.x);
					ylocation_Array.set(n,this.y);
					break;
				}else
					isOverlapping=false;
			}
			if(isOverlapping==false)
				break;
		}
	}

	/**
	 * This hit method check if mysnake intersects with food's rectangle
	 * if hit, add score and snake length, change flag l to create another food
	 * @param mySnake
	 */
	public boolean hit(MySnake mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle()) && l && mySnake.l)		{
			this.l = false;
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.score += 521;
		}
		return this.l;
	}

	/**
	 * draw food image in location (x,y) in g
	 * @param g
	 */
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(i, x, y, null);
	}
}
