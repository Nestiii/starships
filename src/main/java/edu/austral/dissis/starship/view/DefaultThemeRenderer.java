package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.base.framework.ImageLoader;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public class DefaultThemeRenderer extends Renderer {

    String starshipPath = "starship.png";
    String laserBulletPath = "laser_bullet.png";
    String defaultBulletPath = "default_bullet.png";
    String asteroidPath = "asteroid.png";

    @Override
    public void loadImages(ImageLoader imageLoader) {
        this.starshipImage = loadImage(imageLoader, starshipPath, STARSHIP_WIDTH, STARSHIP_HEIGHT);
        this.laserBulletImage = loadImage(imageLoader, laserBulletPath, BULLET_WIDTH, BULLET_HEIGHT);
        this.defaultBulletImage = loadImage(imageLoader, defaultBulletPath, BULLET_WIDTH, BULLET_HEIGHT);
        this.smallAsteroidImage = loadImage(imageLoader, asteroidPath, SMALL_ASTEROID_WIDTH, SMALL_ASTEROID_HEIGHT);
        this.mediumAsteroidImage = loadImage(imageLoader, asteroidPath, MEDIUM_ASTEROID_WIDTH, MEDIUM_ASTEROID_HEIGHT);
        this.bigAsteroidImage = loadImage(imageLoader, asteroidPath, BIG_ASTEROID_WIDTH, BIG_ASTEROID_HEIGHT);
    }
}
