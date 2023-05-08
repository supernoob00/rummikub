import java.util.Scanner;

public class GameInterface {
    private Scanner s;

    public GameInterface() {
        this.s = new Scanner(System.in);
    }

    public void showPlayerTiles(Player player) {
        System.out.println("Your tiles: ");
        System.out.println(player.getTiles().toString());
    }

    public void showBoardTiles(TileCollection board) {
        System.out.println("Board tiles: ");
        System.out.println(board.toString());
    }

    public int getPlayerCount() {
        int numOfPlayers = getUserInt("Enter number of players: ");
        return numOfPlayers;
    }

    public String getPlayerName() {
        String name = getUserString("Enter your name: ");
        return name;
    }

    public PlayerCommand getPlayerCommand() {
        String userString = getUserString("Enter a command: ");
        PlayerCommand userCommand = PlayerCommand.getCommand(userString);
        return userCommand;
    }


    public int getTileSet(TileCollection tc) {
        // index counting starts at 1, not 0 for user interface
        int lastIndex  = tc.getTileSetCount();
        String msg = "Choose a tile set from 1 to " + Integer.toString(lastIndex) + ".";
        int playerChoice = getUserInt(msg);
        boolean playerChoiceInvalid = playerChoice < 1 || playerChoice > lastIndex;

        while (playerChoiceInvalid) {
            System.out.println("Not a valid choice, try again.");
            playerChoice = getUserInt(msg);
            playerChoiceInvalid = playerChoice < 1 || playerChoice > lastIndex;
        }

        return playerChoice;
    }

    private String getUserString(String msg) {
        System.out.println(msg);
        String input = this.s.nextLine();
        return input;
    }

    private int getUserInt(String msg) {
        System.out.println("Enter number of players: ");
        int input = this.s.nextInt();
        return input;
    }
}