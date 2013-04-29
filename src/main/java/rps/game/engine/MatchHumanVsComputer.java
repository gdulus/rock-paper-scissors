package rps.game.engine;

import rps.game.figure.Figure;
import rps.game.player.PlayerFactory;
import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

class MatchHumanVsComputer extends AbstractMatch {

    MatchHumanVsComputer(GUI gui, MessageProvider messageProvider) {
        super(gui, messageProvider, PlayerFactory.Type.HUMAN, PlayerFactory.Type.COMPUTER);
    }

    @Override
    protected Figure getFigurePlayerOne() {
        displayMessage("game.humanLegend");
        return playerOne.getFigure(getUserInput());
    }

    @Override
    protected Figure getFigurePlayerTwo() {
        sleep();
        return playerTwo.getFigure();
    }
}
