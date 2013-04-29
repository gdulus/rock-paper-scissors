package rps.game.engine;

import rps.game.figure.Figure;
import rps.game.player.PlayerFactory;
import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

class MatchHumanVsHuman extends AbstractMatch {

    MatchHumanVsHuman(GUI gui, MessageProvider messageProvider) {
        super(gui, messageProvider, PlayerFactory.Type.HUMAN, PlayerFactory.Type.HUMAN);
    }

    @Override
    protected Figure getFigurePlayerOne() {
        displayMessage("game.humanLegend");
        return playerOne.getFigure(getUserInput());
    }

    @Override
    protected Figure getFigurePlayerTwo() {
        displayMessage("game.humanLegend");
        return playerTwo.getFigure(getUserInput());
    }

}
