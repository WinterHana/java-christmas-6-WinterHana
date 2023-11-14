package christmas.domain.discount;

public interface Discount {
    default int discount() {
        return 0;
    }

    default int discount(int nunber) {
        return 0;
    }

    int getTotalDiscount();
}
