package christmas.domain.event;

public class GiftEvent implements Event {
    private Gift gift;

    public GiftEvent(int price) {
        gift = Gift.NOTHING;
        giveChampagne(price);
    }

    private void giveChampagne(int price) {
        if (price >= Gift.CHAMPAGNE.getPrice()) {
            gift = Gift.CHAMPAGNE;
        }
    }

    @Override
    public String eventInfo() {
        return gift.getName();
    }
}
