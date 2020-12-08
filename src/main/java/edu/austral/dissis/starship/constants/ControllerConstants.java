package edu.austral.dissis.starship.constants;

import edu.austral.dissis.starship.controller.Action;

import java.util.HashMap;
import java.util.Map;

public class ControllerConstants {

    public static Map<Integer, Action> KET_SET_A = new HashMap<Integer, Action>() {
        {
            put(38, Action.MOVE_FORWARD);
            put(40, Action.MOVE_BACKWARDS);
            put(39, Action.MOVE_RIGHT);
            put(37, Action.MOVE_LEFT);
            put(32, Action.SHOOT);
        }
    };

}
