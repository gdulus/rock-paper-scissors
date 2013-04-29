package rps.game.engine;

final class MatchScore {

    private Integer playerOneScore = 0;

    private Integer playerTwoScore = 0;

    public void increasePointsFor(final MatchAttender matchAttender){
        if (matchAttender == null){
            return;
        }

        switch (matchAttender){
            case PLAYER_ONE:
                playerOneScore++;
                break;
            case PLAYER_TWO:
                playerTwoScore++;
                break;
        }
    }

    public MatchAttender getWinner(){
        if (isDraft()){
            return null;
        }

        return playerOneScore > playerTwoScore ? MatchAttender.PLAYER_ONE : MatchAttender.PLAYER_TWO;
    }

    public Integer getWinnerPoints(){
        if (isDraft()){
            return playerOneScore;
        }

        switch (getWinner()){
            case PLAYER_ONE:
                return playerOneScore;
            default:
                return playerTwoScore;
        }
    }

    public boolean isDraft(){
        return playerOneScore.equals(playerTwoScore);
    }
}
