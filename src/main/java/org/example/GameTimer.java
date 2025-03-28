package org.example;
import java.time.Duration;
import java.time.Instant;

public class GameTimer {
    private Instant startTime;

    public void startTimer() {
        startTime = Instant.now();
    }

    public void stopTimer() {
        Duration elapsedTime = Duration.between(startTime, Instant.now());
        System.out.println("You took " + elapsedTime.toSeconds() + " seconds.");
    }
}
