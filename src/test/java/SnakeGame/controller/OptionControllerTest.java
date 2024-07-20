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


class OptionControllerTest extends ApplicationTest{
    @Override
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainFX.class.getResource("/view/option.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,860,560);

        stage.setScene(scene);
        stage.show();
    }
    @Test
    void setFxmlButtonTest() {
        verifyThat("#reset", hasText("Reset to Default"));
        verifyThat("#backtoStart1", hasText("Back to Start"));
        verifyThat("#Play",hasText("Ready to Play"));
    }
    @Test
    void setBackgroundTest(){
        clickOn("#");
    }

}