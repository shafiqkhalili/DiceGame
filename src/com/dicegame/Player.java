package com.dicegame;

import java.util.ArrayList;

public class Player {
    ArrayList<Dice> dices;
    private String name;
    private int score;

    public Player(ArrayList<Dice> dices, String name) {
        this.dices = dices;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public void rollDice(){

    }
    public int getDiceValue(){
        int totalDiceValue = 0;
        for (Dice d: dices
             ) {
            totalDiceValue += d.getCurrnetSide();
        }
        return totalDiceValue;
    }
    public void increaseScore(){
        this.score++;
    }
    public void addDice(){
        Dice dice = new Dice(6);
        this.dices.add(dice);
    }
}
