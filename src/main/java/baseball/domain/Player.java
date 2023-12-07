package baseball.domain;

import baseball.ui.InputView;

import static baseball.error.ErrorCode.INVALID_INPUT_DIGIT;
import static baseball.error.ErrorCode.INVALID_INPUT_NUMBER;

public class Player {
    //3. 게임 플레이어 숫자 입력
    //3-1. 3자리 숫자 입력 받기
    //3-2. 입력 값이 숫자인지 체크
    //3-3. 입력 값이 3자리인지 체크
    InputView inputView;
    public Player(InputView inputView) {
        this.inputView = inputView;
    }
    public int getPlayerNumber(){
        return validatePlayerNumber();
    }

    private int validatePlayerNumber() {
        try{
            String inputNumber= inputView.inputPlayerNumber();
            int playerNumber = Integer.parseInt(inputNumber);
            checkNumberDigit(inputNumber);
            return playerNumber;
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
    }

    private void checkNumberDigit(String inputNumber) {
        if(inputNumber.length() != 3){
            throw new IllegalArgumentException(INVALID_INPUT_DIGIT.getMessage());
        }
    }

    public int getContinueNumber(){
        //6-3. 입력 값이 숫자인지 체크
        try{
            return Integer.parseInt(inputView.inputPlayerNumber());
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
    }
}
