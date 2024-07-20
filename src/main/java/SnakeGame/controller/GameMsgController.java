package SnakeGame.controller;

import SnakeGame.MainFX;
import SnakeGame.model.MusicPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static SnakeGame.view.MySnake.getScore;
import static SnakeGame.view.MySnake.setScore;


/***
 *  This controller control the scene to allow user to write user's name and store score and name in the document
 *  @author: Jiahe Cai
 *  @program: SnakeGame
 */
public class GameMsgController {
    /**
     * The victory message label tells user how many scores he/she has
     */
    @FXML
    private Label vicMsg;

    /**
     * The player input name field
     */
    @FXML
    private TextField nameField;

    /**
     * The alert message.
     * Hide at first, when user does not enter the username or enter with incorrect format,
     * this message will show
     */
    @FXML
    private Label alertMsg;
    /**
     * The save message.
     * Hide at first, when user enter the correct form of username and data is stored successfully,
     * this message will show
     */
    @FXML
    private Label saveMsg;
    /***
     * The flag show whether name and score have been saved or not.
     */
    private boolean isSaved=false;

    /**
     * This setter for vicMsg sets the text message will show
     * @Description setter
     */
    public void setVicMsg(){
        vicMsg.setText("Congrats! You complete game "+ " with " + getScore() + " scores");
    }

    /**
     * This message is called when user clicked ok.
     * It firstly judges whether the user input is of correct format,
     * then judges whether the user data is stored successfully.
     */
    @FXML
    private void clickOK()  {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        if (nameField.getText().equals("")){
            alertMsg.setText("Please Enter your name!");
            return;
        }else if(nameField.getText().contains(":")){
            alertMsg.setText("Player name cannot contain ':' !");
            return;
        }else{
            alertMsg.setText("");
        }

        try {
            if(isSaved==false) {
                storePlayerData();
                isSaved=true;
                saveMsg.setText(nameField.getText()+"'s score is saved successfully!");
            }else{
                saveMsg.setText("Score is already saved!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method stores the user's rank data into a specific file.
     * If this level set is firstly played, then it should create a file.<br>
     * This method uses buffer writer to write into the file.
     * @throws IOException
     */

    private void storePlayerData() throws IOException {
        String rankFileName;
        if(MenuController.getLevel())
            rankFileName = "SimpleRank.txt";
        else
            rankFileName = "HardRank.txt";

        File rankFile = new File("src/main/resources/ranking/"+rankFileName);
        if (!rankFile.exists()) {   // if the file does not exist
            rankFile.createNewFile(); // create one
        }
        if (rankFile.exists()) {
            System.out.println("file exists");
            FileWriter fw = new FileWriter(rankFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(getScore()+":"+nameField.getText()+"\n");
            bw.flush();
            bw.close();
            fw.close();
            System.out.println("rank saved successfully!");
        }
        }

    /**
     * if user click button switch to start scene
     * @throws IOException
     */
    public void switchtoRank() throws IOException {
        MainFX.setRoot("/view/rank");
        setScore(0);
    }
}



