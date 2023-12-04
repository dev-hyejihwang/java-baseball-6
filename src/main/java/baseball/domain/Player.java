package baseball.domain;

import baseball.ui.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    //3. 게임 플레이어 숫자 입력
    //3-1. 3자리 숫자 입력 받기
    //3-2. 입력 값이 숫자인지 체크
    //3-3. 입력 값이 3자리인지 체크
    InputView inputView;
    public Player(InputView inputView) {
        this.inputView = inputView;
    }
    public void process(){
        int playerNumber = validatePlayerNumber();

    }

    private int validatePlayerNumber() {
        try{
            Integer.parseInt(inputView.inputPlayerNumber());
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return 0;
    }
}
