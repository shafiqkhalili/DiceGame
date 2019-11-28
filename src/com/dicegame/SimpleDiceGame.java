package com.dicegame;

import java.util.List;
import java.util.Scanner;

public class SimpleDiceGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write number of players!");
        int nrOfPlayer = sc.nextInt();
        System.out.println("How many dices a player has?");
        int nrOfDices = sc.nextInt();
        System.out.println("How many sides a dice should have?");
        int nrOfSides = sc.nextInt();
        for (int i = 1;i <= nrOfPlayer;i++){
            System.out.println("Write name of player " +i);
            String name = sc.nextLine();
            Player player = new Player(name);

        }

    }
}
