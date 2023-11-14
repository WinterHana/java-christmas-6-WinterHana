package christmas.domain.discount;

public class WeekdayDiscount implements Discount {
    private int discountPrice;

    public WeekdayDiscount() {
        discountPrice = DiscountPrice.WEEKDAY_DISCOUNT.getDiscount();
    }

    // dessert : 디저트 메뉴의 개수를 입력 받음
    @Override
    public int discount(int price, int dessert) {
        return price - (dessert * discountPrice);
    }
}
