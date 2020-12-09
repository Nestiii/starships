package edu.austral.dissis.starship.model;

public abstract class Weapon {

    private Bullet bullet;
    long lastBullet;

    public Weapon(Bullet bullet){
        this.bullet = bullet;
        lastBullet = 0;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void changeBullet(Bullet bullet){
        this.bullet = bullet;
    }

    public abstract void shoot(Starship starship);

    public boolean shouldShoot(){
        if(lastBullet == 0) return true;
        return System.currentTimeMillis() - lastBullet > 80;
    }
}
