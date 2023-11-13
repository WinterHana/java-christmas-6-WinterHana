package christmas.domain.discount;

public abstract class Discount {
    /*
    할인 되는 액수 단위를 입력한다.
    예시 ) 크리스마스 할인일 경우, 1000원씩 할인이 되므로 1000을 입력한다.
     */
    protected int discountPrice;

    public abstract int discount(int price);
}
