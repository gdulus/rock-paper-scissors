package rps.game.figure;

import java.util.List;

public interface Figure {

    public List<? extends Figure> dominates();

    public List<? extends Figure> subordinates();

    public Integer getId();

}
