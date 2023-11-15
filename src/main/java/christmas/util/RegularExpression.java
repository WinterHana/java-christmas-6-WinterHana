package christmas.util;

public enum RegularExpression {
    REGEXP_INTEGER("^[1-9]\\d*$"),
    REGEXP_PATTERN_MENU("([가-힣]+)-([1-9]\\d*)");

    private String regExp;

    RegularExpression(String regExp) {
        this.regExp = regExp;
    }

    public String getRegExp() {
        return regExp;
    }
}
