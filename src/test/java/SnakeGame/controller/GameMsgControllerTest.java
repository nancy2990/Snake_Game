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

class GameMsgControllerTest extends ApplicationTest {
    @Override
    public void start (Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFX.class.getResource("/view/gameMsg.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 860, 560);

            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void setFxmlButtonTest() {
        verifyThat("#okBtn", hasText("OK"));
        verifyThat("#again", hasText("View Ranking List"));
    }
    @Test
    void validnameFieldTest(){
        clickOn("#nameField").write("Jiahe Cai");
        clickOn("#okBtn");
        verifyThat("#saveMsg", hasText("Saved successfully!"));
    }
    @Test
    void clicktwiceokBtnTest(){
        clickOn("#nameField").write("Jiahe Cai");
        clickOn("#okBtn");
        clickOn("#okBtn");
        verifyThat("#saveMsg", hasText("Score is already saved!"));
    }
    @Test
    void invalidnameFieldTest(){
        clickOn("#nameField").write("I am :");
        clickOn("#okBtn");
        verifyThat("#alertMsg", hasText("Player name cannot contain ':' !"));
    }
    @Test
    void nullnameFieldTest(){
        clickOn("#nameField").write("");
        clickOn("#okBtn");
        verifyThat("#alertMsg", hasText("Please Enter your name!"));
    }

}