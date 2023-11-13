package christmas.domain.discount;

public class ChristmasDiscount extends Discount {
    public ChristmasDiscount() {
        discountPrice = DiscountPrice.CHRISMAS_DISCOUNT.getDiscount();
    }

    // day : 1일부터 25일까지 입력을 받음
    @Override
    public int discount(int price, int day) {
        return price - (day - 1) * discountPrice;
    }
}
