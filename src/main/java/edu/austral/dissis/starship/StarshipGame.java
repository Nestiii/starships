package edu.austral.dissis.starship;

import edu.austral.dissis.starship.controller.GameController;
import edu.austral.dissis.starship.view.GameRenderer;
import edu.austral.dissis.starship.view.DefaultThemeRenderer;
import edu.austral.dissis.starship.base.framework.GameFramework;
import edu.austral.dissis.starship.base.framework.ImageLoader;
import edu.austral.dissis.starship.base.framework.WindowSettings;
import edu.austral.dissis.starship.view.Renderer;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import static edu.austral.dissis.starship.constants.ShapeConstants.*;

import java.util.Set;

public class StarshipGame implements GameFramework {

    private final GameRenderer gameRenderer;
    private final GameController gameController;
    private final Renderer renderer;

    public StarshipGame() {
        renderer = new DefaultThemeRenderer();
        gameRenderer = new GameRenderer(renderer);
        gameController = new GameController();
    }

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings.setSize(MAP_WIDTH, MAP_HEIGHT);
        renderer.loadImages(imageLoader);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        gameRenderer.render(graphics);
        if (!gameController.isGameOver()){
            gameController.spawnAsteroid();
            GameController.updateCollisionables();
            gameController.handleKeyPress(keySet);
            GameController.checkCollisions();
            gameController.updatePLayers();
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {}

    @Override
    public void keyReleased(KeyEvent event) {}
}
