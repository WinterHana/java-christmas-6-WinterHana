package christmas.domain.event;

import java.util.HashMap;
import java.util.Map;

public class GiftEvent implements Event {
    private Map<Gift, Integer> gifts;

    public GiftEvent(int price) {
        gifts = new HashMap<>();
        giveChampagne(price);
    }

    private void giveChampagne(int price) {
        if (price >= Gift.CHAMPAGNE.getPrice()) {
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
}
