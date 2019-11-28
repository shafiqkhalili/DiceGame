package com.dicegame;

import java.util.ArrayList;

public class Player {
    ArrayList<Dice> dices;
    private String name;
    private int score;



    public Player(String name) {
        this.name = name;
        dices = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
    public void rollDice(){
        for (Dice d:dices) {
            d.roll();
        }
    }
    public int totalPossibleValue(){
        int totalDiceValue = 0;
        for (Dice d: dices) {
            totalDiceValue += d.getNrOfSides();
        }
        return totalDiceValue;
    }
    //?????
    public int getTotalDiceValue(){
        int totalDiceValue = 0;
        for (Dice d: dices) {
            totalDiceValue += d.getCurrentSide();
        }
        return totalDiceValue;
    }
    public void increaseScore(){
        this.score++;
    }
    public void addDice(int nrOfSides){
        Dice dice = new Dice(nrOfSides);
        this.dices.add(dice);
    }

    @Override
    public String toString() {
        return "Player{" +
                "dices=" + dices +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
