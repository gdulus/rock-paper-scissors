package rps.gui.i18n;

import rps.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

class SimpleMessageProvider implements MessageProvider {

    private static final Map<String, String> TRANSLATIONS = new HashMap<>();

    private static final Object[] EMPTY_PARAMS = new Object[]{};

    static {
        TRANSLATIONS.put("game.selectMatchType", "SELECT GAME MODE");
        TRANSLATIONS.put("game.matchTypeDesc.HUMAN_VS_HUMAN", "{0} - player vs player");
        TRANSLATIONS.put("game.matchTypeDesc.HUMAN_VS_COMPUTER", "{0} - player vs computer");
        TRANSLATIONS.put("game.matchTypeDesc.COMPUTER_VS_COMPUTER", "{0} - computer vs computer");
        TRANSLATIONS.put("error.matchType.empty", "game type can't be null or empty string - try again");
        TRANSLATIONS.put("error.matchType.wrongType", "game type need to be a number from one of listed above");
        TRANSLATIONS.put("game.startingGame", "Starting game player vs player");
        TRANSLATIONS.put("game.round", "Starting round {0}");
        TRANSLATIONS.put("game.playerMove.PLAYER_ONE", "Player one move");
        TRANSLATIONS.put("game.playerMove.PLAYER_TWO", "Player two move");
        TRANSLATIONS.put("game.humanLegend", "[1] = ROCK, [2] = SCISSORS, [3] = PAPER");
        TRANSLATIONS.put("game.figure.PLAYER_ONE.1", "Player one selected ROCK");
        TRANSLATIONS.put("game.figure.PLAYER_ONE.2", "Player one selected SCISSORS");
        TRANSLATIONS.put("game.figure.PLAYER_ONE.3", "Player one selected PAPER");
        TRANSLATIONS.put("game.figure.PLAYER_TWO.1", "Player two selected ROCK");
        TRANSLATIONS.put("game.figure.PLAYER_TWO.2", "Player two selected SCISSORS");
        TRANSLATIONS.put("game.figure.PLAYER_TWO.3", "Player two selected PAPER");
        TRANSLATIONS.put("error.matchPlay", "Wrong type of selection - choose valid number from the list above");
        TRANSLATIONS.put("error.matchPlay", "Wrong type of selection - choose valid number from the list above");
        TRANSLATIONS.put("game.roundWinner.PLAYER_ONE", "Round for player one");
        TRANSLATIONS.put("game.roundWinner.PLAYER_TWO", "Round for player two");
        TRANSLATIONS.put("game.winner.PLAYER_ONE", "Winner is player one with {0} points");
        TRANSLATIONS.put("game.winner.PLAYER_TWO", "Winner is player two with {0} points");
        TRANSLATIONS.put("game.winner.draft", "Both players got the same number of points. DRAFT!");
        TRANSLATIONS.put("game.round.draft", "Both players selected the same figure. DRAFT!");
    }

    @Override
    public String getMessage(final String code, final Object... params){
        if (code == null){
            return StringUtils.EMPTY_STRING;
        }

        if (!TRANSLATIONS.containsKey(code)){
            return code;
        }

        final String rawMessage = TRANSLATIONS.get(code);
        return StringUtils.replaceString(rawMessage, params);
    }

    @Override
    public String getMessage(final String code){
        return getMessage(code, EMPTY_PARAMS);
    }

}
