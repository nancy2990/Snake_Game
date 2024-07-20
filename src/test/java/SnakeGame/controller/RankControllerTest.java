package SnakeGame.controller;

import SnakeGame.MainFX;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;


import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

class RankControllerTest extends ApplicationTest {
    @Override
    public void start (Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainFX.class.getResource("/view/rank.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,860,560);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    void setFxmlButtonTest() {
        verifyThat("#backtoStart", hasText("Back to Start"));
    }
    @Test
    void checkHardLevelRank(){
        verifyThat("#top1score",hasText("2605"));
        verifyThat("#top2score",hasText("521"));
        verifyThat("#top3score",hasText("0"));
        verifyThat("#top4score",hasText("unknown"));
        verifyThat("#top5score",hasText("unknown"));
        verifyThat("#top6score",hasText("unknown"));
        verifyThat("#top7score",hasText("unknown"));
        verifyThat("#top8score",hasText("unknown"));
        verifyThat("#top9score",hasText("unknown"));
        verifyThat("#top10score",hasText("unknown"));

        verifyThat("#top1player",hasText("Jiahe Cai"));
        verifyThat("#top2player",hasText("xixi"));
        verifyThat("#top3player",hasText("Lejun Chen"));
        verifyThat("#top4player",hasText("unknown"));
        verifyThat("#top5player",hasText("unknown"));
        verifyThat("#top6player",hasText("unknown"));
        verifyThat("#top7player",hasText("unknown"));
        verifyThat("#top8player",hasText("unknown"));
        verifyThat("#top9player",hasText("unknown"));
        verifyThat("#top10player",hasText("unknown"));
    }
    @Test
    void checkSimpleLevelRank(){
        clickOn("#setChoice");
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        verifyThat("#top1score",hasText("3126"));
        verifyThat("#top2score",hasText("1042"));
        verifyThat("#top3score",hasText("521"));
        verifyThat("#top4score",hasText("0"));
        verifyThat("#top5score",hasText("unknown"));
        verifyThat("#top6score",hasText("unknown"));
        verifyThat("#top7score",hasText("unknown"));
        verifyThat("#top8score",hasText("unknown"));
        verifyThat("#top9score",hasText("unknown"));
        verifyThat("#top10score",hasText("unknown"));

        verifyThat("#top1player",hasText("Nancy"));
        verifyThat("#top2player",hasText("xx"));
        verifyThat("#top3player",hasText("safe"));
        verifyThat("#top4player",hasText("hey"));
        verifyThat("#top5player",hasText("unknown"));
        verifyThat("#top6player",hasText("unknown"));
        verifyThat("#top7player",hasText("unknown"));
        verifyThat("#top8player",hasText("unknown"));
        verifyThat("#top9player",hasText("unknown"));
        verifyThat("#top10player",hasText("unknown"));
    }

}