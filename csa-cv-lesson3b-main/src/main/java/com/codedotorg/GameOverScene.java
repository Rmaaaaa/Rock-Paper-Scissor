package com.codedotorg;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class GameOverScene {

    private Button playAgainButton;

    public Scene createGameOverScene(String winner) {

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        Label label = new Label("Game Over");
        Label result = new Label(winner);

        playAgainButton = new Button("Play Again");

        root.getChildren().addAll(label, result, playAgainButton);

        return new Scene(root, 400, 400);
    }

    public Button getPlayAgainButton() {
        return playAgainButton;
    }
}