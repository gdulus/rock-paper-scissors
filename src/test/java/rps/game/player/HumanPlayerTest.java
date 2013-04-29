package rps.game.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rps.game.figure.Figures;

public class HumanPlayerTest {

    private HumanPlayer player;

    @Before
    public void setUp() throws Exception {
        player = new HumanPlayer();
    }

    @Test(expected = IllegalStateException.class)
    public void getFigureWithoutParams_shouldThrownAnException(){
        player.getFigure();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFigureWithParam_nullParam_shouldThrownAnException(){
        player.getFigure(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getFigureWithParam_wrongId_shouldThrownAnException(){
        player.getFigure(666);
    }

    @Test
    public void getFigureWithParam_shouldReturnFigure(){
        Assert.assertEquals(Figures.PAPER, player.getFigure(Figures.PAPER.getId()));
        Assert.assertEquals(Figures.SCISSORS, player.getFigure(Figures.SCISSORS.getId()));
        Assert.assertEquals(Figures.ROCK, player.getFigure(Figures.ROCK.getId()));
    }
}
