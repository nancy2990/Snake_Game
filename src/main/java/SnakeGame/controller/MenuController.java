package SnakeGame.controller;


import java.io.IOException;

import SnakeGame.MainFX;
import SnakeGame.model.MusicPlayer;
import SnakeGame.model.Play;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import javax.swing.*;

/**
 * This controller control the scene to allow user to choose level set and player set of the game
 * @author: Jiahe Cai
 * @program: SnakeGame
 */
public class MenuController {
    /**
     * initialize level flag to be true
     */
    static Boolean level =true;

    /**
     * @Description getter
     * @return returns current level set, true is simple level, false is hard level
     */
    public static Boolean getLevel() {
        return level;
    }


    /**
     * name radiobutton to use to identify if the user choose simple level set
     */
    @FXML
    private RadioButton simple;
    /**
     * name radiobutton to use to identify if the user choose hard level set
     */
    @FXML
    private RadioButton hard;
    /**
     * name radiobutton to use to identify if the user choose oneplayer mode
     */
    @FXML
    private RadioButton onePlayer;
    /**
     * name radiobutton to use to identify if the user choose twoplayers mode
     */
    @FXML
    private RadioButton twoPlayers;
    /***
     * if user choose insufficient radio buttons, warn message will show to remind user
     */
    @FXML
    private Label warnMsg;

    /**
     * This method get the boolean value for the flag of "does user choose two player mode"
     * @Description getter
     * @return returns true if user selects two player mode
     *  and returns false if user selects one player mode
     */
    public static boolean getIstwoplayer() {
        return istwoplayer;
    }

    /**
     * This method set the boolean value for istwoplayer
     * @Description setter
     * @param istwoplayer true if user selects two player mode
     *      *  and false if user selects one player mode
     */
    public void setIstwoplayer(boolean istwoplayer) {
        this.istwoplayer = istwoplayer;
    }

    /**
     * initialize the boolean value to be one player mode
     */
    static boolean istwoplayer = true;
    /***
     * flag for how many times player plays
     */
    static int flag=0;

    /***
     * @Description getter for flag
     * @return flag
     */
    public static int getFlag() {
        return flag;
    }

    /**
     * This method switch scene to be start page and play the mouse click music if user click this button
     * @throws IOException
     */
    @FXML
    private void switchToStart() throws IOException {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        MainFX.setRoot("/view/start");
    }

    /**
     * This method starts the game in the user's choices for play sets
     * and warns user if he/she choose insufficient choices
     * @throws IOException
     */
    @FXML
    private void start() throws IOException {
        //user doesn't choose level set
        if(hard.isSelected()==false && simple.isSelected()==false){
            //user doesn't choose either player set or level set
            if(onePlayer.isSelected()==false && twoPlayers.isSelected()==false) {
                warnMsg.setText("Please Choose your level and your player mode!");
                return;
            }else{
                warnMsg.setText("Please Choose your level!");
                return;
            }
            //user doesn't choose player set
        } else if (onePlayer.isSelected()==false && twoPlayers.isSelected()==false) {
            warnMsg.setText("Please Choose your player mode!");
            return;
        }
        if(simple.isSelected()){
            level=true;
        }else
            level=false;
        if(onePlayer.isSelected()){
            setIstwoplayer(false);
        }else
            setIstwoplayer(true);
        flag++;
        SwingUtilities.invokeLater(()->new Play());

        if(getIstwoplayer())
            //if user choose two player set, scores won't be count
            MainFX.setRoot("/view/start");
        else
            //user choose one player set, go to gameMsg scene
            MainFX.setRoot("/view/gameMsg");
    }

}
