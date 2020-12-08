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

    GameObject (Vector2 position, Vector2 direction, int healthPoints){
        this.position = position;
        this.direction = direction;
        this.healthPoints = healthPoints;
    }

    public abstract void collisionedWithStarship(Starship starship);

    public Vector2 getPosition(){
        return position;
    }

    public Vector2 getDirection(){
        return direction;
    }

    public int getHealthPoints(){
        return healthPoints;
    }
}
