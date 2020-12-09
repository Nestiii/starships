package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Asteroid extends GameObject{

    private final float speed;
    private final int width, height, damage, points;

    public Asteroid(Vector2 position, Vector2 direction, int healthPoints, float speed, int width, int height, int damage, int points) {
        super(position, direction, healthPoints);
        this.speed = speed;
        this.damage = damage;
        this.width = width;
        this.height = height;
        this.points = points;
        this.shape = new Ellipse2D.Float(position.getX() - (float) width/2, position.getY() - (float) height/2, width, height);
    }

    public int getDamage() {
        return damage;
    }

    public float getSpeed() {
        return speed;
    }

    public void move(){
        this.position = position.add(direction.multiply(speed));
        moveShape();
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

    @Override
    public void rotate(float degrees) {
        this.direction = direction.rotate(degrees);
    }

    private void moveShape() {
        this.shape = new Ellipse2D.Float(position.getX() - (float) width/2, position.getY() - (float) height/2, width, height);
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public void collisionedWith(GameObject collisionable) {
        collisionable.collisionedWithAsteroid(this);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {
        starship.updateHealth(starship.getHealthPoints() - getDamage());
    }

    @Override
    public void collisionedWithBullet(Bullet bullet) {
        bullet.updateHealth(0);
    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {}

    public int getPoints() {
        return points;
    }
}
