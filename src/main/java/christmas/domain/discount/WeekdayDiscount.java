package christmas.domain.discount;

public class WeekdayDiscount extends Discount {
    private int dessert;    // dessert : 디저트 메뉴의 개수를 입력 받음
    public WeekdayDiscount(int dessert) {
        discountPrice = DiscountPrice.WEEKDAY_DISCOUNT.getDiscount();
        this.dessert = dessert;
    }


    @Override
    public int discount(int price) {
        return price - (dessert * discountPrice);
    }
}
