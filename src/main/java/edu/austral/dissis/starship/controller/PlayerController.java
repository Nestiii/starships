package edu.austral.dissis.starship.controller;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.model.*;

import java.util.Map;

import static edu.austral.dissis.starship.constants.MoveConstants.STARSHIP_SPEED;
import static edu.austral.dissis.starship.constants.ShapeConstants.MAP_HEIGHT;
import static edu.austral.dissis.starship.constants.ShapeConstants.MAP_WIDTH;

public class PlayerController implements KeyHandler{

    private final Player player;
    private final Starship starship;
    private final Map<Integer, Action> keyMap;
    private boolean lost;

    public PlayerController(Map<Integer, Action> keyMap, Player player, Starship starship){
        this.player = player;
        this.starship = starship;
        this.keyMap = keyMap;
        this.lost = false;
    }

    @Override
    public void handleKeyPress(int keyCode) {
        if(keyMap.containsKey(keyCode) && !lost){
            switch (keyMap.get(keyCode)){
                case MOVE_FORWARD:
                    if (canMove(starship, Vector2.vector(0, -1))) starship.moveForward(STARSHIP_SPEED);
                    break;
                case MOVE_BACKWARDS:
                    if (canMove(starship, Vector2.vector(0, 1))) starship.moveBackwards(STARSHIP_SPEED);
                    break;
                case MOVE_LEFT:
                    if (canMove(starship, Vector2.vector(-1, 0))) starship.moveLeft(STARSHIP_SPEED);
                    break;
                case MOVE_RIGHT:
                    if (canMove(starship, Vector2.vector(1, 0))) starship.moveRight(STARSHIP_SPEED);
                    break;
                case SHOOT:
                    starship.shoot();
                    break;
            }
        }
    }

    private boolean canMove(Starship starship, Vector2 direction){
        Vector2 currentPosition = starship.getPosition();
        Vector2 futurePosition = currentPosition.add(direction.multiply(STARSHIP_SPEED));
        boolean x = futurePosition.getX() <= MAP_WIDTH && futurePosition.getX() >= 0;
        boolean y = futurePosition.getY() <= MAP_HEIGHT && futurePosition.getY() >= 0;
        return x && y;
    }

    public Starship getStarship() {
        return starship;
    }

    public void updatePlayer(){
        if (player.getPoints() > 1000 && player.getPoints() < 2000 && !(starship.getWeapon() instanceof DoubleWeapon))
            starship.changeWeapon(new DoubleWeapon(new DefaultBullet(starship.getPosition(), starship.getDirection(), player)));
        if (player.getPoints() > 2000 && player.getPoints() < 3000 && !(starship.getWeapon() instanceof SingleWeapon))
            starship.changeWeapon(new SingleWeapon(new LaserBullet(starship.getPosition(), starship.getDirection(), player)));
        if (player.getPoints() > 3000 && !(starship.getWeapon() instanceof DoubleWeapon))
            starship.changeWeapon(new DoubleWeapon(new LaserBullet(starship.getPosition(), starship.getDirection(), player)));
    }

    public void updatePlayerPoints(int points){
        player.updatePoints(points);
    }

    public Player getPlayer(){
        return player;
    }

    public int getPoints(){
        return player.getPoints();
    }

    public void gameOver(){
        this.lost = true;
    }
}
