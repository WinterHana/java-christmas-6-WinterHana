package christmas.domain.discount;

public interface Discount {
    default void discount() {
        return;
    }

    default void discount(int nunber) {
        return;
    }

    int getTotalDiscount();
}
