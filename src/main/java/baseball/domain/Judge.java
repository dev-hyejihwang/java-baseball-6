package baseball.domain;

import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

public class Judge {

    private static final int RESULT_YN_Y = 1;
    private static final int RESULT_YN_N = 0;
    private int computerNumber;
    private int playerNumber;



    public Judge(int pickRandomNumber, int playerNumber) {
        this.computerNumber = pickRandomNumber;
        this.playerNumber = playerNumber;
    }

    public void process() {
        //4. 심판 결과 해석
        String inputComputer = String.valueOf(computerNumber);
        String inputPlayer = String.valueOf(playerNumber);
        int strikeCount = 0;
        int ballCount = 0;
        for(int i = 0 ; i < inputComputer.length() ; i++){
            String computerCharNumber = String.valueOf(inputComputer.charAt(i));
            for(int j = 0 ; j < inputPlayer.length() ; j++){
                String playerCharNumber = String.valueOf(inputPlayer.charAt(j));
                //4-1. 스타라이크 개수 체크
                strikeCount += getStrikeYN(computerCharNumber, playerCharNumber, i, j);
                //4-2. 볼 개수 체크
                ballCount += getBallYN(computerCharNumber, playerCharNumber, i, j);
            }
        }

        //4.3. 게임 결과 출력을 위해 결과 전달

    }

    private int getStrikeYN(String computerCharNumber, String playerCharNumber, int i, int j) {
        if(computerCharNumber.equals(playerCharNumber) && i == j){
            return RESULT_YN_Y;
        }

        return RESULT_YN_N;
    }

    private int getBallYN(String computerCharNumber, String playerCharNumber, int i, int j) {
        if(computerCharNumber.equals(playerCharNumber) && i != j){
            return RESULT_YN_Y;
        }

        return RESULT_YN_N;
    }
}
