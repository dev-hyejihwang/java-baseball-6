package baseball.domain;

import baseball.ui.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest extends NsTest {

    InputView inputView = new InputView();
    Player player = new Player(inputView);

    @Test
    @DisplayName("입력 받은 값이 숫자가 아닌 경우 예외가 발생한다.")
    void notNumberTest(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("문자"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        player.process();
    }
}