package com.dicegame;

import java.util.Random;

public class Dice {
    private static Random randomGenerator;
    private int nrOfSides;
    private int currentSide;

    public Dice(int nrOfSides) {
        this.nrOfSides = nrOfSides;
        randomGenerator = new Random();
    }

    public int getNrOfSides() {
        return nrOfSides;
    }

    public void setNrOfSides(int nrOfSides) {
        this.nrOfSides = nrOfSides;
    }

    public int getCurrentSide() {
        return currentSide;
    }

    public void setCurrentSide(int currentSide) {
        this.currentSide = currentSide;
    }

    public void roll() {

        currentSide = randomGenerator.nextInt(nrOfSides) + 1;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "nrOfSides=" + nrOfSides +
                ", currentSide=" + currentSide +
                '}';
    }
}
