package edu.austral.dissis.starship.view;

import edu.austral.dissis.starship.model.Player;
import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.List;

public class GameRenderer {

    public static final List<Rendereable> toRender = new ArrayList<>();
    private final Renderer renderer;

    public GameRenderer(Renderer renderer){
        this.renderer = renderer;
    }

    public static void addToRender(Rendereable rendereable){
        toRender.add(rendereable);
    }

    public static void removeToRender(Rendereable rendereable){
        toRender.remove(rendereable);
    }

    public void render(PGraphics graphics){
        for (Rendereable rendereable : toRender) rendereable.draw(graphics, renderer);
    }

    public static void singleGameOver(Player player){
        toRender.clear();
        addToRender(new SingleGameOver(player));
    }

    public static void multipleGameOver(Player playerA, Player playerB){
        toRender.clear();
        addToRender(new MultipleGameOver(playerA, playerB));
    }
}
