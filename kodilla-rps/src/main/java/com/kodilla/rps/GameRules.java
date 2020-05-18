package com.kodilla.rps;

public class GameRules {
//    1 - rock
//    2 - paper
//    3 - scissors
//    4 - spock
//    5 - lizard
    String computerPlay, humanPlay;
    boolean end = false;
    Human human = new Human();
    Computer computer = new Computer();
    InputOutput inOut = new InputOutput();



    public int whoWin(int computerMove, int humanMove) {
        if(computerMove == 1) {
            computerPlay = "Rock";
        } else if (computerMove == 2) {
            computerPlay = "Paper";
        } else if (computerMove == 3) {
            computerPlay = "Scissors";
        }

        if(humanMove == 1) {
            humanPlay = "Rock";
        } else if (humanMove == 2) {
            humanPlay = "Paper";
        } else if (humanMove == 3) {
            humanPlay = "Scissors";
        }

        if (computerMove == 1) {
            if (humanMove == 1) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 0; // Remis
            } else if(humanMove == 2) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 2; //human
            } else if (humanMove == 3) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 1; //Computer
            }
        }

        if (computerMove == 2) {
            if (humanMove == 1) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 1; //Computer
            } else if(humanMove == 2) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 0; //remis
            } else if (humanMove == 3) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 2; // human
            }
        }

        if (computerMove == 3) {
            if (humanMove == 1) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 2; //human
            } else if(humanMove == 2) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 1; //Computer
            } else if (humanMove == 3) {
                System.out.println(computerPlay + " vs " + humanPlay);
                return 0; // Remis
            }
        }
        return 0;
    }

    public void newGame() {
        System.out.println("\nEnter 'n' if you want to play new game. " +
                "Enter 'x' if you want to quit");
        if(inOut.getStringInput().equals("n")) {
            System.out.println();
            end = false;

            game();
        } else if (inOut.getStringInput().equals("x")) {
            System.out.println("Are you sure you want to quit?");
            System.exit(0);
        }
    }

    public void game() {
        System.out.println("Hey, let's play Rock, Paper, Scissors!");
        System.out.print("Enter the number of points to win: ");
        int winnerPoints = inOut.getIntInput();
        System.out.println("Please enter a move.\n" + "---------------------------------" +
                "\nRock = 1, Paper" + "= 2, Scissors = 3" + "\n---------------------------------");


        while (!end) {
        int humanMove = human.getMove();
        int computerMove = computer.getMove();
        int winner = whoWin(computerMove, humanMove);
            if(winner == 0) {
                tie();
            } else if (winner == 1) {
                lose();
            } else if (winner == 2) {
                win();
            }

            if(human.getPoints() >= winnerPoints || computer.getPoints() >= winnerPoints) {
                end = true;
                newGame();
            }
        }
    }

    public void tie() {
        System.out.println("It's a Tie!");
        System.out.println("Your points: " + human.getPoints() +
                " | " + "computer points: " + computer.getPoints());
    }

    public void lose() {
        System.out.println("You lose!");
        computer.addPoints();
        System.out.println("Your points: " + human.getPoints() +
                " | " + "computer points: " + computer.getPoints());
    }

    public void win() {
        System.out.println("You win!");
        human.addPoints();
        System.out.println("Your points: " + human.getPoints() +
                " | " + "computer points: " + computer.getPoints());
    }
}
