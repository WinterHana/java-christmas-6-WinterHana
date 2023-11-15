package christmas.util;

import java.text.DecimalFormat;

/**
 * 최종 출력되는 가격에 온점을 추가한다.
 */
public class SpotPrice {
    public static String addPriceSpot(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedPrice = decimalFormat.format(price);
        return formattedPrice;
    }
}
