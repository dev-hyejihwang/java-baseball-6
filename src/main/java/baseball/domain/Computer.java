package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;
    private final static int COMPUTER_NUMBER_SIZE = 3;

    public List<Integer> pickRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
