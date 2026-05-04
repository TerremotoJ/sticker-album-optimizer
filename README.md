# Sticker Album Trade Optimizer

A Java application that simulates a trading card/sticker album ecosystem. The program calculates and optimizes trades between a user and their friends to maximize the completion of the user's collection.

## Features

- **Automated Trade Optimization:** Sorts potential trades such that the friend with the highest number of mutually beneficial trades is prioritized first.
- **Deduplication and Validation:** Tracks multiple duplicates of stickers (e.g., country code + ID) and dynamically assigns "send" and "receive" flags.
- **Encapsulated Design:** Employs Object-Oriented best practices with clear separation between `Album`, `Sticker`, `Trade`, and `Compare` entities.
- **Robust Test Coverage:** Validated with 9 comprehensive JUnit 5 tests confirming output generation, file parsing, and core logic against different datasets.

## System Architecture

The application is modularized into several core entities:
*   **`App`**: Main entry point handling CLI logic and orchestrating the file I/O operations.
*   **`Album`**: Represents a user's or friend's entire collection of stickers.
*   **`Sticker`**: Represents an individual collectible, storing the country identifier, serial number, duplicate count, and pending trade flags.
*   **`Trade`**: Handles the execution and prioritization of trades, guaranteeing that high-yield friends trade first.
*   **`Compare`**: Evaluates two albums to identify which stickers can be mutually exchanged based on available duplicates.

## Setup and Usage

The project is built natively using `javac` and requires no external build tools.

### 1. Compilation
Navigate to the `src/` directory and compile the Java files:
```bash
cd src
javac *.java
```

### 2. Execution
Run the application (from within the `src/` directory) and observe the optimized trade execution:
```bash
java App
```
*(By default, the application reads from `data/input1.txt` but can be configured dynamically within `App.java`)*

### 3. Running the Test Suite (TDD)
The project adheres to Test-Driven Development (TDD). A standalone JUnit 5 console runner is included in the `lib/` directory.

To run the full test suite:
```bash
# Compile everything including the tests
javac -cp ".;..\lib\junit-platform-console-standalone-1.9.2.jar" *.java

# Execute JUnit
java -jar "..\lib\junit-platform-console-standalone-1.9.2.jar" --class-path . --scan-classpath
```
