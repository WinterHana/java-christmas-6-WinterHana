package christmas.domain.event;

/**
 * 증정 상품에 대한 내용
 */
public enum Gift {
    CHAMPAGNE("샴페인", 120000),
    NOTHING("없음", 0);
    private String name;
    private int price;

    Gift(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
