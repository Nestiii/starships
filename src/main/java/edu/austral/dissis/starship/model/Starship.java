package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;
import static edu.austral.dissis.starship.constants.StatsConstants.*;

public class Starship extends GameObject {

    private Weapon weapon;

    public Starship (Vector2 position, Vector2 direction, int healthPoints){
        super(position, direction.asUnitary(), healthPoints);
        this.shape = new Rectangle2D.Float(position.getX(), position.getY(), STARSHIP_WIDTH, STARSHIP_HEIGHT);
        weapon = new SingleWeapon(new LaserBullet(position, direction, LASER_BULLET_HP), 10);
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
        shape = new Rectangle2D.Float(position.getX(), position.getY(), STARSHIP_WIDTH, STARSHIP_HEIGHT);
    }

    @Override
    public void rotate(float degrees) {}

    public void shoot() {
        weapon.shoot(this);
    }

    public void changeWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void collisionedWith(GameObject collisionable) {
        collisionable.collisionedWithStarship(this);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {}

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }
}
