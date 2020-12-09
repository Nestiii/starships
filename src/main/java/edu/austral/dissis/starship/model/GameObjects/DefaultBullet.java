package edu.austral.dissis.starship.model.GameObjects;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.model.Bullet;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

import static edu.austral.dissis.starship.constants.MoveConstants.DEFAULT_BULLET_SPEED;
import static edu.austral.dissis.starship.constants.StatsConstants.*;

public class DefaultBullet extends Bullet {

    public DefaultBullet(Vector2 position, Vector2 direction, Player player) {
        super(position, direction, BULLET_HP, DEFAULT_BULLET_DMG, DEFAULT_BULLET_SPEED, player);
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
