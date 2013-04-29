package rps.game.player;

import rps.game.figure.Figure;
import rps.game.figure.Figures;

class HumanPlayer implements Player {

    @Override
    public Figure getFigure() {
        throw new IllegalStateException("This type of player doesn't support this methods");
    }

    @Override
    public Figure getFigure(final Integer id) {
        final Figure figure = Figures.valueOf(id);

        if (figure != null){
            return figure;
        }

        throw new IllegalArgumentException("This type of player doesn't support this methods");
    }

    @Override
    public void memorizeOpponentMove(Figure opponentMove) {
    }
}
