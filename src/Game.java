import java.util.List;

public class Game {
    public static int START_DEAL_COUNT = 14;

    private TileSet tileBag;
    private List<Player> players;
    private TileCollection gameBoard;

    public Game(List<Player> p) {
        // create starting bag of tiles 
        this.tileBag = new TileSet();
        for (Tile tile : Tile.values()) {
            this.tileBag.addTile(tile);
            this.tileBag.addTile(tile);
        }
        this.tileBag.shuffle();

        this.players = p;

        // initialize game board
        this.gameBoard = new TileCollection();
    }

    public TileSet getTileBag() {
        return this.tileBag;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public TileCollection getGameBoard() {
        return this.gameBoard;
    }
    
    public void run() {
        System.out.println(getTileBag());
        dealStartingTiles();
        System.out.println(getTileBag());

    }

    private void dealStartingTiles() {
        for (Player player : getPlayers()) {
            TileSet tilesToDeal = getTileBag().removeNumOfTiles(START_DEAL_COUNT);
            player.getTileCollection().addTileSet(tilesToDeal);
        }
    }
}
