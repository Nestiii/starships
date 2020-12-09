package edu.austral.dissis.starship.view.UI;

import edu.austral.dissis.starship.model.GameObjects.Player;
import edu.austral.dissis.starship.view.Rendereable;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

public class SingleGameOver implements Rendereable {

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
