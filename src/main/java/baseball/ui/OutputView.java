package baseball.ui;

public class OutputView {
    //1. 게임 시작 문구 출력
    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    //5. 게임 결과 출력
    //5-1. 게임 결과 출력
    public void printGameResult(int strikeCount, int ballCount) {
        if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
            return;
        }

        if(ballCount > 0){
            System.out.println(ballCount + "볼\n");
        }
        if(strikeCount > 0){
            System.out.println(strikeCount + "스트라이크");
        }
    }



    //6. 게임 종료 여부 입력
    //6-1. 종료 여부 메세지 출력
    //6-2. 종료 여부 숫자 입력 받기
    //6-3. 입력 값이 숫자인지 체크
    //6-4. 입력 값이 1,2 인지 체크
    //6-5. 입력 값이 1인 경우 재시작
    //6-6. 입력 값이 2인 경우 게임 종료
}
