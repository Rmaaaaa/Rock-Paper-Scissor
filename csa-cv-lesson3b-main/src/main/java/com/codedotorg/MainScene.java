package com.codedotorg;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainScene {

    private VBox root;

    private Label title;
    private Label resultLabel;
    private Label computerLabel;
    private Label userLabel;

    private Button rock;
    private Button paper;
    private Button scissors;
    private Button exit;

    private RockPaperScissors controller;

    public MainScene() {

        title = new Label("Rock Paper Scissors");

        resultLabel = new Label("");
        computerLabel = new Label("");
        userLabel = new Label("");

        rock = new Button("Rock");
        paper = new Button("Paper");
        scissors = new Button("Scissors");

        exit = new Button("Exit");
    }

    public Scene createMainScene(RockPaperScissors controller) {

        this.controller = controller;

        root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        rock.setOnAction(e -> controller.playRound("rock"));
        paper.setOnAction(e -> controller.playRound("paper"));
        scissors.setOnAction(e -> controller.playRound("scissors"));

        exit.setOnAction(e -> System.exit(0));

        root.getChildren().addAll(
                title,
                userLabel,
                computerLabel,
                resultLabel,
                rock,
                paper,
                scissors,
                exit
        );

        return new Scene(root, 400, 500);
    }

    public void showUserResponse(String userChoice, double score) {
        userLabel.setText("You: " + userChoice + " (" + score + ")");
    }

    public void showResult(String result, String computerChoice) {
        resultLabel.setText(result);
        computerLabel.setText("Computer: " + computerChoice);
    }
}