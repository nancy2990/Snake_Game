package SnakeGame.view;

import SnakeGame.controller.MenuController;
import SnakeGame.controller.OptionController;
import SnakeGame.model.GameUtil;
import SnakeGame.model.ImageUtil;
import SnakeGame.model.MusicPlayer;
import SnakeGame.model.movable;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

/**
 * This class using swing opens a new window to play game
 * it extends {@code JPanel} and implements {@code KeyListener}
 * @Project SnakeGame
 * @Author Jiahe Cai
 */ 


public class MyFrame extends JPanel implements KeyListener
{
	/**
	 * Initialize jFrame, a new window
	 */
	JFrame jFrame = new JFrame();

	/**
	 * This constructor set Icon for jFrame
	 * and other details for jFrame{@code loadFrame}
	 * and play music of background
	 */
	public MyFrame()
	{
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MyFrame.class.getResource("/view/snake-logo.png")));
		this.loadFrame();
		MusicPlayer.getMusicPlay("/music/background.mp3",true);
	}


	/**
	 * This method set details for jFrame and start new thread
	 */
	public void loadFrame()
	{
		//use double buffered to avoid flashing of images
		this.setDoubleBuffered(true);
		jFrame.add(this);
		jFrame.addKeyListener(this);

		jFrame.setTitle("Greedy Snake");
		jFrame.setSize(870, 560);
		jFrame.setLocationRelativeTo(null);
		//when user click closingwindow button
		//close current window and stop the background music
		jFrame.addWindowListener(new WindowAdapter()// loka
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				MusicPlayer.Stop();
			}
		});
		jFrame.setVisible(true);
		new MyThread().start();
	}


	/**
	 * This class extends {@code Thread}
	 * create new images and repaint the old ones
	 */
	class MyThread extends Thread
	{
		@Override
		public void run()
		{
			super.run();
			while (true)
			{
				repaint();
				try
				{
					sleep(30);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/***
	 * The following method needs to override the java.awt.event.KeyLister
	 * to ensure keyPressed works as MyFrame can't be abstract;
	 * as only keyPressed is override, remain three contents to be blank
	 * rewrite keyPressed in MySnake {@code MySnake.keyPressed} {@code MySnake.keyPressed_playertwo}
	 * @param e the event to be processed
	 */
	@Override
	public void keyTyped(KeyEvent e) {}

	/**
	 * The following method needs to override the java.awt.event.KeyLister
	 * to ensure keyPressed works as MyFrame can't be abstract;
	 * @param e the event to be processed
	 */
	@Override
	public void keyPressed(KeyEvent e) {}

	/**
	 * The following method needs to override the java.awt.event.KeyLister
	 * to ensure keyPressed works as MyFrame can't be abstract;
	 * @param e the event to be processed
	 */
	@Override
	public void keyReleased(KeyEvent e) {}

}
