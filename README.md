# mastermind-cli-game

## Overview

This is a simple numeric version of the classic [Mastermind](https://en.wikipedia.org/wiki/Mastermind_(board_game)) game, playable through command line interface in English or in Italian.

The game's goal is to guess a randomly generated sequence of numbers, with a limited amount of possible tries.
After each guess the player will be informed about the number of guessed digits, and how many of them are in the exact position.

The game has 3 difficulty modes:
- Normal (sequence of 4 digits, 12 attempts)
- Advanced (sequence of 6 digits, 18 attempts)
- Difficult (sequence of 8 digits, 24 attempts)

The player can also choose whether to allow repetitions of the same number inside the sequence.



## Requirements

- Java 1.8 or higher
- Maven

The Maven build creates a runnable .jar, to be run without command line arguments.

