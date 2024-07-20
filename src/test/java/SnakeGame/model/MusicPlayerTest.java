package SnakeGame.model;

import SnakeGame.MainFX;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static SnakeGame.model.MusicPlayer.m_MediaPlayer;
import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest extends ApplicationTest {
    @BeforeAll
    static void initJfxRuntime() {
        Platform.startup(() -> {});
        Media media = new Media(MainFX.class.getResource("/music/background.mp3").toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(media);
        MusicPlayer.getMusicPlay("/music/background.mp3",false);

    }
    @Test
    void getMusicPlayTest(){
        MusicPlayer musicPlayer = new MusicPlayer("/music/background.mp3");
        assertTrue(musicPlayer.m_MediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING));
    }
    @Test
    void getMusicStopTest() {
        MusicPlayer musicPlayer = new MusicPlayer("/music/background.mp3");
        musicPlayer.Stop();
        assertTrue(musicPlayer.m_MediaPlayer.getStatus().equals(MediaPlayer.Status.STOPPED));
    }


}