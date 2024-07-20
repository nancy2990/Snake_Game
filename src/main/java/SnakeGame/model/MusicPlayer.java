package SnakeGame.model;

import java.net.URL;

import SnakeGame.MainFX;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This method creates mediaplayer to play mp3 music
 * @author: Jiahe Cai
 * @program: SnakeGame
 */
public class MusicPlayer {

	/**
	 * This is the file path of the music to be played
	 */
	private final String FILENAME;
	/**
	 * Media firstly initialized
	 */
	private Media media;
	/**
	 * MediaPlayer firstly initialized
	 */
	static MediaPlayer m_MediaPlayer;
	/***
	 * set flag to see if music requires to be played in loop
	 */
	private boolean autoplay;

	/**
	 * This constructor gets the music file location in string
	 * @param filename music file location
	 */
	public MusicPlayer(String filename)
	{
		this.FILENAME = filename;
	}

	/**
	 * @param filename music file location
	 * @param autoplay true means requiring autoplay, false means only play once
	 */
	public static void getMusicPlay(String filename,boolean autoplay)  {
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play(autoplay);
	}

	/**
	 * This method plays the music in required mode
	 * @param autoplay pass the isAutoPlay flag
	 */
	public void play(boolean autoplay) {
		final URL resource = getClass().getResource(FILENAME);
		media = new Media(resource.toString());
		m_MediaPlayer = new MediaPlayer(media);
		if(autoplay==true)
			m_MediaPlayer.setAutoPlay(autoplay);
		else
			m_MediaPlayer.play();
	}

	/**
	 * This method calls the music to stop playing
	 */
	public static void Stop(){
		m_MediaPlayer.stop();
	}

}



