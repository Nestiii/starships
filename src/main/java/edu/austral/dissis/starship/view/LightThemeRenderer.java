package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.base.framework.ImageLoader;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public class LightThemeRenderer extends Renderer {

    String starshipPath = "starship.png";
    String laserBulletPath = "laser_bullet.png";

    @Override
    public void loadImages(ImageLoader imageLoader) {
        this.starshipImage = loadImage(imageLoader, starshipPath, STARSHIP_WIDTH, STARSHIP_HEIGHT);
        this.laserBulletImage = loadImage(imageLoader, laserBulletPath, BULLET_WIDTH, BULLET_HEIGHT);
    }
}
