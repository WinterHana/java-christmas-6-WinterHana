package christmas.domain.discount;

public class WeekendDiscount implements Discount {
    private int discountPrice;

    public WeekendDiscount() {
        discountPrice = DiscountPrice.WEEKEND_DISCOUNT.getDiscount();
    }

    // main : 메인 메뉴의 개수를 입력받음
    @Override
    public int discount(int price, int main) {
        return price - (main * discountPrice);
    }
}
