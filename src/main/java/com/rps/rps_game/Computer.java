package com.rps.rps_game;

import java.util.Random;

public class Computer implements Player {

    private static final Random moveGenerator = new Random();
    private static final String name = "Komputer";
    private int numberOfPoints = 0;
    private int drawLimit;

    public Computer(int drawLimit) {
        this.drawLimit = drawLimit;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addPoint(){
        numberOfPoints++;
    }

    @Override
    public void setPoints(int points) {
        numberOfPoints = points;
    }

    @Override
    public int getPoints() {
        return numberOfPoints;
    }

    @Override
    public String gamersMove() {
        return String.valueOf(moveGenerator.nextInt(drawLimit) + 1);
    }
}
