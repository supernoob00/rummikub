import java.util.List;

public class Game {
    public static int START_DEAL_COUNT = 14;

    private TileSet tileBag;
    private PlayerList players;
    private TileCollection gameBoard;

    public Game(int playerCount) {
        // create starting bag of tiles 
        this.tileBag = new TileSet();
        for (Tile tile : Tile.values()) {
            this.tileBag.addTile(tile);
            this.tileBag.addTile(tile);
        }
        this.tileBag.shuffle();

        // initialize game board
        this.gameBoard = new TileCollection();

        //initialize players
        this.players = new PlayerList(playerCount);
    }

    public TileSet getTileBag() {
        return this.tileBag;
    }

    public PlayerList getPlayerList() {
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
        List<Player> players = getPlayerList().getPlayers();
        for (Player player : players) {
            TileSet tilesToDeal = getTileBag().removeNumOfTiles(START_DEAL_COUNT);
            player.getTileCollection().addTileSet(tilesToDeal);
        }
    }
}
