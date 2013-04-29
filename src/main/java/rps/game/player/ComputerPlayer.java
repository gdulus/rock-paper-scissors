package rps.game.player;

import rps.game.engine.Judge;
import rps.game.engine.MatchAttender;
import rps.game.figure.Figure;
import rps.game.figure.Figures;

import java.util.List;

/**
 * Just simple randomization here
 */
class ComputerPlayer implements Player {

    private Figure computerLastMove;

    private Figure opponentLastMove;

    @Override
    public Figure getFigure() {
        computerLastMove = doGetFigure();
        return computerLastMove;
    }

    private Figure doGetFigure(){
        if (opponentLastMove == null){
            return Figures.getRandom();
        }

        final Judge judge = new Judge(computerLastMove, opponentLastMove);
        final MatchAttender attender = judge.getWinner();

        if (attender == null){
            return Figures.getRandom();
        }

        if (attender.equals(MatchAttender.PLAYER_ONE)){
            return getRandom(computerLastMove.subordinates());
        } else {
            return getRandom(computerLastMove.dominates());
        }
    }

    private Figure getRandom(final List<? extends Figure> figures){
        final int index = (int)(Math.random() * figures.size());
        return figures.get(index);
    }

    @Override
    public Figure getFigure(Integer id) {
        throw new IllegalStateException("This type of player doesn't support this method");
    }

    @Override
    public void memorizeOpponentMove(final Figure opponentMove) {
        opponentLastMove = opponentMove;
    }
}
