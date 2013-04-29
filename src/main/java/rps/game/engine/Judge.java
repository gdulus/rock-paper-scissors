package rps.game.engine;

import rps.game.figure.Figure;

public final class Judge {

    private final Figure playerOneFigure;

    private final Figure playerTwoFigure;

    public Judge(Figure playerOneFigure, Figure playerTwoFigure) {
        this.playerOneFigure = playerOneFigure;
        this.playerTwoFigure = playerTwoFigure;
    }

    public MatchAttender getWinner(){
        if (playerOneFigure.equals(playerTwoFigure)){
            return null;
        }

        if (playerOneFigure.dominates().contains(playerTwoFigure)){
            return MatchAttender.PLAYER_ONE;
        } else {
            return MatchAttender.PLAYER_TWO;
        }
    }
}
