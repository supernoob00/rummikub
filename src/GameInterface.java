import java.util.Scanner;

public class GameInterface {
    private Scanner s;

    public GameInterface() {
        s = new Scanner(System.in);
    }

    public void showPlayerTiles(Player player) {
        System.out.println("Your tiles: ");
        System.out.println(player.getTileCollection().toString());
    }

    public void showBoardTiles(GameBoard board) {
        System.out.println("Board tiles: ");
        System.out.println(board.toString());
    }

    public int getNumberOfPlayers() {
        int numOfPlayers = getUserInt("Enter number of players: ");
        return numOfPlayers;
    }

    public String getPlayerName() {
        String name = getUserString("Enter your name: ");
        return name;
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