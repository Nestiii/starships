package edu.austral.dissis.starship.model.GameObjects;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.controller.GameController;
import edu.austral.dissis.starship.model.Bullet;
import edu.austral.dissis.starship.model.Starship;
import edu.austral.dissis.starship.model.Weapon;
import edu.austral.dissis.starship.view.GameRenderer;
import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public class SingleWeapon extends Weapon {

    public SingleWeapon(Bullet bullet) {
        super(bullet);
    }

    @Override
    public Bullet getBullet() {
        return super.getBullet();
    }

    @Override
    public void shoot(Starship starship) {
        if(shouldShoot()){
            Vector2 position;
            if((int)starship.direction.getY() == 1) {
                position = Vector2.vector(starship.position.getX(), starship.position.getY() + (float) STARSHIP_HEIGHT/2 + 10);
            }else{
                position = Vector2.vector(starship.position.getX(), starship.position.getY() - (float) STARSHIP_HEIGHT/2 - 10);
            }
            Bullet bullet = getBullet().getNewBullet(position, starship.direction);
            GameRenderer.addToRender(bullet);
            GameController.addCollisionable(bullet);
        }
        this.lastBullet = System.currentTimeMillis();
    }
}
