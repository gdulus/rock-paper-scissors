package rps.game.figure;

import org.junit.Assert;
import org.junit.Test;

public class FiguresTest {

    @Test
    public void rock_dominates_shouldWinWithScissors(){
        Assert.assertTrue(Figures.ROCK.dominates().contains(Figures.SCISSORS));
    }

    @Test
    public void rock_subordinates_shouldLooseWithPaper(){
        Assert.assertTrue(Figures.ROCK.subordinates().contains(Figures.PAPER));
    }

    @Test
    public void paper_dominates_shouldWinWithRock(){
        Assert.assertTrue(Figures.PAPER.dominates().contains(Figures.ROCK));
    }

    @Test
    public void paper_subordinates_shouldLooseWithScissors(){
        Assert.assertTrue(Figures.PAPER.subordinates().contains(Figures.SCISSORS));
    }

    @Test
    public void scissors_dominates_shouldWinWithPaper(){
        Assert.assertTrue(Figures.SCISSORS.dominates().contains(Figures.PAPER));
    }

    @Test
    public void scissors_subordinates_shouldLooseWithRock(){
        Assert.assertTrue(Figures.SCISSORS.subordinates().contains(Figures.ROCK));
    }

}
