package com.rps.rps_game;

public interface Player {
    String getName();

    void addPoint();

     int getPoints();

     void setPoints(int points);

     String gamersMove();
}
