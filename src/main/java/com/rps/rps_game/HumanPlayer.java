package com.rps.rps_game;

public class HumanPlayer implements Player{

    private int numberOfPoints = 0;
    private String name;

    public HumanPlayer(String name) {
        this.name = name;
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
        return Input.move();
    }
}
