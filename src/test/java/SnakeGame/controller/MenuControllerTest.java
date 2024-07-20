package SnakeGame.controller;

import SnakeGame.MainFX;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;


import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

class MenuControllerTest extends ApplicationTest {
    @Override
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainFX.class.getResource("/view/menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,860,560);

        stage.setScene(scene);
        stage.show();
    }
    @Test
    void setFxmlContainerTest() {
        verifyThat("#twoPlayers", hasText("Two Players"));
        verifyThat("#onePlayer", hasText("One Player"));
        verifyThat("#backtoStart", hasText("Back to Start"));
        verifyThat("#startGame", hasText("Start Game"));
        verifyThat("#hard",hasText("Hard Level"));
        verifyThat("#simple",hasText("Simple Level"));
    }
    @Test
    void missLevelSelection(){
        clickOn("#onePlayer");
        clickOn("#startGame");
        verifyThat("#warnMsg",hasText("Please Choose your level!"));
    }
    @Test
    void missPlayerModeSelection(){
        clickOn("#simple");
        clickOn("#startGame");
        verifyThat("#warnMsg",hasText("Please Choose your player mode!"));
    }
    @Test
    void properSelection(){
        clickOn("#simple");
        clickOn("#onePlayer");
        verifyThat("#warnMsg",hasText(""));
    }

}