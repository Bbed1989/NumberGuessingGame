package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameUI {

    private final Scanner scanner = new Scanner(System.in);
    public void showWelcomeMessage(){
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)");
    }

    public int getDifficultyLevel() {
        int difficultyLevel = getChoice();
        displayLevel(difficultyLevel);
        return difficultyLevel;
    }

    public int getUserGuess() {
        while (true) {
            System.out.print("Enter your guess: ");
            try {
                return scanner.nextInt(); // Return valid input immediately
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
            }
        }
    }


    private void displayLevel(int difficultyLevel) {
        switch (difficultyLevel) {
            case 1:
                System.out.println("You chose Easy difficulty level.");
                break;
            case 2:
                System.out.println("You chose Medium difficulty level.");
                break;
            case 3:
                System.out.println("You chose Hard difficulty level.");
                break;
        }
        System.out.println("Let's start the game!");
    }

    private int getChoice(){
        int difficultyLevel = 0;
        do {
            System.out.println("Enter your choice: ");
            try {
                difficultyLevel = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.nextLine(); // Consume the invalid input
            }
        } while (difficultyLevel <= 0 || difficultyLevel > 3);
        return difficultyLevel;
    }
}
