package edu.austral.dissis.starship.model;

public class Player {

    final String name;
    private int points;

    public Player(String name){
        this.name = name;
        points = 0;
    }

    public void updatePoints(int points){
        this.points+=points;
    }

    public int getPoints(){
        return points;
    }

    public String getName() {
        return name;
    }
}
