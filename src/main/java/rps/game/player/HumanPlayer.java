package rps.game.player;

import rps.game.figure.Figure;
import rps.game.figure.Figures;

class HumanPlayer implements Player {

    @Override
    public Figure getFigure() {
        throw new IllegalStateException("This type of player doesn't support this methods");
    }

    @Override
    public Figure getFigure(Integer id) {
        return Figures.valueOf(id);
    }

    @Override
    public void memorizeOpponentMove(Figure opponentMove) {
    }
}
