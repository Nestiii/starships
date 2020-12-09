package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.model.Player;
import edu.austral.dissis.starship.model.Starship;
import processing.core.PGraphics;

public class PlayerStats implements Rendereable{

    final Starship starship;
    final Player player;
    final Vector2 position;

    public PlayerStats (Starship starship, Player player, Vector2 position){
        this.starship = starship;
        this.player = player;
        this.position = position;
    }

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics,this);
    }
}
