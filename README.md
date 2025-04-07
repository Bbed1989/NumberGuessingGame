# 🎯 Number Guessing Game (CLI, Java)

A simple Command-Line Number Guessing Game written in Java. The computer randomly selects a number between 1 and 100, and the player tries to guess it within a limited number of attempts based on the chosen difficulty level.
https://roadmap.sh/projects/number-guessing-game

---

## 📋 Features

- Selectable difficulty levels (Easy / Medium / Hard)
- Clear feedback after each guess (too high / too low)
- Tracks high scores (lowest attempts per level)
- Allows multiple rounds
- Tracks time taken to guess correctly
- Optional hints (can be extended)

---

## 🕹️ How to Play

1. Launch the program.
2. Choose your difficulty:
   - Easy (10 chances)
   - Medium (5 chances)
   - Hard (3 chances)
3. Enter guesses to try to find the secret number.
4. Receive hints whether the secret number is higher or lower.
5. Win if you guess correctly within the allowed chances.
6. After each round, choose whether to play again.

---

## 📂 Project Structure

```plaintext
src/
├── Game.java            # Core game logic
├── GameUI.java          # CLI interaction and messages
├── ScoreManager.java    # High score handling (read/write)
├── Timer.java           # Timer to measure guessing duration
├── Utils.java           # Helper functions (input handling, etc.)
└── Main.java            # Entry point
▶️ How to Run
Requirements:
Java 17+ (or compatible version)

Compile:
bash
javac src/*.java
Run:
bash
java -cp src Main
🗃️ High Scores
High scores are stored in a simple file (e.g., scores.json or scores.txt) that tracks:

Difficulty level

Minimum number of attempts

📈 Future Improvements
Save multiple user scores with names

Add a hint system (e.g., narrow down range)

GUI version

Multiplayer mode

🛠️ Author
Created by Bohdan Bedrii
🎖️ Built as a Java practice project

📄 License
MIT License. Feel free to use and modify.
