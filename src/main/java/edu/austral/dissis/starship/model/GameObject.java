package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.collision.Collisionable;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.view.Rendereable;

import java.awt.*;

public abstract class GameObject implements Movable<GameObject>, Collisionable<GameObject>, Rendereable {

    Vector2 position;
    Vector2 direction;
    int healthPoints;
    Shape shape;
    float speed;

    GameObject (Vector2 position, Vector2 direction, int healthPoints){
        this.position = position;
        this.direction = direction;
        this.healthPoints = healthPoints;
    }

    public abstract void collisionedWithStarship(Starship starship);

    public abstract void collisionedWithBullet(Bullet bullet);

    public abstract void collisionedWithAsteroid(Asteroid asteroid);

    public Vector2 getPosition(){
        return position;
    }

    public Vector2 getDirection(){
        return direction;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public void updateHealth(int healthPoints){
        this.healthPoints = healthPoints;
    }

    public float getSpeed() { return speed; }
}
