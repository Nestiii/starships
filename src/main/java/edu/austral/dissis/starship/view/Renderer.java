package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.model.LaserBullet;
import edu.austral.dissis.starship.model.Starship;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public abstract class Renderer {

    PImage starshipImage;
    PImage laserBulletImage;

    public void draw(PGraphics graphics, Starship starship){
        Vector2 position = starship.getPosition();
        float angle = starship.getDirection().rotate(PConstants.PI/2).getAngle();
        graphics.pushMatrix();
        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);
        graphics.image(starshipImage, STARSHIP_WIDTH/-2f, STARSHIP_HEIGHT/-2f);
        graphics.popMatrix();
    }

    public void draw(PGraphics graphics, LaserBullet laserBullet){
        Vector2 position = laserBullet.getPosition();
        float angle = laserBullet.getDirection().rotate(PConstants.PI/2).getAngle();
        graphics.pushMatrix();
        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);
        graphics.image(laserBulletImage, BULLET_WIDTH/-2f, BULLET_HEIGHT/-2f);
        graphics.popMatrix();
    }

    public PImage loadImage(ImageLoader imageLoader, String path, int width, int height){
        PImage image =  imageLoader.load(path);
        image.resize(width, height);
        return image;
    }

    public abstract void loadImages(ImageLoader imageLoader);
}
