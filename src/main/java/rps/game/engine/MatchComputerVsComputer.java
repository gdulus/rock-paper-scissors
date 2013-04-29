package rps.game.engine;

import rps.game.figure.Figure;
import rps.game.player.PlayerFactory;
import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

class MatchComputerVsComputer extends AbstractMatch {

    MatchComputerVsComputer(GUI gui, MessageProvider messageProvider) {
        super(gui, messageProvider, PlayerFactory.Type.COMPUTER, PlayerFactory.Type.COMPUTER);
    }

    @Override
    protected Figure getFigurePlayerOne() {
        sleep();
        return playerOne.getFigure();
    }

    @Override
    protected Figure getFigurePlayerTwo() {
        sleep();
        return playerTwo.getFigure();
    }
}
