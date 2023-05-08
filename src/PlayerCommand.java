public enum PlayerCommand {
    QUIT("quit"),
    START("start"),
    PASS("pass"),
    BOARD("board"),
    RACK("rack"),
    SET("set"),
    MOVE("move"),
    SPLIT("split");

    public static PlayerCommand getCommand(String userInput) {
        for (PlayerCommand c : PlayerCommand.values()) {
            if (c.getText() == userInput) {
                return c;
            }
        }
        return null;
    }

    private String full;

    private PlayerCommand(String full) {
        this.full = full;
    }
    
    public String getText() {
        return this.full;
    }
}
