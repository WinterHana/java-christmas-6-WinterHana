package christmas.domain.discount;

public abstract class Discount {
    protected int discountPrice;

    public abstract int discount(int price, int number);
}
