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

    public GameInterface getInterface() {
        return this.gi;
    }

    private void setActivePlayer(Player player) {
        this.activePlayer = player;
    }

    public GameController(Game game) {
        this.game = new Game(4);
        this.activePlayer = game.getPlayers().get(0);
        this.gi = new GameInterface();
    }
    
    public void playGame() {
        int playerCount = gi.getPlayerCount();

        boolean tileBagNotEmpty = !game.getTileBag().isEmpty();
        boolean noEmptyRacks = !game.anyEmptyRack();
        // main game loop
        while (tileBagNotEmpty && noEmptyRacks) {

        }
    }

    private void switchActivePlayer() {
        int currentIndex = game.getPlayers().indexOf(activePlayer);
        int playerCount = game.getPlayers().size();
        Player lastPlayer = game.getPlayers().get(playerCount - 1);
        if (getActivePlayer() == lastPlayer) {
            Player firstPlayer = game.getPlayers().get(0);
            setActivePlayer(firstPlayer);
        }
        else {
            Player nextPlayer = game.getPlayers().get(currentIndex + 1);
            setActivePlayer(nextPlayer);
        }
    }

    private void playTurn(Player activePlayer) {
        getInterface().showBoardTiles(game.getGameBoard());
        getInterface().showPlayerTiles(activePlayer);
    }

    public void makeMove(Player activePlayer) {
        PlayerCommand playerCommand = gi.getPlayerCommand();
        if (playerCommand == playerCommand.PASS) {
            game.drawTile(activePlayer);
        }
        else if (playerCommand == playerCommand.BOARD) {
            int 
        }
        else if (playerCommand == playerCommand.RACK) {

        }


        }
    }
}
