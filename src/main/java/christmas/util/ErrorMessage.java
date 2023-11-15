package christmas.util;

public enum ErrorMessage {
    NOT_INVALID_DAY("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ORDER_EXCEEDED("[ERROR] 최대 주문량은 20개입니다. 다시 확인해 주세요."),
    ONLY_BEVERAGE("[ERROR] 음료 외의 다른 음료도 주문해야 합니다. 다시 확인해 주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
