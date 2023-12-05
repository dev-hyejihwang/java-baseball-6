# 미션 - 숫자 야구 구현 기능 목록

## 숫자 야구 게임 시작 문구 출력 기능 
### ui.OutputView
- printStartMessage
    - [X] '숫자 야구 게임을 시작합니다.' 문구를 출력한다.

## 컴퓨터 임의의 숫자 선택 기능 
### domain.Computer
- pickRandomNumber
    - [X] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`의 `pickNumberInRange()`를 활용한다.
    - [X] 입력 받은 숫자를 int 변수에 저장한다.

## 게임 플레이어 숫자 입력 기능 
### domain.Player
- validatePlayerNumber
    - [X] 입력 받은 값이 숫자인지 체크 후 숫자가 아니면 예외를 발생시킨다.
    - [X] 입력 받은 값이 3자리인지 체크 후 3자리가 아니면 예외를 발생시킨다.
### ui.InputView
- inputPlayerNumber
    - [X] 게임 플레이어로 부터 3자리 숫자를 입력 받아 int 변수에 저장한다.

## 스트라이크 개수 체크 기능 
### domain.Judge
- getStrikeCount
    - [] 컴퓨터의 숫자와 게임 플레이어의 숫자의 같은 자리를 비교하여 같은 자리인 숫자가 동일한 경우 count++ 처리한다.

## 볼 개수 체크 기능 
### domain.Judge
- getBallCount
    - [] 컴퓨터의 숫자를 반복하며 게임 플레이어의 숫자에 해당 값이 있는 경우 count++ 처리한다.

## 게임 결과 출력 기능 
### ui.OutputView
- printGameResult
    - [] 스트라이크 개수와 볼 개수를 전달 받아 게임 결과를 출력한다.
    - [] 3스트라이크 인 경우 게임 결과 호출 후 게임 종료 여부 함수를 호출한다.

## 게임 종료 여부 체크 기능 
### domain.Player
- getGameContinueYN
    - [] 게임 종료 여부 메세지를 출력한다.
    - [] 게임 종료 여부 숫자를 입력 받는다.
    - [] 입력 받은 값이 숫자가 아닌 경우 예외를 발생시킨다.
    - [] 입력 받은 값이 1,2 가 아닌 경우 예외를 발생시킨다.
    - [] 입력 받은 값이 1인 경우 게임을 재시작 한다.
    - [] 입력 받은 값이 2인 경우 게임을 종료한다.

## 출력 메세지 관리 기능 
### ui.OutputView
- printGameContinueMessage
    - [] '게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.' 메세지를 출력한다.

## 게임 종료 여부 선택 기능 
### ui.InputView
- inputGameContinueYN
    - [] 게임 재시작 시 1, 게임 종료 시 2를 입력받는다.

## 예외 상황 출력 기능 
### ui.OutputView
- [] 각 함수의 예외 메세지를 출력한다.

## 예외 코드 관리 기능 
### error.ErrorCode
- [X] 각 함수의 예외 메세지를 관리한다.