package SnakeGame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * This class the start of the program, and extends the {@code Application}.
 * @program: SnakeGame
 * @author: Jiahe Cai
 * @create: 2020-11-4
 */
    public class MainFX extends Application {

    /**
     * This main launches to call start
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Intialize scene
     */
    private static Scene scene;

    /**
     * This method initialize the stage with scene start
     * and define system end by press window close
     * @param stage current stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/view/start"),870,560);
        stage.setScene(scene);
        stage.setTitle("Greedy Snake");
        stage.getIcons().add(new Image(MainFX.class.getResource("/view/snake-logo.png").openStream()));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
    }

    /**
     * This method helps to switch scene
     * @param fxml name for fxml document
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * This method create fxmlLoader and generate fxml document
     * @param fxml name for fxml document
     * @return returns load
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
