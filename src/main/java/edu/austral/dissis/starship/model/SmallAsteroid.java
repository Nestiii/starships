package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

import static edu.austral.dissis.starship.constants.StatsConstants.*;
import static edu.austral.dissis.starship.constants.MoveConstants.*;
import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public class SmallAsteroid extends Asteroid{

    public SmallAsteroid(Vector2 position, Vector2 direction){
        super(
                position,
                direction,
                SMALL_ASTEROID_HP,
                SMALL_ASTEROID_SPEED,
                SMALL_ASTEROID_WIDTH,
                SMALL_ASTEROID_HEIGHT,
                SMALL_ASTEROID_DMG
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
