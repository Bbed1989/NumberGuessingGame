package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Please select the difficulty level:\n" +
                "1. Easy (10 chances)\n" +
                "2. Medium (5 chances)\n" +
                "3. Hard (3 chances)");
        Game game = new Game();
        game.start(); // Call the start method of the Game class

    }
}