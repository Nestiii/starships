package edu.austral.dissis.starship.model;

public interface Movable<T> {

    void moveForward(float speed);

    void moveBackwards(float speed);

    void moveLeft(float speed);

    void moveRight(float speed);

    void rotate(float degrees);
}
