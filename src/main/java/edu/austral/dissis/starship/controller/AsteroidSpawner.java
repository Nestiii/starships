package edu.austral.dissis.starship.controller;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.model.Asteroid;
import edu.austral.dissis.starship.model.BigAsteroid;
import edu.austral.dissis.starship.model.MediumAsteroid;
import edu.austral.dissis.starship.model.SmallAsteroid;
import edu.austral.dissis.starship.view.GameRenderer;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

import java.util.Random;

public class AsteroidSpawner {

    private final Random random = new Random();

    public long spawnAsteroid(){
        Vector2 position, direction;
        int side = random.nextInt(4);
        switch (side){
            case 0:
                position = Vector2.vector(random.nextInt(MAP_WIDTH), MAP_HEIGHT);
                direction = Vector2.vector(0, -1);
                break;
            case 1:
                position = Vector2.vector(MAP_WIDTH, random.nextInt(MAP_HEIGHT));
                direction = Vector2.vector(-1, 0);
                break;
            case 2:
                position = Vector2.vector(random.nextInt(MAP_WIDTH), 0);
                direction = Vector2.vector(0, 1);
                break;
            default:
                position = Vector2.vector(0, random.nextInt(MAP_HEIGHT));
                direction = Vector2.vector(1, 0);
                break;
        }
        int asteroidType = random.nextInt(3);
        switch (asteroidType){
            case 0:
                spawn(new SmallAsteroid(position, direction));
                break;
            case 1:
                spawn(new MediumAsteroid(position, direction));
                break;
            case 2:
                spawn(new BigAsteroid(position, direction));
                break;
        }
        return System.currentTimeMillis();
    }

    private void spawn(Asteroid asteroid){
        GameController.addCollisionable(asteroid);
        GameRenderer.addToRender(asteroid);
    }
}
