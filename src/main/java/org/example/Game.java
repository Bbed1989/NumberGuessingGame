package org.example;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);


    public void start() {
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
    }
}
