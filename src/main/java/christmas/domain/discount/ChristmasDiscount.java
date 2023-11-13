package christmas.domain.discount;

public class ChristmasDiscount extends Discount {
    private int day;    // day : 1일부터 25일까지 입력을 받음

    public ChristmasDiscount(int day) {
        discountPrice = DiscountPrice.CHRISMAS_DISCOUNT.getDiscount();
        if(day >= 1 && day <= 25) {
            this.day = day;
        }
    }

    @Override
    public int discount(int price) {
        return price - (day - 1) * discountPrice;
    }
}
