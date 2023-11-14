package christmas.domain.event;

/**
 * 할인이 적용되지 않은 총 금액과 할인 혜택 금액을 받아서 Event를 생성한다.
 */
public class EventGenerator {
    private GiftEvent giftEvent;
    private SymbolEvent symbolEvent;

    public EventGenerator(int priceNotDiscount, int totalDiscount) {
        this.giftEvent = new GiftEvent(priceNotDiscount);
        int giftEventDiscount = giftEvent.getTotalDiscount();       // 증정 상품에 대한 혜택 금액 반영
        this.symbolEvent = new SymbolEvent(totalDiscount + giftEventDiscount);
    }

    // 증정 상품에 대한 내용을 반환한다.
    public String getGiftMenuInfo() {
        return giftEvent.eventInfo();
    }

    // 증정 이벤트 혜택 가격을 반환한다.
    public int getGiftEventDiscount() {
        return giftEvent.getTotalDiscount();
    }

    // 증정 이벤트 내역을 반환한다.
    public String getGiftEventContent() {
        if(getGiftEventDiscount() <= 0) {
            return "";
        }
        return giftEvent.toString();
    }

    // 이벤트 뱃지의 내용을 반환한다.
    public String getSymbolEventContent() {
        return symbolEvent.eventInfo();
    }
}
