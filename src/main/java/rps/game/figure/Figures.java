package rps.game.figure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Figures {

    public static final Figure ROCK;

    public static final Figure SCISSORS;

    public static final Figure PAPER;

    private static final Figure[] ALL_FIGURES;

    static {
        final FigureImpl rock = new FigureImpl(1);
        final FigureImpl scissors = new FigureImpl(2);
        final FigureImpl paper = new FigureImpl(3);

        rock.setWinsWith(new Figure[]{scissors});
        rock.setLosesWith(new Figure[]{paper});

        scissors.setWinsWith(new Figure[]{paper});
        scissors.setLosesWith(new Figure[]{rock});

        paper.setWinsWith(new Figure[]{rock});
        paper.setLosesWith(new Figure[]{scissors});

        ROCK = rock;
        SCISSORS = scissors;
        PAPER = paper;
        ALL_FIGURES = new Figure[]{ROCK, SCISSORS, PAPER};
    }

    private Figures() {
    }

    public static Figure getRandom(){
        final int index = (int)(Math.random() * ALL_FIGURES.length);
        return ALL_FIGURES[index];
    }

    public static Figure valueOf(final Integer id){
        for(final Figure figure : ALL_FIGURES){
            if (figure.getId().equals(id)){
                return figure;
            }
        }
        return null;
    }

    private static final class FigureImpl implements Figure {

        private final Integer id;

        private List<? extends Figure> winsWith;

        private List<? extends Figure> losesWith;

        private FigureImpl(Integer id) {
            this.id = id;
        }

        @Override
        public List<? extends Figure> dominates() {
            return winsWith;
        }

        @Override
        public List<? extends Figure> subordinates() {
            return losesWith;
        }

        @Override
        public Integer getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Figure)){
                return false;
            }

            final Figure figure = (Figure) o;
            return figure.getId().equals(this.getId());
        }

        @Override
        public int hashCode() {
            return id;
        }

        void setWinsWith(final Figure[] winsWith) {
            this.winsWith = asList(winsWith);
        }

        private void setLosesWith(final Figure[] losesWith) {
            this.losesWith = asList(losesWith);
        }

        private List<? extends Figure> asList(final Figure[] gameFiguresArray){
            return Collections.unmodifiableList(Arrays.asList(gameFiguresArray));
        }

    }

}


