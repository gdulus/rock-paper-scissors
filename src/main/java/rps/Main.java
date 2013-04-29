package rps;

import rps.game.engine.MainLoop;
import rps.game.engine.MainLoopLogic;
import rps.game.engine.MainLoopLogicImpl;
import rps.gui.GUI;
import rps.gui.GUIFactory;
import rps.gui.i18n.MessageProvider;
import rps.gui.i18n.MessageProviderFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        final GUI gui = GUIFactory.produce(GUIFactory.Type.BASH);
        final MessageProvider messageProvider = MessageProviderFactory.produce(MessageProviderFactory.Type.SIMPLE);
        final MainLoopLogic mainLoopLogic = new MainLoopLogicImpl();
        final MainLoop mainLoop = new MainLoop(gui, messageProvider, mainLoopLogic);
        mainLoop.execute();
    }

}
