public class GameController {

    private Game game;
    private Player activePlayer;
    private GameInterface gi;

    public Player getActivePlayer() {
        return this.activePlayer;
    }

    public GameController(Game game) {
        this.game = new Game(4);
        this.activePlayer = game.getPlayerList().getPlayer(0);
        this.gi = new GameInterface();
    }
    
    public void playGame() {
        int playerCount = gi.getNumberOfPlayers();

        boolean tileBagNotEmpty = !game.getTileBag().isEmpty();
        boolean noEmptyRacks = !game.getPlayerList().hasPlayerWithNoTiles();
        // main game loop
        while (tileBagNotEmpty && noEmptyRacks) {

        }
    }

    private void switchActivePlayer() {
        if ()
    }

    private void playTurn(Player activePlayer) {
        this.gi.showPlayerTiles(activePlayer);

    }
}
