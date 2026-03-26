package com.codedotorg;

import java.util.Random;

public class GameLogic {

    private boolean gameOver;

    public GameLogic() {
        gameOver = false;
    }

    public String getComputerChoice() {
        Random random = new Random();
        int pick = random.nextInt(3);

        if (pick == 0) return "rock";
        if (pick == 1) return "paper";
        return "scissors";
    }

    public String determineWinner(String userChoice, String computerChoice) {

        userChoice = userChoice.toLowerCase().trim();

        if (userChoice.equals(computerChoice)) {
            return getTieResult();
        }

        if (userChoice.equals("rock")) {
            return computerChoice.equals("scissors")
                    ? getUserWinnerResult()
                    : getComputerWinnerResult();
        }

        if (userChoice.equals("paper")) {
            return computerChoice.equals("rock")
                    ? getUserWinnerResult()
                    : getComputerWinnerResult();
        }

        if (userChoice.equals("scissors")) {
            return computerChoice.equals("paper")
                    ? getUserWinnerResult()
                    : getComputerWinnerResult();
        }

        return "Input tidak valid";
    }

    public String getTieResult() {
        gameOver = true;
        return "Seri!";
    }

    public String getUserWinnerResult() {
        gameOver = true;
        return "Kamu menang!";
    }

    public String getComputerWinnerResult() {
        gameOver = true;
        return "Komputer menang!";
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void resetLogic() {
        gameOver = false;
    }
}