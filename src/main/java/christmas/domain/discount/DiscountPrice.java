package christmas.domain.discount;

public enum DiscountPrice {
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
