package org.example;

import java.io.IOException;

public class Game {
    GameUI gameUI = new GameUI();
    GameTimer gameTimer = new GameTimer();
    Scoreboard gameScoreboard = new Scoreboard();

    public void start() throws IOException {
        gameTimer.startTimer();
        gameUI.showWelcomeMessage();
        int difficultyLevel = gameUI.getDifficultyLevel();
        processGuess(difficultyLevel);
        gameTimer.stopTimer();
    }

    public void processGuess(int difficultyLevel) throws IOException {
        int guess = gameUI.getUserGuess();
        int secretNumber = (int) (Math.random() * 100 + 1);
        int attempts = 0;
        int guessNumber = getGuessNumber(difficultyLevel);
        for(int i = 1; i < guessNumber; i++){
            if(guess == secretNumber) {
                System.out.printf("Congratulations! You guessed the correct number in %d attempts.%n", attempts);
                gameScoreboard.updateHighScore(difficultyLevel, attempts);
                break;
            } else {
                attempts++;
                System.out.println("Incorrect! The number is " + (guess > secretNumber ? "less" : "greater") + " than " + guess);
                guess = gameUI.getUserGuess();
            }
        }
    }

    private int getGuessNumber(int difficultyLevel) {
        return switch (difficultyLevel) {
            case 1 ->  10;
            case 2 -> 5;
            case 3 -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + difficultyLevel);
        };
    }
}
