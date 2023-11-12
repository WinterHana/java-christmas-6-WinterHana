package christmas.domain.discount;

public class WeekendDiscount extends Discount {
    @Override
    public int discount(int price, int number) {
        return 0;
    }
}
