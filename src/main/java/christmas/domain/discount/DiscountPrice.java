package christmas.domain.discount;

public enum DiscountPrice {
    /*
    할인 되는 액수 단위를 입력한다.
    예시 ) 크리스마스 할인일 경우, 100원씩 할인이 되므로 100을 입력한다.
    */
    CHRISMAS_DISCOUNT(100),
    SPECIAL_DISCOUNT(1000),
    WEEKDAY_DISCOUNT(2023),
    WEEKEND_DISCOUNT(2023);

    private int discount;

    DiscountPrice(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }
}
