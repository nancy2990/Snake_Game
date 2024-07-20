package SnakeGame.controller;

import SnakeGame.MainFX;
import SnakeGame.model.MusicPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
/**
 * This controller control the scene to allow user to choose two themes of the game, background and snake color.
 * @author: Jiahe Cai
 * @program: SnakeGame
 */
public class OptionController {
    /**
     * Initialize the radio button red
     */
    @FXML
    private RadioButton Red;
    /**
     * Initialize the radio button green
     */
    @FXML
    private RadioButton Green;
    /**
     * Initialize the radio button yellow
     */
    @FXML
    private RadioButton Yellow;


    /**
     * Initialize the static color integer as flag for user snake color choices
     */
    static int m_color;

    /**
     * @Description getter
     * @return m_color
     */
    public static int getM_color() {
        return m_color;
    }
    /**
     * Const value for integer represents red color
     */
    static final int RED=1;
    /**
     * @Description getter
     * @return return the integer value represents the red color of user choice
     */
    public static int getM_red() {
        return RED;
    }

    /**
     * Const value for integer represents yellow color
     */
    static final int YELLOW=2;
    /**
     * @Description getter
     * @return return the integer value represents the yellow color of user choice
     */
    public static int getM_yellow() {
        return YELLOW;
    }

    /**
     * Initialize radio button rainbow for user's background choice
     */
    @FXML
    private RadioButton rainbow;
    /**
     * Initialize radio button sky for user's background choice
     */
    @FXML
    private RadioButton sky;

    /**
     * Initialize the static boolean value indicates if user chooses sky background
     */
    static boolean m_isSkyBackground;

    /**
     * This method get the boolean value of isSkyBackground
     * @Description setter
     * @return returns value of isskyground,
     * returns true means user chooses sky background/sky radio button
     * returns false means user choose rainbow background/rainbow radio button
     */
    public static boolean isIsSkyBackground() {
        return m_isSkyBackground;
    }

    /**
     * This method set the boolean value of isSkyBackground
     * @Description setter
     * @param isSkyBackground changes as which radio button is chosen
     * set the boolean to be true means user chooses sky background/sky radio button
     * set the boolean to be false means user chooses rainbow background/sky radio button
     */
    public static void setIsSkyBackground(boolean isSkyBackground) {
        OptionController.m_isSkyBackground = isSkyBackground;
    }


    /**
     * This method is implemented when user click the button, the mouse click sound is played
     * and scene will be transferred to start
     * @throws IOException
     */
    @FXML
    private void switchToStart() throws IOException {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        MainFX.setRoot("/view/start");
    }

    /**
     * This method is implemented when user click the button to play game
     * it sets the background and snake color choices
     * and go to menu scene for user to choose further play set
     * @throws IOException
     */
    @FXML
    public void start() throws IOException {
        if(rainbow.isSelected()){
            setIsSkyBackground(false);
        }else{
            setIsSkyBackground(true);
        }
        if(Red.isSelected()){
            m_color=RED;
        }else if(Green.isSelected()){
            m_color=0;
        }else{
            m_color=YELLOW;
        }
        MainFX.setRoot("/view/menu");
    }

    /**F
     * This method is implemented when user decides to reset or back to default theme settings
     * The mouse click music plays as well
     */
    @FXML
    public void clearChoices() {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        rainbow.setSelected(true);
        sky.setSelected(false);
        Red.setSelected(false);
        Green.setSelected(false);
        Yellow.setSelected(true);
    }
}
