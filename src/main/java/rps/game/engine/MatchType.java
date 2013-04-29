package rps.game.engine;

public enum MatchType {

    HUMAN_VS_HUMAN(1),
    HUMAN_VS_COMPUTER(2),
    COMPUTER_VS_COMPUTER(3);

    private final Integer gameTypeId;

    private MatchType(int gameTypeId) {
        this.gameTypeId = gameTypeId;
    }

    public static MatchType valueOf(final Integer gameTypeId){
        for (final MatchType type : MatchType.values()){
            if (type.gameTypeId.equals(gameTypeId)){
                return type;
            }
        }

        throw new IllegalArgumentException("Can't find GameType for game id = " + gameTypeId);
    }

    public Integer getGameTypeId() {
        return gameTypeId;
    }
}
