package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.model.Player;
import processing.core.PGraphics;

public class MultipleGameOver implements Rendereable{

    private final Player playerA;
    private final Player playerB;

    public MultipleGameOver(Player playerA, Player playerB){
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }
}
