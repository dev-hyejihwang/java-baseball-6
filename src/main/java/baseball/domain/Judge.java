package baseball.domain;

import baseball.ui.OutputView;

public class Judge {

    private Player player;
    private OutputView outputView;
    private Result result;
    private int computerNumber;

    public Judge(Player player, OutputView outputView, Result result, int pickRandomNumber) {
        this.player = player;
        this.outputView = outputView;
        this.result = result;
        this.computerNumber = pickRandomNumber;
    }

    public void process() {
        //4. 심판 결과 해석
        String inputComputer = String.valueOf(computerNumber);

        boolean gameWinYN = false;
        while (!gameWinYN){
            String inputPlayer = String.valueOf(player.getPlayerNumber());
            judge(inputComputer, inputPlayer);

            //4.3. 게임 결과 출력을 위해 결과 전달
            outputView.printGameResult(result);

            //5-2. 3스트라이크가 아닌 경우 게임 반복
            gameWinYN = getGameWinYN();
        }






    }

    private void judge(String inputComputer, String inputPlayer) {
        for (int i = 0; i < inputComputer.length(); i++) {
            String computerCharNumber = String.valueOf(inputComputer.charAt(i));
            for (int j = 0; j < inputPlayer.length(); j++) {
                String playerCharNumber = String.valueOf(inputPlayer.charAt(j));
                boolean sameDigitYN = getSameDigitYN(i,j);
                boolean sameNumberYN = getSameNumberYN(computerCharNumber, playerCharNumber);
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
        if (sameDigitYN) {
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
        if(result.getStrikeCount() == 3){
            return true;
        }
        return false;
    }
}
