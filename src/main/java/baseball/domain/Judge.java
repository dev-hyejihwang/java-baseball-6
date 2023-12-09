package baseball.domain;

import baseball.error.ErrorCode;
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
        //4. 심판 결과 해석
        boolean gameContinueYN = true;
        while (gameContinueYN){
            resetResultCount();
            outputView.printInputPlayerMessage();
            String inputPlayer = String.valueOf(player.getPlayerNumber());
            judge(inputPlayer);

            //4.3. 게임 결과 출력을 위해 결과 전달
            outputView.printGameResult(result);

            //5-2. 3스트라이크가 아닌 경우 게임 반복
            gameContinueYN = getGameWinYN();

        }

        //5-3. 3스트라이크인 경우 게임 종료 여부 체크
        return gameContinueProcess();
    }

    private void resetResultCount() {
        result.setStrikeCount(RESULT_RESET);
        result.setStrikeCount(RESULT_RESET);
    }

    private void judge(String inputPlayer) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            String computerNumber = computerNumbers.get(i).toString();
            System.out.println(computerNumber);
            for (int j = 0; j < inputPlayer.length(); j++) {
                String playerCharNumber = String.valueOf(inputPlayer.charAt(j));
                boolean sameDigitYN = getSameDigitYN(i,j);
                boolean sameNumberYN = getSameNumberYN(computerNumber, playerCharNumber);
                //4-1. 스타라이크 개수 체크
                if(sameNumberYN){
                    addStrikeCount(sameDigitYN);
                    //4-2. 볼 개수 체크
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
        //6-2. 종료 여부 숫자 입력 받기
        int continueNumber = player.getContinueNumber();

        //6-4. 입력 값이 1,2 인지 체크
        if(continueNumber != GAME_CONTINUE_Y && continueNumber != GAME_CONTINUE_N){
            throw new IllegalArgumentException(INVALID_INPUT_RANGE.getMessage());
        }

        //6-5. 입력 값이 1인 경우 재시작
        //6-6. 입력 값이 2인 경우 게임 종료
        return getContinueYN(continueNumber);
    }

    private boolean getContinueYN(int continueNumber) {
        if(continueNumber == GAME_CONTINUE_Y){
            return true;
        }
        return false;
    }

}
