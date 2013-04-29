package rps.game.figure;

import java.util.List;

/**
 * Game figure know with whom it win/loose
 * http://martinfowler.com/bliki/AnemicDomainModel.html
 */
public interface Figure {

    public List<? extends Figure> dominates();

    public List<? extends Figure> subordinates();

    public Integer getId();

}
