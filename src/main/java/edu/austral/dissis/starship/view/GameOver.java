package edu.austral.dissis.starship.view;

import processing.core.PGraphics;

public class GameOver implements Rendereable{

    private final int points;

    public GameOver(int points){
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }
}
