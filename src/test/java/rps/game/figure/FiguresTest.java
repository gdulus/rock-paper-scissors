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

    @Test
    public void getRandom_multipleGenerations_shouldNotFail(){
        for (int index = 0; index < 1000; index++){
            Assert.assertNotNull(Figures.getRandom());
        }
    }

    @Test
    public void valueOf_notExisting_shouldReturnNull(){
        Assert.assertNull(Figures.valueOf(null));
    }

    @Test
    public void valueOf_existing_shouldReturnProperFigure(){
        Assert.assertEquals(Figures.PAPER, Figures.valueOf(Figures.PAPER.getId()));
        Assert.assertEquals(Figures.SCISSORS, Figures.valueOf(Figures.SCISSORS.getId()));
        Assert.assertEquals(Figures.ROCK, Figures.valueOf(Figures.ROCK.getId()));
    }
}
