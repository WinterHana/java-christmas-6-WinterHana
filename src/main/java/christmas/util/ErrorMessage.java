package christmas.util;

public enum ErrorMessage {
    NOT_INVALID_DAY("[Error] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_INVALID_ORDER("[Error] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
