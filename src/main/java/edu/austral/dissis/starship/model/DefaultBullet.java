package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

import static edu.austral.dissis.starship.constants.MoveConstants.LASER_BULLET_SPEED;
import static edu.austral.dissis.starship.constants.StatsConstants.BULLET_HP;
import static edu.austral.dissis.starship.constants.StatsConstants.LASER_BULLET_DMG;

public class DefaultBullet extends Bullet{

    public DefaultBullet(Vector2 position, Vector2 direction, Player player) {
        super(position, direction, BULLET_HP, LASER_BULLET_DMG, LASER_BULLET_SPEED, player);
    }

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }

    @Override
    public Bullet getNewBullet(Vector2 position, Vector2 direction) {
        return new DefaultBullet(position, direction, this.player);
    }
}
