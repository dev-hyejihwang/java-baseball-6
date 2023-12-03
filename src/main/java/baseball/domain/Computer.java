package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    //2. 컴퓨터로 부터 임의의 숫자 입력 받기
    //2-1. 입력 받은 값 변수에 저장

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;

    public int pickRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
