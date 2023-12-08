package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    //2. 컴퓨터로 부터 임의의 숫자 입력 받기
    //2-1. 입력 받은 값 변수에 저장

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;

    public List<Integer> pickRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
