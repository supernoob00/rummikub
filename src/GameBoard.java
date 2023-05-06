public class GameBoard extends TileCollection {
    public GameBoard() {

    }

    // makes sure all tile sets in game board are valid
    public boolean isValid() {
        for (TileSet ts : getTileSets()) {
            if (!TileSetRules.isValid(ts)) {
                return false;
            }
        }
        return true;
    }
}
