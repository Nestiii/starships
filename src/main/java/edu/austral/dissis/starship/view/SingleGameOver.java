package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.model.Player;
import processing.core.PGraphics;

public class SingleGameOver implements Rendereable{

    private final Player player;

    public SingleGameOver(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }
}
