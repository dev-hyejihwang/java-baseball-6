package baseball;

import baseball.domain.Computer;
import baseball.domain.Judge;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.ui.InputView;
import baseball.ui.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Result result = new Result();
        Computer computer = new Computer();
        Player player = new Player(inputView);

        boolean gameRestartYN = true;
        while(gameRestartYN){
            outputView.printStartMessage();
            List<Integer> pickRandomNumber = computer.pickRandomNumber();
            Judge judge = new Judge(player, outputView, result, pickRandomNumber);
            gameRestartYN = judge.process();
        }

        outputView.printEndMessage();
    }
}
