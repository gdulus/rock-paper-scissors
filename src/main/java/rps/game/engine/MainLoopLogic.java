package rps.game.engine;

import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

public interface MainLoopLogic {

    public MatchType getMatchType(GUI gui) throws MainLoopLogicMatchNullOrEmptyException, MainLoopLogicMatchInvalidValueException;

    public MatchAttender playMatch(MatchType matchType, GUI gui, MessageProvider messageProvider);
}
