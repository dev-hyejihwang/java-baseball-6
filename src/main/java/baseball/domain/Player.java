package baseball.domain;

import baseball.ui.InputView;

import static baseball.error.ErrorCode.INVALID_INPUT_DIGIT;
import static baseball.error.ErrorCode.INVALID_INPUT_NUMBER;

public class Player {
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
        try{
            return Integer.parseInt(inputView.inputPlayerNumber());
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
    }
}
