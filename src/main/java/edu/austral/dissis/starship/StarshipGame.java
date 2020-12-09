package edu.austral.dissis.starship;

import edu.austral.dissis.starship.controller.GameController;
import edu.austral.dissis.starship.controller.PlayerController;
import edu.austral.dissis.starship.model.Player;
import edu.austral.dissis.starship.view.GameRenderer;
import edu.austral.dissis.starship.view.DefaultThemeRenderer;
import edu.austral.dissis.starship.model.Starship;
import edu.austral.dissis.starship.base.framework.GameFramework;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.framework.WindowSettings;
import edu.austral.dissis.starship.base.vector.Vector2;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import static  edu.austral.dissis.starship.constants.ControllerConstants.*;
import static edu.austral.dissis.starship.constants.ShapeConstants.*;

import java.util.Set;

public class StarshipGame implements GameFramework {

    private final PlayerController playerA;
    private final GameRenderer gameRenderer;
    private final GameController gameController;
    private final Renderer renderer;

    public StarshipGame() {
        renderer = new DefaultThemeRenderer();
        gameRenderer = new GameRenderer(renderer);
        gameController = new GameController();
        Starship testStarship = new Starship(Vector2.vector(400,400), Vector2.vector(0, -1));
        GameRenderer.addToRender(testStarship);
        Player testPlayer = new Player("test", 0);
        playerA = new PlayerController(KET_SET_A, testPlayer, testStarship);
        GameController.addCollisionable(testStarship);
    }

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings.setSize(MAP_WIDTH, MAP_HEIGHT);
        renderer.loadImages(imageLoader);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        gameController.spawnAsteroid();
        GameController.updateCollisionables();
        gameRenderer.render(graphics);
        keySet.forEach(playerA::handleKeyPress);
        GameController.checkCollisions();
    }

    @Override
    public void keyPressed(KeyEvent event) {}

    @Override
    public void keyReleased(KeyEvent event) {}
}
