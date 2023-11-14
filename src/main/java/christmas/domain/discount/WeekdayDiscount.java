package christmas.domain.discount;

public class WeekdayDiscount implements Discount {
    private int discountPrice;
    private int totalDiscount;     // 할인 가격을 계산해서 저장
    public WeekdayDiscount() {
        discountPrice = DiscountPrice.WEEKDAY_DISCOUNT.getDiscount();
        totalDiscount = 0;
    }

    // dessert : 디저트 메뉴의 개수를 입력 받음
    @Override
    public int discount(int price, int dessert) {
        totalDiscount = dessert * discountPrice;
        return price - totalDiscount;
    }

    @Override
    public String toString() {
        return "평일 할인 : -" + totalDiscount  + "원";
    }
}
