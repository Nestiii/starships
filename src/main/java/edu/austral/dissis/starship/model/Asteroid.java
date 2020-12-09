package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Asteroid extends GameObject{

    private final float speed;
    private final int width, height, damage;

    Asteroid(Vector2 position, Vector2 direction, int healthPoints, float speed, int width, int height, int damage) {
        super(position, direction, healthPoints);
        this.speed = speed;
        this.damage = damage;
        this.width = width;
        this.height = height;
        this.shape = new Ellipse2D.Float(position.getX(), position.getY(), width, height);
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
        shape = new Ellipse2D.Float(position.getX(), position.getY(), width, height);
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
        System.out.println(starship.getHealthPoints());
    }

    @Override
    public void collisionedWithBullet(Bullet bullet) {
        bullet.updateHealth(0);
    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {}

}
