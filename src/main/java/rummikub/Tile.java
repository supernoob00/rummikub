public enum Tile {
    
    RED_ONE(Color.RED, Value.ONE),
    RED_TWO(Color.RED, Value.TWO),
    RED_THREE(Color.RED, Value.THREE),
    RED_FOUR(Color.RED, Value.FOUR),
    RED_FIVE(Color.RED, Value.FIVE),
    RED_SIX(Color.RED, Value.SIX),
    RED_SEVEN(Color.RED, Value.SEVEN),
    RED_EIGHT(Color.RED, Value.EIGHT),
    RED_NINE(Color.RED, Value.NINE),
    RED_TEN(Color.RED, Value.TEN),
    RED_ELEVEN(Color.RED, Value.ELEVEN),
    RED_TWELVE(Color.RED, Value.TWELVE),
    RED_THIRTEEN(Color.RED, Value.THIRTEEN),
    BLACK_ONE(Color.BLACK, Value.ONE),
    BLACK_TWO(Color.BLACK, Value.TWO),
    BLACK_THREE(Color.BLACK, Value.THREE),
    BLACK_FOUR(Color.BLACK, Value.FOUR),
    BLACK_FIVE(Color.BLACK, Value.FIVE),
    BLACK_SIX(Color.BLACK, Value.SIX),
    BLACK_SEVEN(Color.BLACK, Value.SEVEN),
    BLACK_EIGHT(Color.BLACK, Value.EIGHT),
    BLACK_NINE(Color.BLACK, Value.NINE),
    BLACK_TEN(Color.BLACK, Value.TEN),
    BLACK_ELEVEN(Color.BLACK, Value.ELEVEN),
    BLACK_TWELVE(Color.BLACK, Value.TWELVE),
    BLACK_THIRTEEN(Color.BLACK, Value.THIRTEEN),
    BLUE_ONE(Color.BLUE, Value.ONE),
    BLUE_TWO(Color.BLUE, Value.TWO),
    BLUE_THREE(Color.BLUE, Value.THREE),
    BLUE_FOUR(Color.BLUE, Value.FOUR),
    BLUE_FIVE(Color.BLUE, Value.FIVE),
    BLUE_SIX(Color.BLUE, Value.SIX),
    BLUE_SEVEN(Color.BLUE, Value.SEVEN),
    BLUE_EIGHT(Color.BLUE, Value.EIGHT),
    BLUE_NINE(Color.BLUE, Value.NINE),
    BLUE_TEN(Color.BLUE, Value.TEN),
    BLUE_ELEVEN(Color.BLUE, Value.ELEVEN),
    BLUE_TWELVE(Color.BLUE, Value.TWELVE),
    BLUE_THIRTEEN(Color.BLUE, Value.THIRTEEN),
    YELLOW_ONE(Color.YELLOW, Value.ONE),
    YELLOW_TWO(Color.YELLOW, Value.TWO),
    YELLOW_THREE(Color.YELLOW, Value.THREE),
    YELLOW_FOUR(Color.YELLOW, Value.FOUR),
    YELLOW_FIVE(Color.YELLOW, Value.FIVE),
    YELLOW_SIX(Color.YELLOW, Value.SIX),
    YELLOW_SEVEN(Color.YELLOW, Value.SEVEN),
    YELLOW_EIGHT(Color.YELLOW, Value.EIGHT),
    YELLOW_NINE(Color.YELLOW, Value.NINE),
    YELLOW_TEN(Color.YELLOW, Value.TEN),
    YELLOW_ELEVEN(Color.YELLOW, Value.ELEVEN),
    YELLOW_TWELVE(Color.YELLOW, Value.TWELVE),
    YELLOW_THIRTEEN(Color.YELLOW, Value.THIRTEEN),
    JOKER(Color.JOKER, Value.JOKER);

    private Color color;
    private Value value;

    private Tile(Color clr, Value val) {
        this.color = clr;
        this.value = val;
    }

    public Color getColor() {
        return this.color;
    }

    public Value getValue() {
        return this.value;
    }

    public String toString() {
        String tileString;
        if (this == JOKER) {
            tileString = "JOKER";
        }
        else {
            String colorString = getColor().toString();
            String valueString = getValue().toString();
            tileString = colorString + "_" + valueString;
        }
        return tileString;
    }
}