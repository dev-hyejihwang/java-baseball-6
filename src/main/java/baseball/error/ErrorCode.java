package baseball.error;

public enum ErrorCode {
    // 값이 숫자가 아닌 경우 예외 메세지
    INVALID_INPUT_NUMBER("[ERROR] 숫자를 입력해주세요."),
    // 값이 3자리가 아닌 경우 예외 메세지
    INVALID_INPUT_DIGIT("[ERROR] 3자리 숫자를 입력해주세요.");

    // 값이 1,2가 아닌 경우 예외 메세지

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
