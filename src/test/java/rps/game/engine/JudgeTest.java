package rps.game.engine;

import org.junit.Assert;
import org.junit.Test;
import rps.game.figure.Figures;

public class JudgeTest {

    @Test
    public void getWinner_theSameFigures_shouldReturnNull(){
        Judge judge = new Judge(Figures.PAPER, Figures.PAPER);
        Assert.assertNull(judge.getWinner());
    }

    @Test
    public void getWinner_playerOneWins_shouldReturnPlayerOneAsAWinner(){
        Judge judge = new Judge(Figures.PAPER, Figures.ROCK);
        Assert.assertEquals(MatchAttender.PLAYER_ONE, judge.getWinner());
    }

    @Test
    public void getWinner_playerTwoWins_shouldReturnPlayerTwoAsAWinner(){
        Judge judge = new Judge(Figures.ROCK, Figures.PAPER);
        Assert.assertEquals(MatchAttender.PLAYER_TWO, judge.getWinner());
    }

}
