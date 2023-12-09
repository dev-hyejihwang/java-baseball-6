package baseball.error;

public enum ErrorCode {
    INVALID_INPUT_NUMBER("[ERROR] 숫자를 입력해주세요."),
    INVALID_INPUT_DIGIT("[ERROR] 3자리 숫자를 입력해주세요."),
    INVALID_INPUT_RANGE("[ERROR] 1 또는 2를 입력해주세요.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
