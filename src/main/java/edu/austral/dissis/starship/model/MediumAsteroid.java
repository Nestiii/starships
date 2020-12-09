package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

import static edu.austral.dissis.starship.constants.MoveConstants.MEDIUM_ASTEROID_SPEED;
import static edu.austral.dissis.starship.constants.ShapeConstants.*;
import static edu.austral.dissis.starship.constants.StatsConstants.*;

public class MediumAsteroid extends Asteroid{

    public MediumAsteroid(Vector2 position, Vector2 direction){
        super(
                position,
                direction,
                MEDIUM_ASTEROID_HP,
                MEDIUM_ASTEROID_SPEED,
                MEDIUM_ASTEROID_WIDTH,
                MEDIUM_ASTEROID_HEIGHT,
                MEDIUM_ASTEROID_DMG
        );
    }

    @Override
    public void collisionedWithStarship(Starship starship) {}

    @Override
    public void collisionedWith(GameObject collisionable) {}

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }
}
