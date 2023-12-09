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

        //1. 게임 시작 문구 출력
        outputView.printStartMessage();

        boolean gameRestartYN = true;
        while(gameRestartYN){
            //2. 컴퓨터로 부터 임의의 숫자 입력 받기
            Computer computer = new Computer();
            List<Integer> pickRandomNumber = computer.pickRandomNumber();

            //3. 게임 플레이어 숫자 입력
            Player player = new Player(inputView);
            // int playerNumber = player.getPlayerNumber();

            //4. 심판 결과 해석
            //5. 게임 결과 출력
            //6. 게임 종료 여부 입력
            Judge judge = new Judge(player, outputView, result, pickRandomNumber);
            gameRestartYN = judge.process();
        }




    }
}
