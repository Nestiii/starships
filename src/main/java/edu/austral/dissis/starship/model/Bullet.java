package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public abstract class Bullet extends GameObject{

    private final int damage;
    private final float speed;

    Bullet(Vector2 position, Vector2 direction, int healthPoints, int damage, float speed) {
        super(position, direction, healthPoints);
        this.damage = damage;
        this.speed = speed;
        this.shape = new Rectangle2D.Float(position.getX(), position.getY(), BULLET_WIDTH, BULLET_HEIGHT);
    }

    public int getDamage() {
        return damage;
    }

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
        shape = new Rectangle2D.Float(position.getX(), position.getY(), BULLET_WIDTH, BULLET_HEIGHT);
    }

    @Override
    public void rotate(float degrees) {}
}
