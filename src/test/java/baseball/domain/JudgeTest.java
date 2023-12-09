package baseball.domain;

import baseball.ui.InputView;
import baseball.ui.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JudgeTest extends NsTest {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Player player = new Player(inputView);
    Result result = new Result();
    @Test
    @DisplayName("입력 받은 값이 숫자가 아닌 경우 예외가 발생한다.")
    void notNumberTest(){
//        Judge judge = new Judge(player, outputView, result, 480);
//        judge.process();
    }



    @Override
    public void runMain() {
//        Judge judge = new Judge(player, outputView, result, 123);
//        judge.process();
    }
}