package SnakeGame.controller;


import java.io.IOException;

import SnakeGame.MainFX;
import SnakeGame.model.MusicPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;


/**
 * This controller control the scene to allow user to start the game, got to options scene, see current ranking list and exit
 * @author: Jiahe Cai
 * @program: SnakeGame
 */
public class StartController {
    @FXML
    private Label warning;
    /**
     * This method is implemented when user click the button, the mouse click sound is played
     * and scene will be transferred to menu
     * @throws IOException
     */
    @FXML
    private void switchToMenu() throws IOException {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        if(MenuController.getFlag()==0)
            MainFX.setRoot("/view/menu");
        else{
            warning.setText("Please close the game and start again!");
        }

    }
    /**
     * This method is implemented when user click the button, the mouse click sound is played
     * and the system will be closed
     * @throws IOException
     */
    @FXML
    private void exitGame() throws IOException {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        System.exit(0);
    }
    /**
     * This method is implemented when user click the button, the mouse click sound is played
     * and scene will be transferred to option
     * @throws IOException
     */
    public void switchtoOption(ActionEvent actionEvent) throws IOException {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        MainFX.setRoot("/view/option");
    }
    /**
     * This method is implemented when user click the button, the mouse click sound is played
     * and scene will be transferred to rank
     * @throws IOException
     */
    public void switchtoRank(ActionEvent event) throws IOException {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        MainFX.setRoot("/view/rank");
    }

}
