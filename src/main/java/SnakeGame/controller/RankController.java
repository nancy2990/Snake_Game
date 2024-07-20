package SnakeGame.controller;


import SnakeGame.MainFX;
import SnakeGame.model.MusicPlayer;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * This controller control the scene to allow user to see the current high score lists in two level set.
 * @author: Jiahe Cai
 * @program: SnakeGame
 */
public class RankController {

    /**
     * if user click this button, goto start page and play mouse click music.
     * @throws IOException
     */
    @FXML
    private void switchToStart() throws IOException {
        MusicPlayer.getMusicPlay("/music/mouseClick.mp3",false);
        MainFX.setRoot("/view/start");
    }

    /**
     * initialize the rank pane
     */
    @FXML
    private Pane rankPane;

    /**
     * initialize the choicebox for which level set user wants to see the rank list
     */
    @FXML
    private ChoiceBox setChoice;

    /**
     * initialize the rankfile list for different level set
     */
    private ArrayList<String> rankFileList = new ArrayList<>();


    /**
     * initialize the rank data list
     */
    private ArrayList<ArrayList<PlayerScore>> rawRankData = new ArrayList<>();

    /**
     * This method read data from file,sort the data, and show the first rank.
     * Add observer to the choice box.
     * @throws IOException
     */
    @FXML
    public void initialize() throws IOException {
        String path = "src/main/resources/ranking";
        getFile(path);
        readRankData();
        showRank(0);
        setChoice.setItems(FXCollections.observableArrayList(rankFileList));
        setChoice.setValue(rankFileList.get(0));
        setChoice.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val)->{
                    showRank(new_val.intValue());
                }
        );
    }


    /**
     * This method read data from file and sort data in
     * and store into an ArrayList of Arraylist
     * @throws FileNotFoundException
     */
    private void readRankData() throws FileNotFoundException {
        for(int i = 0; i < rankFileList.size(); i++){
            String curFilePath = "src/main/resources/ranking/"+rankFileList.get(i)+"Rank.txt";
            FileReader fr = new FileReader(curFilePath);
            ArrayList<PlayerScore> rawRank = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(fr)) {
                while (true) {      // this loop read every line in the rank file
                    String line = reader.readLine();
                    String playerName = "";
                    int score= 999;
                    if (line == null || !line.contains(":") ) {   //empty line
                        break;
                    }else{
                        String contents[] = line.split(":", 2);
                        score = Integer.parseInt(contents[0]);
                        playerName = contents[1];
                    }
                    PlayerScore curPlayer = new PlayerScore(score,playerName);
                    rawRank.add(curPlayer);
                }
            } catch (IOException e) {
                System.out.println("Error:" + e );
            }
            rawRankData.add(sortRank(rawRank));
        }
    }

    /**
     * This method show the top 10 rank of the selected map set.
     * If the rank count is less than 10, then it should show unknown in the page.
     * @param idx the index for different level set
     */
    private void showRank (int idx) {
        ArrayList<Label> countLabels= new ArrayList<>();
        ArrayList<Label> playerLabels= new ArrayList<>();
        for (int i = 0; i < 10; i++){
            countLabels.add((Label) rankPane.lookup("#top"+(i+1)+"score"));
            playerLabels.add((Label) rankPane.lookup("#top"+(i+1)+"player"));
        }
        ArrayList<PlayerScore> curList = rawRankData.get(idx);
        for(int i = 0; i < 10; i++){
            countLabels.get(i).setText("unknown");
            playerLabels.get(i).setText("unknown");
        }

        for (int i = 0; i < (curList.size()<10?curList.size():10); i++){
            countLabels.get(i).setText(String.valueOf(curList.get(i).getScore()));
            playerLabels.get(i).setText(curList.get(i).getPlayerName());
        }
    }

    /**
     * This method sort array list of string in ascending order and return the sorted rank
     * @param rawRank unsorted ranking list
     */
    private ArrayList<PlayerScore> sortRank (ArrayList<PlayerScore> rawRank){
        Collections.sort(rawRank, Comparator.comparingInt(PlayerScore::getScore).reversed());
        return rawRank;
    }

    /**
     * This method gets rank file
     * @param path path to the file
     */
    private void getFile(String path){
        File file = new File(path);
        File[] array = file.listFiles();
        for(int i=0;i<array.length;i++)
        {
            if(array[i].isFile())
            {
                String curFileName = array[i].getName();
                rankFileList.add(curFileName.substring(0,curFileName.length()-8));
            }
        }
    }

}
