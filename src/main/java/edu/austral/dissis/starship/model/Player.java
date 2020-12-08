package edu.austral.dissis.starship.model;

public class Player {

    final String name;
    private int points;

    public Player(String name, int points){
        this.name = name;
        this.points = points;
    }

    public void updatePoints(int points){
        this.points+=points;
    }
}
