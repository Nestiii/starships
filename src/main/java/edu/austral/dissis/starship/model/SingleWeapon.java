package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.controller.GameController;
import edu.austral.dissis.starship.view.GameRenderer;
import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public class SingleWeapon extends Weapon{

    public SingleWeapon(Bullet bullet, int shootInterval) {
        super(bullet, shootInterval);
    }

    @Override
    public Bullet getBullet() {
        return super.getBullet();
    }

    @Override
    public void shoot(Starship starship) {
        Vector2 position = Vector2.vector(starship.position.getX(), starship.position.getY() - (float) STARSHIP_HEIGHT/2);
        Bullet bullet = getBullet().getNewBullet(position, starship.direction);
        GameRenderer.addToRender(bullet);
        GameController.addCollisionable(bullet);
    }
}
