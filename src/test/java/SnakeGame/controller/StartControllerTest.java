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

class StartControllerTest extends ApplicationTest {
    @Override
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainFX.class.getResource("/view/start.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,860,560);

        stage.setScene(scene);
        stage.show();
    }
    @Test
    void setFxmlButtonTest() {
        verifyThat("#menuButton", hasText("Menu"));
        verifyThat("#rankButton", hasText("Ranking"));
        verifyThat("#optionButton", hasText("Options"));
        verifyThat("#exitButton", hasText("Exit"));
    }

}