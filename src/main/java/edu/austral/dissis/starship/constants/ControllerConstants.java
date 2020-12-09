package edu.austral.dissis.starship.constants;

import edu.austral.dissis.starship.controller.Enums.Action;

import java.util.HashMap;
import java.util.Map;

public class ControllerConstants {

    public static Map<Integer, Action> KET_SET_A = new HashMap<Integer, Action>() {
        {
            put(38, Action.MOVE_FORWARD);
            put(40, Action.MOVE_BACKWARDS);
            put(39, Action.MOVE_RIGHT);
            put(37, Action.MOVE_LEFT);
            put(16, Action.SHOOT);
        }
    };

    public static Map<Integer, Action> KET_SET_B = new HashMap<Integer, Action>() {
        {
            put(87, Action.MOVE_FORWARD);
            put(83, Action.MOVE_BACKWARDS);
            put(68, Action.MOVE_RIGHT);
            put(65, Action.MOVE_LEFT);
            put(32, Action.SHOOT);
        }
    };
}
