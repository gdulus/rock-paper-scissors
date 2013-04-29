package rps.game.engine;

import rps.gui.GUI;
import rps.gui.i18n.MessageProvider;

public final class MainLoop {

    private static final Integer NUMBER_OF_ROUNDS = 20;

    private final GUI gui;

    private final MessageProvider messageProvider;

    private final MainLoopLogic mainLoopLogic;

    public MainLoop(final GUI gui, final MessageProvider messageProvider, final MainLoopLogic mainLoopLogic) {
        this.gui = gui;
        this.messageProvider = messageProvider;
        this.mainLoopLogic = mainLoopLogic;
    }

    public void execute(){
        while(true){
            final MatchType matchType = getMatchType();

            if (matchType != null){
                final MatchScore matchScore = playMatch(matchType);
                displayMatchWinner(matchScore);
            }
        }
    }

    private MatchScore playMatch(final MatchType matchType){
        displayStartingGameHeader();
        Integer round = 1;
        final MatchScore matchScore = new MatchScore();

        while (true){
            try {
                MatchAttender roundWinner = mainLoopLogic.playMatch(matchType, gui, messageProvider);
                displayRoundWinner(roundWinner);
                matchScore.increasePointsFor(roundWinner);

                if (round.equals(NUMBER_OF_ROUNDS)){
                    break;
                }

                round++;
            } catch (final MatchPlayException exception){
                displayMatchPlayError();
            }
        }

        return matchScore;
    }

    private MatchType getMatchType(){
        displayMatchTypeHeader();
        displayGameTypes();
        MatchType matchType = null;

        try {
            matchType =  mainLoopLogic.getMatchType(gui);
        } catch (final MainLoopLogicMatchNullOrEmptyException exception){
            displayMatchNullOrEmptyError();
        } catch (final MainLoopLogicMatchInvalidValueException exception){
            displayMatchMatchInvalidError();
        }

        return matchType;
    }

    private void displayMatchWinner(final MatchScore matchScore){
        if (matchScore.isDraft()){
            gui.pushHeader(messageProvider.getMessage("game.winner.draft"));
            return;
        }

        gui.pushHeader(messageProvider.getMessage("game.winner." + matchScore.getWinner().name(), matchScore.getWinnerPoints()));
    }

    private void displayRoundWinner(final MatchAttender roundWinner){
        if (roundWinner == null){
            gui.pushHeader(messageProvider.getMessage("game.round.draft"));
            return;
        }

        gui.pushInfo(messageProvider.getMessage("game.roundWinner." + roundWinner.name()));
    }

    private void displayMatchPlayError(){
        gui.pushError(messageProvider.getMessage("error.matchPlay"));
    }

    private void displayMatchNullOrEmptyError(){
        gui.pushError(messageProvider.getMessage("error.matchType.empty"));
    }

    private void displayMatchMatchInvalidError(){
        gui.pushError(messageProvider.getMessage("error.matchType.wrongType"));
    }

    private void displayMatchTypeHeader(){
        gui.pushHeader(messageProvider.getMessage("game.selectMatchType"));
    }

    private void displayStartingGameHeader(){
        gui.pushHeader(messageProvider.getMessage("game.startingGame"));
    }

    private void displayGameTypes(){
        for(final MatchType gameType : MatchType.values()){
            final String key = "game.matchTypeDesc." + gameType.name();
            final Object[] params = new Object[]{gameType.getGameTypeId()};
            gui.push(messageProvider.getMessage(key, params));
        }
    }

}
