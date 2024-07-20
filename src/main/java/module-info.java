module JiaheCai {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jlayer;
    requires javafx.media;
    exports SnakeGame;
    opens SnakeGame to javafx.fxml;
    exports SnakeGame.controller;
    opens SnakeGame.controller to javafx.fxml;
    exports SnakeGame.model;
    opens SnakeGame.model to javafx.fxml;
    exports SnakeGame.view;
    opens SnakeGame.view to javafx.fxml;
}