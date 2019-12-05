package com.dicegame;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDiceGame {
    public static void main(String[] args) throws Exception {

        ArrayList<Player> players = initialize();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Round " + i);
            takeTurn(players);
        }
        System.out.println("Winner/s is/are :" + getWinners(players));

    }

    private static ArrayList<Player> initialize() throws Exception {

        ArrayList<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int nrOfPlayer = 0;
        while (nrOfPlayer == 0) {
            try {
                System.out.println("Write number of players!");
                String input = sc.nextLine();
                nrOfPlayer = Integer.parseInt(input);
                if (nrOfPlayer < 0) {
                    System.out.println("Nr cannot be negative");
                    nrOfPlayer = 0;
                }
            } catch (Exception e) {
                nrOfPlayer = 0;
                System.out.println("Wrong input");
            }
        }

        int nrOfDices = 0;
        while (nrOfDices == 0) {
            try {
                System.out.println("How many dices a player has?");
                nrOfDices = Integer.parseInt(sc.nextLine());
                if (nrOfDices < 0) {
                    System.out.println("Nr cannot be negative");
                    nrOfDices = 0;
                }
            } catch (Exception e) {
                System.out.println("Wrong input");
                nrOfDices = 0;
            }
        }

        int nrOfSides = 0;
        while (nrOfSides == 0) {
            try {
                System.out.println("How many sides a dice should have?");
                nrOfSides = Integer.parseInt(sc.nextLine());
                if (nrOfSides < 0) {
                    System.out.println("Nr cannot be negative");
                    nrOfSides = 0;
                }
            } catch (Exception e) {
                System.out.println("Wrong input");
                nrOfSides = 0;
            }
        }

        try {
            for (int i = 1; i <= nrOfPlayer; i++) {

                String name = "";
                System.out.println("Write name of player " + i);
                while (name.length() == 0) {
                    name = sc.nextLine();
                    if (name.length() < 0)
                        System.out.println("Name cannot be empty");
                }
                Player player = new Player(name);
                for (int j = 0; j < nrOfDices; j++) {
                    player.addDice(nrOfSides);
                }
                players.add(player);
            }
        } catch (NegativeArraySizeException e) {
            e.printStackTrace();
        }
        return players;
    }

    private static void takeTurn(ArrayList<Player> players) {
        Scanner sc = new Scanner(System.in);
        for (Player p : players) {
            p.rollDice();
            System.out.println("Player " + p.getName() + " is playing...");

            int input = 0;
            while (input == 0) {
                try {
                    System.out.println("Guess a number between " + p.getLowestPossibleValue() + "-"
                            + p.getHighestPossibleValue());
                    input = Integer.parseInt(sc.nextLine());
                    if (input < 0) {
                        System.out.println("Nr cannot be negative");
                        input = 0;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input");
                    input = 0;
                }
            }
            if (input == p.getTotalDiceValue()) {
                System.out.println("Correct guess!");
                p.increaseScore();
            } else {
                System.out.println("Wrong guess!");
            }
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();

        int Highest = 0;
        for (Player p : players) {
            if (p.getScore() > Highest) {
                Highest = p.getScore();
            }
        }
        for (Player p : players) {
            if (p.getScore() == Highest) {
                winners.add(p);
            }
        }
        return winners;
    }
}
