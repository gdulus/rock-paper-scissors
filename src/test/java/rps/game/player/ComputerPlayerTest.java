package rps.game.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rps.game.figure.Figures;

public class ComputerPlayerTest {

    private ComputerPlayer player;

    @Before
    public void setUp() throws Exception {
        player = new ComputerPlayer();
    }

    @Test(expected = IllegalStateException.class)
    public void getFigureWithParams_shouldThrownAnException(){
        player.getFigure(Figures.PAPER.getId());
    }

    @Test
    public void doGetFigureWithoutParams_noOpponentMove_shouldReturnNotNullFigure(){
        Assert.assertNotNull(player.getFigure());
    }

    @Test
    public void doGetFigureWithoutParams_severalMovesWithoutOpponentMove_shouldReturnNotNullFigure(){
        for (int index = 0; index < 1000; index++){
            Assert.assertNotNull(player.getFigure());
        }
    }

    @Test
    public void doGetFigureWithoutParams_severalMovesWithOpponentMove_shouldReturnNotNullFigure(){
        for (int index = 0; index < 1000; index++){
            Assert.assertNotNull(player.getFigure());
            player.memorizeOpponentMove(Figures.getRandom());
        }
    }

}
