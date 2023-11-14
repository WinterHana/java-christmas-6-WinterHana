package christmas.domain.day;

import christmas.domain.discount.Discount;

import java.util.List;

/**
 * 날짜를 입력받을 때, 예외 처리는 여기서 한다.
 */
public class DiscountGenerator {
    private DayDiscount dayDiscount;

    public DiscountGenerator(String inputDay, int main, int dessert) {
        dayDiscount = new DayDiscount(Integer.parseInt(inputDay), main, dessert);
    }

    public String getDiscountContent() {
        return dayDiscount.getDiscountContent();
    }

    public List<Discount> getDiscounts() {
        return dayDiscount.getDiscounts();
    }

    // 총 혜택 금액을 반환한다.
    public int getTotalDiscountSum() {
        return dayDiscount.getDiscounts()
                .stream()
                .mapToInt(s -> s.getTotalDiscount())
                .sum();
    }

    // 할인 내역에 대하여 반환한다.
    public String getTotalDiscountContent() {
        if(getTotalDiscountSum() <= 0) {
            return "없음";
        }
        StringBuffer stringBuffer = new StringBuffer();
        dayDiscount.getDiscounts().stream().forEach(
               s -> stringBuffer.append(s.toString() + "\n")
        );
        return stringBuffer.toString();
    }


    /**
     * 예외 처리하기...
     */
}
