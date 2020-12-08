package edu.austral.dissis.starship.controller;

import edu.austral.dissis.starship.base.collision.CollisionEngine;
import edu.austral.dissis.starship.base.collision.Collisionable;
import edu.austral.dissis.starship.model.Bullet;
import edu.austral.dissis.starship.model.GameObject;
import edu.austral.dissis.starship.view.GameRenderer;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final CollisionEngine collisionEngine = new CollisionEngine();
    private static final List<Collisionable<GameObject>> collisionables = new ArrayList<>();

    public static void addCollisionable(Collisionable<GameObject> collisionable){
        collisionables.add(collisionable);
    }

    public static void removeCollisionable(Collisionable<GameObject> collisionable){
        collisionables.remove(collisionable);
    }

    public static void updateCollisionables(){
        for (Collisionable<GameObject> collisionable : collisionables) {
            checkOutOfBounds(collisionable);
            if (collisionable instanceof Bullet){
                ((Bullet) collisionable).moveForward(((Bullet) collisionable).getSpeed());
            }
        }
    }

    private static void checkOutOfBounds(Collisionable<GameObject> collisionable){
        GameObject gameObject = ((GameObject) collisionable);
        boolean x = gameObject.getPosition().getX() <= MAP_WIDTH && gameObject.getPosition().getX() >= 0;
        boolean y = gameObject.getPosition().getY() <= MAP_HEIGHT && gameObject.getPosition().getY() >= 0;
        if(!x && !y) {
            GameRenderer.removeToRender(gameObject);
            removeCollisionable(gameObject);
        }
    }
}
