package SnakeGame.model;

import SnakeGame.controller.MenuController;
import SnakeGame.controller.OptionController;
import SnakeGame.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * @Project SnakeGame
 * @author Jiahe Cai-modified
 * @Description This class is basis of game engine. It establishes the swing to paint snakes\ food \obstacles
 * and extends {@code MyFrame}
 */

public class Play extends MyFrame
{
	/**
	 * Initialize the mySnake with position (100,100) and the first snake
	 */
	MySnake mySnake = new MySnake(100, 100,false);// x , y
	/**
	 * The second snake if player chooses two-player mode
	 */
	MySnake mySnake_player2;
	/**
	 * Using factory design to initialize food
	 */
	Food food = (Food) ObjectFactory.getObjectType("food");
	/**
	 * Using factory design to initialize obstcle
	 */
	private Obstacle obstacle = (Obstacle) ObjectFactory.getObjectType("obstacle");
	/**
	 * Initialize image to store background
	 */
	Image background;
	/**
	 * Initialize image to store fail image
	 */
	Image fail = ImageUtil.m_images.get("end-scene");



	/**
	 * Flag to point to the appear once pop-up
	 */
	private int flag=0;
	/**
	 * Initialize that isFailplayer1 is true
	 */
	private static boolean isFailplayer1=true;

	/**
	 * @Description setter for determine whether player 1 fails
	 * @param failplayer1
	 */
	public static void setFailplayer1(boolean failplayer1) {
		isFailplayer1 = failplayer1;
	}

	/**
	 * This constructor check if player choose two-player mode,
	 * if yes, initialize the second snake in position (100,400)
	 */
	public Play(){
		if(MenuController.getIstwoplayer()) {
			mySnake_player2 = new MySnake(100, 400,true);
			isFailplayer1=mySnake_player2.isL();
		}
	}

	/**
	 * This method controls diiferent snake movement by different key pressed
	 * @param e the event to be processed
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		mySnake.keyPressed(e);
		if(MenuController.getIstwoplayer()) {
			mySnake_player2.keyPressed_playertwo(e);
		}
	}

	/**
	 * This method paint obstacle, food, background and snake in graphic
	 * Identify that whether snake eats food or hits boundary/obstacles
	 * Finish the game by presenting the ending scene and pop-up message with score
	 * @param g the <code>Graphics</code> context in which to paint
	 */
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		if(OptionController.isIsSkyBackground()){
			background = ImageUtil.m_images.get("rainbow-background");
		}else {
			background=ImageUtil.m_images.get("sky-background");
		}

		g.drawImage(background, 0, 0, null);
			obstacle.draw(g);
			obstacle.hit(mySnake);
		if (mySnake.isL()&&obstacle.isL()&&isFailplayer1)
		{
			mySnake.draw(g);
			obstacle.hit(mySnake);
			if(MenuController.getIstwoplayer()) {
				mySnake_player2.draw(g);
				obstacle.hit(mySnake_player2);
				if(isFailplayer1)
					isFailplayer1=mySnake_player2.isL();
			}
			if (food.isL())
			{
				food.draw(g);
				food.hit(mySnake);
				if(MenuController.getIstwoplayer())
					food.hit(mySnake_player2);
			} else
			{
				food = (Food) ObjectFactory.getObjectType("food");
			}
			if(MenuController.getIstwoplayer()==false)
				drawScore(g);
		} else
		{
			g.drawImage(fail, 0, 0, 860,560,null);
			flag++;
			if(flag==1) {
				System.out.println(MySnake.getNum());
				if (MenuController.getIstwoplayer() == false) {
					String message = "Your score is " + mySnake.getScore();
					JOptionPane.showMessageDialog(null,message,
							"Score",JOptionPane.INFORMATION_MESSAGE);
				} else {
					if(isFailplayer1){
						JOptionPane.showMessageDialog(null,
								"Player 2 wins!!", "Winner", JOptionPane.INFORMATION_MESSAGE);
					}else
						JOptionPane.showMessageDialog(null,
								"Player 1 wins!!", "Winner", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	/**
	 * Draw the score in one player mode in the graphic
	 * @param g
	 */
	public void drawScore(Graphics g)
	{
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		g.setColor(Color.MAGENTA);
		g.drawString("SCORE : " + mySnake.getScore(), 20, 40);
	}

}
