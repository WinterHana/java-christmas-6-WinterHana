package christmas.domain.event;

/**
 * 증정 상품에 대한 내용
 */
public enum Gift {
    CHAMPAGNE("샴페인", 25000, 120000),
    NOTHING("없음", 0, 0);
    private String name;
    private int price;
    private int criteria;

    Gift(String name, int price, int criteria) {
        this.name = name;
        this.price = price;
        this.criteria = criteria;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCriteria() {
        return criteria;
    }
}
