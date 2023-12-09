package baseball.ui;

import baseball.domain.Result;

public class OutputView {
    //1. 게임 시작 문구 출력
    public void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputPlayerMessage(){
        System.out.println("숫자를 입력해주세요 : ");
    }

    //5. 게임 결과 출력
    //5-1. 게임 결과 출력
    public void printGameResult(Result result) {
        if(result.getStrikeCount() == 0 && result.getBallCount() == 0){
            System.out.println("낫싱");
            return;
        }

        if(result.getBallCount() > 0){
            System.out.println(result.getBallCount() + "볼 ");
        }
        if(result.getStrikeCount() > 0){
            System.out.println(result.getStrikeCount() + "스트라이크");
        }
    }


    public void printContinue() {
        //6-1. 종료 여부 메세지 출력
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }



}
