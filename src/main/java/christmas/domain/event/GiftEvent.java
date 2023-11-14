package christmas.domain.event;

import christmas.domain.discount.Discount;

import java.util.HashMap;
import java.util.Map;

public class GiftEvent implements Event, Discount {
    private Map<Gift, Integer> gifts;

    public GiftEvent(int price) {
        gifts = new HashMap<>();
        giveChampagne(price);
    }

    private void giveChampagne(int price) {
        if (price >= Gift.CHAMPAGNE.getCriteria()) {
            gifts.put(Gift.CHAMPAGNE, 1);
        }
    }

    @Override
    public String eventInfo() {
        if(gifts.isEmpty()) {
            return Gift.NOTHING.getName();
        }
        StringBuffer stringBuffer = new StringBuffer();
        gifts.entrySet().stream()
                .forEach(gift -> {stringBuffer.append(gift.getKey().getName() + " " + gift.getValue() + "개");
        });
        return stringBuffer.toString();
    }

    @Override
    public int discount(int price) {
        int totalDiscount = gifts
                .entrySet()
                .stream()
                .mapToInt(s -> s.getKey().getPrice() * s.getValue())
                .sum();
        return price - totalDiscount;
    }
}
