package rps.game.engine;

import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

public class MainLoopLogicImpl implements MainLoopLogic {

    @Override
    public MatchType getMatchType(final GUI gui) {
        final String gameTypeAsString = gui.pull();

        if (gameTypeAsString == null || gameTypeAsString.isEmpty()){
            throw new MainLoopLogicMatchNullOrEmptyException();
        }

        try {
            final Integer gameModeId = Integer.valueOf(gameTypeAsString);
            return MatchType.valueOf(gameModeId);
        } catch (final Exception exception){
            throw new MainLoopLogicMatchInvalidValueException();
        }
    }


    @Override
    public MatchAttender playMatch(final MatchType matchType, final GUI gui, final MessageProvider messageProvider) {
        final Match match = MatchFactory.produce(matchType, gui, messageProvider);
        return match.play();
    }
}
