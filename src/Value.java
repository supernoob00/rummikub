public enum Value {
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    ELEVEN(11, "11"),
    TWELVE(12, "12"),
    THIRTEEN(13, "13"),
    JOKER("JOKER");

    private int valueNum;
    private String valueString;

    private Value(int valueNum, String valueString) {
        this.valueNum = valueNum;
        this.valueString = valueString;
    }

    // reserved for joker tile which does not have an associated int
    private Value(String valueString) {
        this.valueString = valueString;
    }

    public int getNum() {
        return this.valueNum;
    }

    public String toString() {
        return this.valueString;
    }
}