package rps.game.player;

import rps.game.figure.Figure;

public interface Player {

    public Figure getFigure();

    public Figure getFigure(Integer id);

    public void memorizeOpponentMove(Figure opponentMove);

}
