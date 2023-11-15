package christmas.excepton;

import christmas.util.DateRange;
import christmas.util.ErrorMessage;
import christmas.util.RegularExpression;

import java.util.regex.Pattern;

public class InputDayException {
    public void inputDayException(String inputDay) throws IllegalArgumentException {
        int day = notIntegerException(inputDay);
        notDateRangeException(day);

    }
    private int notIntegerException(String inputDay) throws IllegalArgumentException {
        if(!Pattern.matches(RegularExpression.REGEXP_INTEGER.getRegExp(), inputDay)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INVALID_DAY.getMessage());
        }
        return Integer.parseInt(inputDay);
    }

    private void notDateRangeException(int day) throws IllegalArgumentException {
        if(day < DateRange.DECEMBER.getStart()
                || day > DateRange.DECEMBER.getEnd()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INVALID_DAY.getMessage());
        }
    }
}
