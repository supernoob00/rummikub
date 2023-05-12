import java.util.List;
import java.util.Scanner;

public class GameInterface {
    private Scanner s;

    public GameInterface() {
        this.s = new Scanner(System.in);
    }

    public void showWelcome() {
        System.out.println("Welcome to Rummikub!");
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

    public PlayerCommand getPlayerCommand(List<PlayerCommand> options) {
        String userString = getUserString("Enter a command: ");
        showAvailableCommands(options);
        PlayerCommand userCommand = PlayerCommand.getCommand(userString);
        while (!options.contains(userCommand)) {
            System.out.println("Not a valid command, try again");
            userCommand = PlayerCommand.getCommand(userString);
        }
        return userCommand;
    }

    public int getTileSetIndex(TileCollection tc) {
        // index counting starts at 1, not 0 for user interface
        int lastIndex  = tc.getTileSetCount();
        String msg = "Choose a tile set from 1 to " + Integer.toString(lastIndex) + ".";
        int playerChoice = getUserInt(msg);

        while (playerChoice < 1 || playerChoice > lastIndex) {
            System.out.println("Not a valid choice, try again.");
            playerChoice = getUserInt(msg);
        }

        // actual index is one less
        return playerChoice - 1;
    }

    public int getTileIndex(TileSet t) {
        // index counting starts at 1, not 0 for user interface
        int lastIndex  = t.getTileCount();
        String msg = "Choose a tile from 1 to " + Integer.toString(lastIndex) + ".";
        int playerChoice = getUserInt(msg);
        boolean playerChoiceInvalid = playerChoice < 1 || playerChoice > lastIndex;

        while (playerChoiceInvalid) {
            System.out.println("Not a valid choice, try again.");
            playerChoice = getUserInt(msg);
            playerChoiceInvalid = playerChoice < 1 || playerChoice > lastIndex;
        }

        // actual index is one less
        return playerChoice - 1;
    }

    public void showAvailableCommands(List<PlayerCommand> options) {
        System.out.println("Available commands: ");
        for (PlayerCommand option : options) {
            System.out.println(option.getText());
        }
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