package rps.gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class GUIFactory {

    public enum Type {
        BASH
    }

    private GUIFactory() {
    }

    public static GUI produce(final Type type) {
        if (type == null){
            throw new IllegalArgumentException("Can't build GUI for null type");
        }

        switch (type){
            case BASH:
                return new BashGUI(new BufferedReader(new InputStreamReader(System.in)), System.out);
            default:
                throw new IllegalArgumentException("Can't build GUI for type " + type);
        }
    }
}
