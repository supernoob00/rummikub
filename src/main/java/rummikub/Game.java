import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int START_DEAL_COUNT = 14;
    public static final int MIN_PLAYER_COUNT = 2;
    public static final int MAX_PLAYER_COUNT = 4;

    private TileSet tileBag;
    private TileCollection gameBoard;
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

        //initialize players
        this.players = new ArrayList<Player>(playerCount);

        // add players
        for (int i = 0; i < playerCount; i++) {
            String playerName = "Player " + Integer.toString(i+1);
            Player player = new Player(playerName);
            this.players.add(player);
        }
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

    public void drawTile(Player player) {
        Tile drawnTile = tileBag.removeLastTile();
        player.getTiles().addTile(drawnTile);
    }

    public boolean anyEmptyRack() {
        for (Player player : getPlayers()) {
            if (player.getTiles().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean isOver() {
        boolean tileBagNotEmpty = getTileBag().isEmpty();
        boolean noEmptyRacks = anyEmptyRack();
        return (!tileBagNotEmpty && !noEmptyRacks);
    }

    public void dealStartingTiles() {
        List<Player> players = getPlayers();
        for (Player player : players) {
            TileSet tilesToDeal = getTileBag().removeTiles(START_DEAL_COUNT);
            player.getTiles().addTileSet(tilesToDeal);
        }
    }

       
}
