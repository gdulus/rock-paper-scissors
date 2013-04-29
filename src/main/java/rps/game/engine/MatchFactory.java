package rps.game.engine;

import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

final class MatchFactory {

    private MatchFactory() {
    }

    public static Match produce(final MatchType matchType, final GUI gui, final MessageProvider messageProvider){
        switch (matchType){
            case COMPUTER_VS_COMPUTER:
                return new MatchComputerVsComputer(gui, messageProvider);
            case HUMAN_VS_COMPUTER:
                return new MatchHumanVsComputer(gui, messageProvider);
            case HUMAN_VS_HUMAN:
                return new MatchHumanVsHuman(gui, messageProvider);
            default:
                throw new IllegalArgumentException("Can't build match for type " + matchType);
        }
    }

}
