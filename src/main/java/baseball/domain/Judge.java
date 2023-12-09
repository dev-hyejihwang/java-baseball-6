package baseball.domain;

import baseball.ui.OutputView;
import java.util.List;

import static baseball.error.ErrorCode.INVALID_INPUT_RANGE;

public class Judge {
    private static final int RESULT_RESET = 0;
    private static final int GAME_CONTINUE_Y = 1;
    private static final int GAME_CONTINUE_N = 2;
    private static final int ALL_STRIKE = 3;
    private Player player;
    private OutputView outputView;
    private Result result;
    private List<Integer> computerNumbers;

    public Judge(Player player, OutputView outputView, Result result, List<Integer> pickRandomNumbers) {
        this.player = player;
        this.outputView = outputView;
        this.result = result;
        this.computerNumbers = pickRandomNumbers;
    }

    public boolean process() {
        boolean gameContinueYN = true;

        while (gameContinueYN){
            resetResultCount();
            outputView.printInputPlayerMessage();
            String inputPlayer = String.valueOf(player.getPlayerNumber());
            judge(inputPlayer);
            outputView.printGameResult(result);
            gameContinueYN = getGameWinYN();
        }

        return gameContinueProcess();
    }

    private void resetResultCount() {
        result.setStrikeCount(RESULT_RESET);
        result.setStrikeCount(RESULT_RESET);
    }

    private void judge(String inputPlayer) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            String computerNumber = computerNumbers.get(i).toString();

            for (int j = 0; j < inputPlayer.length(); j++) {
                String playerCharNumber = String.valueOf(inputPlayer.charAt(j));
                boolean sameDigitYN = getSameDigitYN(i,j);
                boolean sameNumberYN = getSameNumberYN(computerNumber, playerCharNumber);

                if(sameNumberYN){
                    addStrikeCount(sameDigitYN);
                    addBallCount(sameDigitYN);
                }
            }
        }
    }

    private boolean getSameDigitYN(int i, int j) {
        if(i == j){
            return true;
        }
        return false;
    }

    private void addStrikeCount(boolean sameDigitYN) {
        int strikeCount = result.getStrikeCount();
        if (sameDigitYN) {
            strikeCount++;
            result.setStrikeCount(strikeCount);
        }
    }

    private void addBallCount(boolean sameDigitYN) {
        int ballCount = result.getBallCount();
        if (!sameDigitYN) {
            ballCount++;
            result.setBallCount(ballCount);
        }
    }

    private boolean getSameNumberYN(String computerCharNumber, String playerCharNumber) {
        if (computerCharNumber.equals(playerCharNumber)) {
            return true;
        }
        return false;
    }

    private boolean getGameWinYN() {
        if(result.getStrikeCount() == ALL_STRIKE){
            return false;
        }
        return true;
    }

    private boolean gameContinueProcess() {
        outputView.printContinue();
        int continueNumber = player.getContinueNumber();

        if(continueNumber != GAME_CONTINUE_Y && continueNumber != GAME_CONTINUE_N){
            throw new IllegalArgumentException(INVALID_INPUT_RANGE.getMessage());
        }

        return getContinueYN(continueNumber);
    }

    private boolean getContinueYN(int continueNumber) {
        if(continueNumber == GAME_CONTINUE_Y){
            return true;
        }
        return false;
    }
}
