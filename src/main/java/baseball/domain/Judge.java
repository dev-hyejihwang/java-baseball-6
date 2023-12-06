package baseball.domain;

import baseball.ui.OutputView;

public class Judge {

    private static final int RESULT_YN_Y = 1;
    private static final int RESULT_YN_N = 0;
    private OutputView outputView;
    private int computerNumber;
    private int playerNumber;

    public Judge(OutputView outputView, int pickRandomNumber, int playerNumber) {
        this.outputView = outputView;
        this.computerNumber = pickRandomNumber;
        this.playerNumber = playerNumber;
    }

    public void process() {
        //4. 심판 결과 해석
        String inputComputer = String.valueOf(computerNumber);
        String inputPlayer = String.valueOf(playerNumber);
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < inputComputer.length(); i++) {
            String computerCharNumber = String.valueOf(inputComputer.charAt(i));
            for (int j = 0; j < inputPlayer.length(); j++) {
                String playerCharNumber = String.valueOf(inputPlayer.charAt(j));
                boolean sameDigitYN = getSameDigitYN(i,j);
                boolean sameNumberYN = getSameNumberYN(computerCharNumber, playerCharNumber);
                //4-1. 스타라이크 개수 체크
                if(sameNumberYN){
                    strikeCount += getStrikeCount(sameDigitYN);
                    //4-2. 볼 개수 체크
                    ballCount += getBallCount(sameDigitYN);
                }

                //4.3. 게임 결과 출력을 위해 결과 전달
                outputView.printGameResult(strikeCount, ballCount);
            }
        }



        //5-2. 3스트라이크가 아닌 경우 게임 반복
        //5-3. 3스트라이크인 경우 게임 종료 여부 체크

    }

    private boolean getSameDigitYN(int i, int j) {
        if(i == j){
            return true;
        }
        return false;
    }

    private int getStrikeCount(boolean sameDigitYN) {
        int strikeCount = 0;
        if (sameDigitYN) {
            strikeCount++;
        }
        return strikeCount;
    }
    private int getBallCount(boolean sameDigitYN) {
        int ballCount = 0;
        if (sameDigitYN) {
            ballCount++;
        }
        return ballCount;
    }

    private boolean getSameNumberYN(String computerCharNumber, String playerCharNumber) {
        if (computerCharNumber.equals(playerCharNumber)) {
            return true;
        }
        return false;
    }
}
