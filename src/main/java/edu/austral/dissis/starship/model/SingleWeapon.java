package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.controller.GameController;
import edu.austral.dissis.starship.view.GameRenderer;

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
        Bullet bullet = getBullet().getNewBullet(starship.position, starship.direction);
        GameRenderer.addToRender(bullet);
        GameController.addCollisionable(bullet);
    }
}
