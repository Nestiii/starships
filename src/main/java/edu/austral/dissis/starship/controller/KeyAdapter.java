package edu.austral.dissis.starship.controller;

import edu.austral.dissis.starship.controller.Enums.Action;

import java.util.Map;
import java.util.Optional;

public class KeyAdapter {

    private final Map<Integer, Action> keyMap;

    public KeyAdapter(Map<Integer, Action> keyMap){
        this.keyMap = keyMap;
    }

    public Optional<Action> adapt(Integer key){
        Action action = keyMap.get(key);
        return action != null ? Optional.of(action) : Optional.empty();
    }
}
