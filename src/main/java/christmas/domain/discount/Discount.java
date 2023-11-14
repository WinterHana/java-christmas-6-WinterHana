package christmas.domain.discount;

public interface Discount {
    default int discount(int price, int number) {
        return price;
    }

    default int discount(int price) {
        return price;
    }
}
