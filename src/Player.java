public class Player {
    private String playerName;
    private TileCollection playerTiles;

    public Player(String name) {
        this.playerName = name;
        this.playerTiles = new TileCollection();
    }

    public Player() {
        this.playerTiles = new TileCollection();
    }

    public String getName() {
        return this.playerName;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public TileCollection getTileCollection() {
        return this.playerTiles;
    }
}
