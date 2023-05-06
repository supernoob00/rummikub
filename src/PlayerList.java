import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private List<Player> players;

    public PlayerList(int playerCount) {
        players = new ArrayList<Player>(playerCount);
        for (int i = 0; i < playerCount; i++) {
            Player newPlayer = new Player();
            this.players.add(newPlayer);
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Player getPlayer(int i) {
        Player player = getPlayers().get(i);
        return player;
    }

    public boolean hasPlayerWithNoTiles() {
        for (Player player : players) {
            if (player.getTileCollection().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}