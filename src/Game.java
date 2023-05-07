import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int START_DEAL_COUNT = 14;

    private TileSet tileBag;
    private TileCollection gameBoard;
    private List<TileCollection> tileRacks;
    private List<Player> players;

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

        // initialize tile racks


        //initialize players
        this.players = new ArrayList<Player>(playerCount);
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

    public List<TileCollection> getTileRacks() {
        return this.tileRacks;
    }

    public getTileRack(int i) {
        return getTileRacks().get(i);
    }

    public boolean
    
    public void run() {
        System.out.println(getTileBag());
        dealStartingTiles();
        System.out.println(getTileBag());
    }

    private void dealStartingTiles() {
        for (TileCollection t) {
            TileSet tilesToDeal = getTileBag().removeNumOfTiles(START_DEAL_COUNT);
            player.getTileCollection().addTileSet(tilesToDeal);
        }
    }

    
}
