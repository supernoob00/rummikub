public class GameController {

    private Game game;
    private Player activePlayer;
    private GameInterface gi;

    public Game getGame() {
        return this.game;
    }

    public Player getActivePlayer() {
        return this.activePlayer;
    }

    private void setActivePlayer(Player player) {
        this.activePlayer = player;
    }

    public GameController(Game game) {
        this.game = new Game(4);
        this.activePlayer = game.getPlayers().getPlayer(0);
        this.gi = new GameInterface();
    }
    
    public void playGame() {
        int playerCount = gi.getNumberOfPlayers();

        boolean tileBagNotEmpty = !game.getTileBag().isEmpty();
        boolean noEmptyRacks = !game.getPlayers().hasPlayerWithNoTiles();
        // main game loop
        while (tileBagNotEmpty && noEmptyRacks) {

        }
    }

    private void switchActivePlayer() {
        int currentIndex = game.getPlayers().indexOf(activePlayer);
        int playerCount = game.getPlayers().size();
        Player firstPlayer = game.getPlayers().get(0);
        Player lastPlayer = game.getPlayers().get(playerCount - 1);
        if (getActivePlayer() == lastPlayer) {
            setActivePlayer(firstPlayer);
        }
        else {
            Player nextPlayer = game.getPlayers().getPlayer(currentIndex + 1);
            setActivePlayer(nextPlayer);
        }
    }

    private void playTurn(Player activePlayer) {
        this.gi.showBoardTiles(game.getGameBoard());
        this.gi.showPlayerTiles(activePlayer);
    }
}
