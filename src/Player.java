public class Player {
    private String playerName;
    private TileCollection playerTiles;

    public Player(String name) {
        this.playerName = name;
        this.playerTiles = new TileCollection();
    }

    public String getName() {
        return this.playerName;
    }

    public TileCollection getPlayerTiles() {
        return this.playerTiles;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public void setPlayerTiles(TileCollection tiles) {
        this.playerTiles = tiles;
    }
}
