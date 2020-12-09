package edu.austral.dissis.starship.model;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;
import static edu.austral.dissis.starship.constants.MoveConstants.*;
import static edu.austral.dissis.starship.constants.StatsConstants.*;

public class Starship extends GameObject {

    private Weapon weapon;

    public Starship (Vector2 position, Vector2 direction){
        super(position, direction.asUnitary(), STARSHIP_HP);
        this.shape = new Rectangle2D.Float(position.getX()- (float) STARSHIP_WIDTH/2, position.getY() - (float) STARSHIP_HEIGHT/2, STARSHIP_WIDTH, STARSHIP_HEIGHT);
        weapon = new SingleWeapon(new LaserBullet(position, direction), 10);
        this.speed = STARSHIP_SPEED;
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
        shape = new Rectangle2D.Float(position.getX()- (float) STARSHIP_WIDTH/2, position.getY() - (float) STARSHIP_HEIGHT/2, STARSHIP_WIDTH, STARSHIP_HEIGHT);
    }

    @Override
    public void rotate(float degrees) {
        this.direction = direction.rotate(degrees);
    }

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
    public void collisionedWithBullet(Bullet bullet) {
        bullet.updateHealth(0);
    }

    @Override
    public void collisionedWithAsteroid(Asteroid asteroid) {
        asteroid.updateHealth(0);
    }

    @Override
    public void collisionedWithStarship(Starship starship) {}

    @Override
    public void draw(PGraphics graphics, Renderer renderer) {
        renderer.draw(graphics, this);
    }
}
