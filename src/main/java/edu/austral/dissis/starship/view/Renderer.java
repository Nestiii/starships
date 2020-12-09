package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.model.*;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.vector.Vector2;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

public abstract class Renderer {

    PImage starshipImage;
    PImage laserBulletImage;
    PImage defaultBulletImage;
    PImage smallAsteroidImage;
    PImage mediumAsteroidImage;
    PImage bigAsteroidImage;

    public void draw(PGraphics graphics, Starship starship){
        draw(graphics, starship, STARSHIP_WIDTH, STARSHIP_HEIGHT, starshipImage);
    }

    public void draw(PGraphics graphics, LaserBullet laserBullet){
        draw(graphics, laserBullet, BULLET_WIDTH, BULLET_HEIGHT, laserBulletImage);
    }

    public void draw(PGraphics graphics, DefaultBullet defaultBullet){
        draw(graphics, defaultBullet, BULLET_WIDTH, BULLET_HEIGHT, defaultBulletImage);
    }

    public void draw(PGraphics graphics, SmallAsteroid smallAsteroid){
        draw(graphics, smallAsteroid, SMALL_ASTEROID_WIDTH, SMALL_ASTEROID_HEIGHT, smallAsteroidImage);
    }

    public void draw(PGraphics graphics, MediumAsteroid mediumAsteroid){
        draw(graphics, mediumAsteroid, MEDIUM_ASTEROID_WIDTH, MEDIUM_ASTEROID_HEIGHT, mediumAsteroidImage);
    }

    public void draw(PGraphics graphics, BigAsteroid bigAsteroid){
        draw(graphics, bigAsteroid, BIG_ASTEROID_WIDTH, BIG_ASTEROID_HEIGHT, bigAsteroidImage);
    }

    public void draw(PGraphics graphics, PlayerStats playerStats){
        graphics.text("Points: " + playerStats.player.getPoints() + "\n" + "Life: " + playerStats.starship.getHealthPoints(), playerStats.position.getX() ,playerStats.position.getY());
    }

    public void draw(PGraphics graphics, SingleGameOver gameOver){
        graphics.text("GAME OVER \n\nPlayer: " + gameOver.getPlayer().getName() + "\nTotal Points: " + gameOver.getPlayer().getPoints(), 350,400);
    }

    public void draw(PGraphics graphics, MultipleGameOver gameOver){
        graphics.text(
                "GAME OVER " +
                        "\n\nPlayer 1: " + gameOver.getPlayerA().getName() + "\nTotal Points: " + gameOver.getPlayerA().getPoints() +
                        "\n\nPlayer 2: " + gameOver.getPlayerB().getName() + "\nTotal Points: " + gameOver.getPlayerB().getPoints(),
                350,
                350
        );
    }

    private void draw(PGraphics graphics, GameObject object, int width, int height, PImage image){
        Vector2 position = object.getPosition();
        float angle = object.getDirection().rotate(PConstants.PI/2).getAngle();
        graphics.pushMatrix();
        graphics.translate(position.getX(), position.getY());
        graphics.rotate(angle);
        graphics.image(image, width/-2f, height/-2f);
        graphics.popMatrix();
    }

    public PImage loadImage(ImageLoader imageLoader, String path, int width, int height){
        PImage image =  imageLoader.load(path);
        image.resize(width, height);
        return image;
    }

    public abstract void loadImages(ImageLoader imageLoader);
}
