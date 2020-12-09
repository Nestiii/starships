package edu.austral.dissis.starship.controller;

import edu.austral.dissis.starship.base.collision.CollisionEngine;
import edu.austral.dissis.starship.base.collision.Collisionable;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.model.*;
import edu.austral.dissis.starship.view.GameRenderer;
import edu.austral.dissis.starship.view.PlayerStats;
import edu.austral.dissis.starship.view.Rendereable;

import static edu.austral.dissis.starship.constants.ControllerConstants.KET_SET_A;
import static edu.austral.dissis.starship.constants.ShapeConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameController{

    private static final CollisionEngine collisionEngine = new CollisionEngine();
    private final AsteroidSpawner asteroidSpawner = new AsteroidSpawner();
    private long lastAsteroid = 0;
    private static final List<Collisionable<GameObject>> collisionables = new ArrayList<>();
    private static final List<Collisionable<GameObject>> toRemoveCollisionables = new ArrayList<>();
    private final PlayerController playerAController;
    public boolean gameOver;

    public GameController(){
        gameOver = false;
        Player playerA = new Player("Player A");
        Starship starshipA = new Starship(Vector2.vector(400, 400), Vector2.vector(0, -1), playerA);
        PlayerStats playerStatsA = new PlayerStats(starshipA, playerA);
        GameRenderer.addToRender(playerStatsA);
        GameRenderer.addToRender(starshipA);
        addCollisionable(starshipA);
        playerAController = new PlayerController(KET_SET_A, playerA, starshipA);
    }

    public void handleKeyPress(Set<Integer> keySet){
        keySet.forEach(playerAController::handleKeyPress);
    }

    public static void addCollisionable(Collisionable<GameObject> collisionable){
        collisionables.add(collisionable);
    }

    public static void updateCollisionables(){
        for (Collisionable<GameObject> collisionable : collisionables) {
            if (collisionable instanceof Bullet) ((Bullet) collisionable).moveForward(((Bullet) collisionable).getSpeed());
            else if (collisionable instanceof Asteroid) ((Asteroid) collisionable).move();
        }
        collisionables.forEach(GameController::checkAlive);
        collisionables.forEach(GameController::checkOutOfBounds);
        removeCollisionables();
    }

    public static void checkCollisions() {
        collisionEngine.checkCollisions(asCollisionables());
    }

    public void updatePLayers(){
        playerAController.updatePlayer();
        if (playerAController.getStarship().getHealthPoints() <= 0) gameOver();
    }

    private static List<Collisionable> asCollisionables(){
        return new ArrayList<>(GameController.collisionables);
    }

    public void spawnAsteroid(){
        if(lastAsteroid == 0) lastAsteroid = asteroidSpawner.spawnAsteroid();
        else if(System.currentTimeMillis() - lastAsteroid > 1000) lastAsteroid = asteroidSpawner.spawnAsteroid();
    }

    private static void checkOutOfBounds(Collisionable<GameObject> collisionable){
        GameObject gameObject = ((GameObject) collisionable);
        Vector2 futurePosition = gameObject.getPosition().add(gameObject.getDirection().multiply(gameObject.getSpeed()));
        boolean x = futurePosition.getX() <= MAP_WIDTH && futurePosition.getX() >= 0;
        boolean y = futurePosition.getY() <= MAP_HEIGHT && futurePosition.getY() >= 0;
        if(!x || !y) toRemoveCollisionables.add(collisionable);
    }

    private static void checkAlive(Collisionable<GameObject> collisionable){
        if(((GameObject) collisionable).getHealthPoints() <= 0) toRemoveCollisionables.add(collisionable);
    }

    private static void removeCollisionables(){
        for (Collisionable<GameObject> toRemoveCollisionable : toRemoveCollisionables){
            collisionables.remove(toRemoveCollisionable);
            GameRenderer.removeToRender((Rendereable) toRemoveCollisionable);
        }
        toRemoveCollisionables.clear();
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public void gameOver() {
        toRemoveCollisionables.clear();
        collisionables.clear();
        playerAController.gameOver();
        GameRenderer.gameOver(playerAController.getPoints());
        gameOver = true;
    }
}
