package edu.austral.dissis.starship.model.GameObjects;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.controller.GameController;
import edu.austral.dissis.starship.model.Bullet;
import edu.austral.dissis.starship.model.Starship;
import edu.austral.dissis.starship.model.Weapon;
import edu.austral.dissis.starship.view.GameRenderer;

import static edu.austral.dissis.starship.constants.ShapeConstants.STARSHIP_HEIGHT;

public class DoubleWeapon extends Weapon {

    public DoubleWeapon(Bullet bullet) {
        super(bullet);
    }

    @Override
    public Bullet getBullet() {
        return super.getBullet();
    }

    @Override
    public void shoot(Starship starship) {
        if(shouldShoot()){
            Vector2 position1;
            Vector2 position2;
            if((int)starship.direction.getY() == 1) {
                position1 = Vector2.vector(starship.position.getX() - 10, starship.position.getY() + (float) STARSHIP_HEIGHT/2 + 10);
                position2 = Vector2.vector(starship.position.getX() + 10, starship.position.getY() + (float) STARSHIP_HEIGHT/2 + 10);
            }else{
                position1 = Vector2.vector(starship.position.getX() - 10, starship.position.getY() - (float) STARSHIP_HEIGHT/2 - 10);
                position2 = Vector2.vector(starship.position.getX() + 10, starship.position.getY() - (float) STARSHIP_HEIGHT/2 - 10);
            }
            Bullet bullet1 = getBullet().getNewBullet(position1, starship.direction);
            Bullet bullet2 = getBullet().getNewBullet(position2, starship.direction);
            GameRenderer.addToRender(bullet1);
            GameRenderer.addToRender(bullet2);
            GameController.addCollisionable(bullet1);
            GameController.addCollisionable(bullet2);
        }
        this.lastBullet = System.currentTimeMillis();
    }
}
