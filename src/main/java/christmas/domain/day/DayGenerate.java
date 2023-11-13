package christmas.domain.day;

/**
 * 날짜를 입력받을 때, 예외 처리는 여기서 한다.
 */
public class DayGenerate {
    private Day day;

    public DayGenerate(String inputDay) {
        day = new Day(Integer.parseInt(inputDay));
    }

    /**
     * 예외 처리하기...
     */
}
