package christmas.util;

import java.util.Date;

public enum DateRange {
    DECEMBER(1, 31);

    private int start;
    private int end;

    DateRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
