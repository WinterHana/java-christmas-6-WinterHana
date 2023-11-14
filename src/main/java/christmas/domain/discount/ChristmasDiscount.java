package christmas.domain.discount;

public class ChristmasDiscount implements Discount {
    private int discountPrice;
    private int totalDiscount;     // 할인 가격을 계산해서 저장
    public ChristmasDiscount(int day) {
        discountPrice = DiscountPrice.CHRISMAS_DISCOUNT.getDiscount();
        discount(day);
    }

    // day : 1일부터 25일까지 입력을 받음
    @Override
    public void discount(int day) {
        totalDiscount = 1000 + (day - 1) * discountPrice;
    }

    @Override
    public int getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public String toString() {
        return "크리스마스 디데이 할인 : -" + totalDiscount + "원";
    }
}
