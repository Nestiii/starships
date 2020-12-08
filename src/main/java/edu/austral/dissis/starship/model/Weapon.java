package edu.austral.dissis.starship.model;

public abstract class Weapon {

    private final Bullet bullet;
    private final int shootInterval;

    public Weapon(Bullet bullet, int shootInterval){
        this.bullet = bullet;
        this.shootInterval = shootInterval;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public abstract void shoot(Starship starship);
}
