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
        // welcome message
        gi.showWelcome();

        // deal starting tiles
        System.out.println("Dealing starting tiles...");
        game.dealStartingTiles();

        do {
            playTurn(activePlayer);
            switchActivePlayer();
        }
        while (!game.isOver());

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
        PlayerCommand firstCommand = gi.getPlayerCommand(List.of(
            PlayerCommand.PASS, 
            PlayerCommand.BOARD, 
            PlayerCommand.RACK));
        if (firstCommand == PlayerCommand.BOARD) {
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
}

