package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

import static edu.austral.dissis.starship.constants.StatsConstants.*;
import static edu.austral.dissis.starship.constants.MoveConstants.*;

public class LaserBullet extends Bullet{

    LaserBullet(Vector2 position, Vector2 direction, int healthPoints) {
        super(position, direction, LASER_BULLET_HP, LASER_BULLET_DMG, LASER_BULLET_SPEED);
    }

    LaserBullet(Vector2 position, Vector2 direction) {
        super(position, direction, LASER_BULLET_HP, LASER_BULLET_DMG, LASER_BULLET_SPEED);
    }

    @Override
    public void collisionedWith(GameObject collisionable) {}

    @Override
    public void collisionedWithStarship(Starship starship) {}

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }

    @Override
    public Bullet getNewBullet(Vector2 position, Vector2 direction) {
        return new LaserBullet(position, direction);
    }
}
