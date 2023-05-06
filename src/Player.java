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

    public TileCollection getTiles() {
        return this.playerTiles;
    }
}
