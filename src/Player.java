public class Player {
    private String playerName;
    private TileCollection playerTiles;

    public Player(String name) {
        this.playerName = name;
    }

    public Player() {

    }

    public String getName() {
        return this.playerName;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public void setPlayerTiles(TileCollection tiles) {
        this.playerTiles = tiles;
    }
}
