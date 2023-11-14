package christmas.domain.discount;

public class ChristmasDiscount implements Discount {
    private int discountPrice;

    public ChristmasDiscount() {
        discountPrice = DiscountPrice.CHRISMAS_DISCOUNT.getDiscount();

    }

    // day : 1일부터 25일까지 입력을 받음
    @Override
    public int discount(int price, int day) {
        if(day >= 1 && day <= 25) {
            return price - (1000 + (day - 1) * discountPrice);
        }
        return price;
    }
}
