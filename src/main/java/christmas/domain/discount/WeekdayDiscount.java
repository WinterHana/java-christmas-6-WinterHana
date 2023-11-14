package christmas.domain.discount;

public class WeekdayDiscount implements Discount {
    private int discountPrice;
    private int totalDiscount;     // 할인 가격을 계산해서 저장
    private int dessert;
    public WeekdayDiscount(int dessert) {
        discountPrice = DiscountPrice.WEEKDAY_DISCOUNT.getDiscount();
        discount(dessert);
    }

    // dessert : 디저트 메뉴의 개수를 입력 받음
    @Override
    public void discount(int dessert) {
        totalDiscount = dessert * discountPrice;
    }

    @Override
    public int getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public String toString() {
        return "평일 할인 : -" + totalDiscount  + "원";
    }
}
