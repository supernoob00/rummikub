public enum Command {
    QUIT("quit", "quit"),
    START("start", "start"),
    PASS("pass", "p"),
    BOARD("board", "b"),
    RACK("rack", "r"),
    SET("set", "s"),
    MOVE("move", "m"),
    SPLIT("split", "sp");

    private String full;
    private String letter;

    private Command(String full, String letter) {
        this.full = full;
        this.letter = letter;
    }
    
    public String getFull() {
        return this.full;
    }

    public String getShort() {
        return this.letter;
    }

    public boolean equals(String userInput) {
        
    }
}
