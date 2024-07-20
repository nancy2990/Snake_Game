package SnakeGame.model;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 * loads images from resources and assigns them with names
 * food with numbers to make it convenient to choose food type randomly {@code Food}
 *@author: Jiahe Cai-modified
 *@program: SnakeGame
 */
public class ImageUtil
{
	/**
	 * This Map<String, Image> stores image's name and image itself
	 */
	public static Map<String, Image> m_images = new HashMap<>();

	static
	{
		// snake
		m_images.put("snake-head-right-red", GameUtil.getImage("/snake/snake-head-right-red.png"));
		m_images.put("snake-head-right-green", GameUtil.getImage("/snake/snake-head-right-green.png"));
		m_images.put("snake-head-right-yellow", GameUtil.getImage("/snake/snake-head-right-yellow.png"));
		m_images.put("snake-head-yellow-player1", GameUtil.getImage("/snake/snake-head-yellow-player1.png"));
		m_images.put("snake-head-yellow-player2", GameUtil.getImage("/snake/snake-head-yellow-player2.png"));
		m_images.put("snake-head-red-player1", GameUtil.getImage("/snake/snake-head-red-player1.png"));
		m_images.put("snake-head-red-player2", GameUtil.getImage("/snake/snake-head-red-player2.png"));
		m_images.put("snake-head-green-player1", GameUtil.getImage("/snake/snake-head-green-player1.png"));
		m_images.put("snake-head-green-player2", GameUtil.getImage("/snake/snake-head-green-player2.png"));
		m_images.put("snake-body-red", GameUtil.getImage("/snake/snake-body-red.png"));
		m_images.put("snake-body-green", GameUtil.getImage("/snake/snake-body-green.png"));
		m_images.put("snake-body-yellow", GameUtil.getImage("/snake/snake-body-yellow.png"));
		m_images.put("obstacle", GameUtil.getImage("/view/images/obstacle.png"));
		// obstacles
		m_images.put("0", GameUtil.getImage("/food/food-kiwi.png"));
		m_images.put("1", GameUtil.getImage("/food/food-lemon.png"));
		m_images.put("2", GameUtil.getImage("/food/food-litchi.png"));
		m_images.put("3", GameUtil.getImage("/food/food-mango.png"));
		m_images.put("4", GameUtil.getImage("/food/food-apple.png"));
		m_images.put("5", GameUtil.getImage("/food/food-banana.png"));
		m_images.put("6", GameUtil.getImage("/food/food-blueberry.png"));
		m_images.put("7", GameUtil.getImage("/food/food-cherry.png"));
		m_images.put("8", GameUtil.getImage("/food/food-durian.png"));
		m_images.put("9", GameUtil.getImage("/food/food-grape.png"));
		m_images.put("10", GameUtil.getImage("/food/food-grapefruit.png"));
		m_images.put("11", GameUtil.getImage("/food/food-peach.png"));
		m_images.put("12", GameUtil.getImage("/food/food-pear.png"));
		m_images.put("13", GameUtil.getImage("/food/food-orange.png"));
		m_images.put("14", GameUtil.getImage("/food/food-pineapple.png"));
		m_images.put("15", GameUtil.getImage("/food/food-strawberry.png"));
		m_images.put("16", GameUtil.getImage("/food/food-watermelon.png"));
		m_images.put("rainbow-background", GameUtil.getImage("/view/images/UI-background.png"));
		m_images.put("sky-background", GameUtil.getImage("/view/images/UI-background2.png"));
		m_images.put("end-scene", GameUtil.getImage("/view/images/end.png"));
		//images.put("start-scene",GameUtil.getImage(("start.jpg")));
	}
}
