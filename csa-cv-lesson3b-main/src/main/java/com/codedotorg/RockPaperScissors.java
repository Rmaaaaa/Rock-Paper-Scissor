package com.codedotorg;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RockPaperScissors {

    private Stage window;
    private MainScene game;
    private GameOverScene gameOver;
    private GameLogic logic;

    public RockPaperScissors(Stage primaryStage) {

        this.window = primaryStage;
        this.window.setTitle("Rock Paper Scissors");

        this.game = new MainScene();
        this.gameOver = new GameOverScene();
        this.logic = new GameLogic();
    }

    public void playGame() {
        loadMainScreen();
    }

    public void loadMainScreen() {

        logic.resetLogic();

        Scene scene = game.createMainScene(this);
        window.setScene(scene);
        window.show();
    }

    public void playRound(String userChoice) {

        String computerChoice = logic.getComputerChoice();
        String result = logic.determineWinner(userChoice, computerChoice);

        System.out.println("User: " + userChoice);
        System.out.println("Computer: " + computerChoice);
        System.out.println("Result: " + result);

        // UPDATE UI
        game.showResult(result, computerChoice);

        // GAME OVER CHECK
        if (logic.isGameOver()) {

            PauseTransition pause = new PauseTransition(Duration.seconds(2));

            pause.setOnFinished(e -> loadGameOver(result));

            pause.play();
        }
    }

    public void loadGameOver(String result) {

        Button playAgain = gameOver.getPlayAgainButton();

        playAgain.setOnAction(e -> loadMainScreen());

        Scene scene = gameOver.createGameOverScene(result);

        window.setScene(scene);
    }
}