package edu.austral.dissis.starship.view.UI;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.model.GameObjects.Player;
import edu.austral.dissis.starship.model.Starship;
import edu.austral.dissis.starship.view.Rendereable;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

public class PlayerStats implements Rendereable {

    public final Starship starship;
    public final Player player;
    public final Vector2 position;

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
