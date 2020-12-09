package edu.austral.dissis.starship.view.UI;

import edu.austral.dissis.starship.model.GameObjects.Player;
import edu.austral.dissis.starship.view.Rendereable;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

public class MultipleGameOver implements Rendereable {

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
