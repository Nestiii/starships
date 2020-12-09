package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.model.GameObjects.Player;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public abstract class Bullet extends GameObject {

    private final int damage;
    private final float speed;
    public final Player player;

    public Bullet(Vector2 position, Vector2 direction, int healthPoints, int damage, float speed, Player player) {
        super(position, direction, healthPoints);
        this.damage = damage;
        this.speed = speed;
        this.player = player;
        this.shape = new Rectangle2D.Float(position.getX() - (float) BULLET_WIDTH/2, position.getY() - (float) BULLET_HEIGHT/2, BULLET_WIDTH, BULLET_HEIGHT);
    }

    public int getDamage() {
        return damage;
    }

    public Player getPlayer(){ return  player; }

    public float getSpeed() {
        return speed;
    }

    public abstract Bullet getNewBullet(Vector2 position, Vector2 direction);

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void moveForward(float speed) {
        this.position = position.add(Vector2.vector(0, -1).multiply(speed));
        moveShape();
    }

    @Override
    public void moveBackwards(float speed) {
        this.position = position.add(Vector2.vector(0, 1).multiply(speed));
        moveShape();
    }

    @Override
    public void moveLeft(float speed) {
        this.position = position.add(Vector2.vector(-1, 0).multiply(speed));
        moveShape();
    }

    @Override
    public void moveRight(float speed) {
        this.position = position.add(Vector2.vector(1, 0).multiply(speed));
        moveShape();
    }

    private void moveShape() {
        this.shape = new Rectangle2D.Float(position.getX() - (float) BULLET_WIDTH/2, position.getY() - (float) BULLET_HEIGHT/2, BULLET_WIDTH, BULLET_HEIGHT);
    }

    @Override
    public void rotate(float degrees) {
        this.direction = direction.rotate(degrees);
    }

    @Override
    public void collisionedWith(GameObject collisionable) {
        collisionable.collisionedWithBullet(this);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {
        starship.updateHealth(starship.getHealthPoints() - damage);
    }

    @Override
    public void collisionedWithBullet(Bullet bullet) {
        bullet.updateHealth(0);
    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {
        asteroid.updateHealth(asteroid.getHealthPoints() - damage);
        if (asteroid.getHealthPoints() <= 0){
            player.updatePoints(asteroid.getPoints());
        }
    }
}
