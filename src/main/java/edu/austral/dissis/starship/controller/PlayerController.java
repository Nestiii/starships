package edu.austral.dissis.starship.controller;

import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.model.Player;
import edu.austral.dissis.starship.model.Starship;

import java.util.Map;

import static edu.austral.dissis.starship.constants.MoveConstants.STARSHIP_SPEED;
import static edu.austral.dissis.starship.constants.ShapeConstants.MAP_HEIGHT;
import static edu.austral.dissis.starship.constants.ShapeConstants.MAP_WIDTH;

public class PlayerController implements KeyHandler{

    private final Player player;
    private final Starship starship;
    private final Map<Integer, Action> keyMap;

    public PlayerController(Map<Integer, Action> keyMap, Player player, Starship starship){
        this.player = player;
        this.starship = starship;
        this.keyMap = keyMap;
    }

    @Override
    public void handleKeyPress(int keyCode) {
        if(keyMap.containsKey(keyCode)){
            System.out.println(keyMap.get(keyCode));
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
}
