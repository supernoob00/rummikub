public enum Color {
    RED("RED"),
    BLACK("BLACK"),
    BLUE("BLUE"),
    YELLOW("YELLOW"),
    JOKER("JOKER");

    public static int getColorCount() {
        return 4;
    }

    private String colorString;
    
    private Color(String colorString) {
        this.colorString = colorString;
    }

    public String getColorString() {
        return this.colorString;
    }

    public String toString() {
        return this.colorString;
    }
}