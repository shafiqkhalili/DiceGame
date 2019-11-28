package com.dicegame;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleDiceGame {
    public static void main(String[] args) {

        ArrayList<Player> players = initialize();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Round " + i);
            takeTurn(players);
        }
        System.out.println("Winner/s is/are :"+getWinners(players));

    }

    private static ArrayList<Player> initialize() {
        ArrayList<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Write number of players!");
        int nrOfPlayer = sc.nextInt();
        System.out.println("How many dices a player has?");
        int nrOfDices = sc.nextInt();
        System.out.println("How many sides a dice should have?");
        int nrOfSides = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= nrOfPlayer; i++) {
            System.out.println("Write name of player " + i);
            String name = sc.nextLine();
            Player player = new Player(name);
            for (int j = 0; j < nrOfDices; j++) {
                player.addDice(nrOfSides);
            }
            players.add(player);
        }
        return players;
    }

    private static void takeTurn(ArrayList<Player> players) {
        Scanner sc = new Scanner(System.in);
        for (Player p : players) {
            p.rollDice();
            System.out.println("Player " + p.getName() + " is playing...");
            System.out.println("Guess a number between "+p.getLowestPossibleValue()+"-"
                    + p.getHighestPossibleValue());
            int input = sc.nextInt();
            if (input == p.getTotalDiceValue()) {
                System.out.println("Correct!");
                p.increaseScore();
            }
            else{
                System.out.println("Wrong!");
            }
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();

        int Highest=0;
        for (Player p : players) {
            if(p.getScore() > Highest){
                Highest = p.getScore();
            }
        }
        for (Player p : players) {
            if(p.getScore() == Highest){
                winners.add(p);
            }
        }
        return winners;
    }
}
