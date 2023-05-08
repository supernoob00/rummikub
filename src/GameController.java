import java.util.List;

public class GameController {

    private Game game;
    private GameInterface gi;

    private Player activePlayer;

    public GameController(Game game, GameInterface gi) {
        this.game = game;
        this.gi = gi;
        this.activePlayer = game.getPlayers().get(0);
    }

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
    
    public void startGame() {
        boolean tileBagNotEmpty = !game.getTileBag().isEmpty();
        boolean noEmptyRacks = !game.anyEmptyRack();

        // welcome message
        gi.showWelcome();

        // deal starting tiles
        System.out.println("Dealing starting tiles...");
        game.dealStartingTiles();

        playTurn(activePlayer);

        // main game loop
        // while (tileBagNotEmpty && noEmptyRacks) {

        // }
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

    /* 
    public void makeMove(Player activePlayer) {
        List<PlayerCommand> firstCommandOptions = List.of(
            PlayerCommand.PASS,
            PlayerCommand.BOARD,
            PlayerCommand.RACK
        );
        PlayerCommand firstCommand = gi.getPlayerCommand(firstCommandOptions);
        if (firstCommand == PlayerCommand.PASS) {
            game.drawTile(activePlayer);
        }
        else if (firstCommand == PlayerCommand.BOARD) {
            TileCollection boardTiles = game.getGameBoard();
            int TileSetIndex = gi.getTileSetIndex(boardTiles);
            List<PlayerCommand> secondCommandOptions = List.of(
                PlayerCommand.MOVE,
                PlayerCommand.SPLIT
            );
            PlayerCommand secondCommand = gi.getPlayerCommand(secondCommandOptions);
        }
        else if (firstCommand == PlayerCommand.RACK) {
            TileCollection playerTiles = activePlayer.getTiles();
            int TileSetIndex = gi.getTileSetIndex(playerTiles);
            List<PlayerCommand> secondCommandOptions = List.of(
                PlayerCommand.MOVE,
                PlayerCommand.SPLIT
            );
            PlayerCommand secondCommand = gi.getPlayerCommand(secondCommandOptions);
        }
    }
    */
}

