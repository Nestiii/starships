package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.controller.GameController;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

import static edu.austral.dissis.starship.constants.MoveConstants.BIG_ASTEROID_SPEED;
import static edu.austral.dissis.starship.constants.ShapeConstants.*;
import static edu.austral.dissis.starship.constants.StatsConstants.*;

public class BigAsteroid extends Asteroid{

    public BigAsteroid(Vector2 position, Vector2 direction){
        super(
                position,
                direction,
                BIG_ASTEROID_HP,
                BIG_ASTEROID_SPEED,
                BIG_ASTEROID_WIDTH,
                BIG_ASTEROID_HEIGHT,
                BIG_ASTEROID_DMG
        );
    }

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }
}
