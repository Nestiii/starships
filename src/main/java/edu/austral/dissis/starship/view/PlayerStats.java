package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.model.Player;
import edu.austral.dissis.starship.model.Starship;
import processing.core.PGraphics;

public class PlayerStats implements Rendereable{

    final Starship starship;
    final Player player;

    public PlayerStats (Starship starship, Player player){
        this.starship = starship;
        this.player = player;
    }

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics,this);
    }
}
