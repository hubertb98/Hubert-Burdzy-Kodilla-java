package com.kodilla.rps;

public class GameRulesOld {
    /*1-rock
    2-paper
    3-scissors
    4-spock
    5-lizard*/
    String computerPlay;
    String humanPlay;
    boolean end = false;
    Human human = new Human();
    Computer computer = new Computer();
    InputOutput inOut = new InputOutput();

    public void vs() {
        System.out.println(humanPlay + " vs " + computerPlay);
    }

    public int whoWin(int computerMove, int humanMove) {
        if (computerMove == 1) {
            computerPlay = "Rock";
        } else if (computerMove == 2) {
            computerPlay = "Paper";
        } else if (computerMove == 3) {
            computerPlay = "Scissors";
        } else if (computerMove == 4) {
            computerPlay = "Spock";
        } else if (computerMove == 5) {
            computerPlay = "Lizard";
        }

        if (humanMove == 1) {
            humanPlay = "Rock";
        } else if (humanMove == 2) {
            humanPlay = "Paper";
        } else if (humanMove == 3) {
            humanPlay = "Scissors";
        } else if (humanMove == 4) {
            humanPlay = "Spock";
        } else if (humanMove == 5) {
            humanPlay = "Lizard";
        }

        if (computerMove == 1) {
            if (humanMove == 1) {
                vs();
                return 0; // Remis
            } else if (humanMove == 2 || humanMove == 4) {
                vs();
                return 2; //human
            } else if (humanMove == 3 || humanMove == 5) {
                vs();
                return 1; //Computer
            }
        }

        if (computerMove == 2) {
            if (humanMove == 1 || humanMove == 4) {
                vs();
                return 1; //Computer
            } else if (humanMove == 2) {
                vs();
                return 0; //remis
            } else if (humanMove == 3 || humanMove == 5) {
                vs();
                return 2; // human
            }
        }

        if (computerMove == 3) {
            if (humanMove == 1 || humanMove == 4) {
                vs();
                return 2; //human
            } else if (humanMove == 2 || humanMove == 5) {
                vs();
                return 1; //Computer
            } else if (humanMove == 3) {
                vs();
                return 0; // Remis
            }
        }

        if (computerMove == 4) { // Spock
            if (humanMove == 1 || humanMove == 3) {
                vs();
                return 1; //comp
            } else if (humanMove == 2 || humanMove == 5) {
                vs();
                return 2; //human
            } else if (humanMove == 4) { // spock
                vs();
                return 0; // Remis
            }
        }

        if (computerMove == 5) { //Lizard
            if (humanMove == 1 || humanMove == 3) { // rock
                vs();
                return 2; //human
            } else if (humanMove == 2 || humanMove == 4) { //paper
                vs();
                return 1; //Computer
            } else if (humanMove == 5) { //lizard
                vs();
                return 0; // Remis
            }
        }
        return 0;
    }

    public void newGame() {
        System.out.println("\nEnter 'n' if you want to play new game. " +
                "Enter 'x' if you want to quit");
        if (inOut.getStringInput().equals("x")) {
            System.exit(0);
        } else if (inOut.getStringInput().equals("n")) {
            end = false;
            game();
        }
    }

    public void game() {
        System.out.println("Hey, let's play Rock, Paper, Scissors!");
        System.out.print("Enter the number of points to win: ");
        int winnerPoints = inOut.getIntInput();
        System.out.println("---------------------------------" +
                "\nRock = 1, Paper = 2, Scissors = 3, Spock = 4, Lizard = 5" +
                "\n---------------------------------");
        System.out.println("Please enter a move.");

        while (!end) {
            int humanMove = human.getMove();
            int computerMove = computer.getMove();
            int winner = whoWin(computerMove, humanMove);
            if (winner == 0) {
                tie();
            } else if (winner == 1) {
                lose();
            } else if (winner == 2) {
                win();
            }

            if (human.getPoints() >= winnerPoints || computer.getPoints() >= winnerPoints) {
                end = true;
                newGame();
            }
        }
    }

    public void seePoints() {
        System.out.println("Your points: " + human.getPoints() +
                " | " + "computer points: " + computer.getPoints());

    }

    public void tie() {
        System.out.println("It's a Tie!");
        seePoints();
    }

    public void lose() {
        System.out.println("You lose!");
        computer.addPoints();
        seePoints();
    }

    public void win() {
        System.out.println("You win!");
        human.addPoints();
        seePoints();
    }
}
