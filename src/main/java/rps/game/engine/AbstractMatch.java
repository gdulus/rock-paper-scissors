package rps.game.engine;

import rps.game.figure.Figure;
import rps.game.player.Player;
import rps.game.player.PlayerFactory;
import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

abstract class AbstractMatch implements Match {

    private final GUI gui;

    private final MessageProvider messageProvider;

    protected final Player playerOne;

    protected final Player playerTwo;

    protected AbstractMatch(GUI gui, MessageProvider messageProvider, PlayerFactory.Type playerOneType, PlayerFactory.Type playerTwoType) {
        this.gui = gui;
        this.messageProvider = messageProvider;
        this.playerOne = PlayerFactory.produce(playerOneType);
        this.playerTwo = PlayerFactory.produce(playerTwoType);
    }

    @Override
    public MatchAttender play(){
        try {
            displayPlayerMove(MatchAttender.PLAYER_ONE);
            final Figure playerOneFigure = getFigurePlayerOne();
            displayPlayerMove(MatchAttender.PLAYER_TWO);
            final Figure playerTwoFigure = getFigurePlayerTwo();

            displayFigureSelection(MatchAttender.PLAYER_ONE, playerOneFigure);
            displayFigureSelection(MatchAttender.PLAYER_TWO, playerTwoFigure);

            playerOne.memorizeOpponentMove(playerTwoFigure);
            playerTwo.memorizeOpponentMove(playerOneFigure);

            final Judge judge = new Judge(playerOneFigure, playerTwoFigure);
            return judge.getWinner();

        } catch (final Exception exception){
            throw new MatchPlayException(exception);
        }
    }

    protected abstract Figure getFigurePlayerOne();

    protected abstract Figure getFigurePlayerTwo();

    protected void displayMessage(final String message){
        gui.push(messageProvider.getMessage(message));
    }

    protected Integer getUserInput(){
        return Integer.valueOf(gui.pull());
    }

    protected void sleep(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
        }
    }

    private void displayFigureSelection(final MatchAttender matchAttender, final Figure figure){
        gui.pushWarning(messageProvider.getMessage("game.figure." + matchAttender.name() + "." + figure.getId()));
    }

    private void displayPlayerMove(final MatchAttender matchAttender){
        gui.pushWarning(messageProvider.getMessage("game.playerMove." + matchAttender.name() ));
    }

}
