package rps.gui;


import rps.gui.i18n.MessageProvider;

public final class GUIFactory {

    public enum Type {
        BASH
    }

    private GUIFactory() {
    }

    public static GUI produce(final Type type) {
        switch (type){
            case BASH:
                return new BashGUI();
            default:
                throw new IllegalArgumentException("Can't build GUI for type " + type);
        }
    }
}
