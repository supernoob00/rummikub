import java.util.List;

public class Run {
    public static boolean isRun(TileSet tiles) {
        boolean isSet = hasRequiredQuantity(tiles) && hasSameColors(tiles) && hasSequentialValues(tiles) && noMisplacedJokersInRun(tiles);
        return isSet;
    }

    public static boolean hasRequiredQuantity(TileSet tiles) {
        boolean isRequiredLength = tiles.getQuantity() >= 3;
        return isRequiredLength;
    }

    // A run must be a sequence of numbers that increment by one
    public static boolean hasSequentialValues(TileSet tiles) {
        // start from first non-joker tile for easier condition checking
        int firstIndex = tiles.getNonJokerIndex();
        int currentTileNum = tiles.getTile(firstIndex).getValue().getNum();
        int nextTileNum;
        boolean diffIsOne;
        for (int i = firstIndex; i < tiles.getQuantity() - 1; i++) {
            if (tiles.getTile(i+1) == Tile.JOKER) {
                nextTileNum = currentTileNum + 1;
            }
            else {
                nextTileNum = tiles.getTile(i+1).getValue().getNum();
            }
            diffIsOne = (nextTileNum - currentTileNum == 1);
            currentTileNum = nextTileNum;
            if (!diffIsOne) {
                return false;
            }
        }
        return true;
    }

    // A run must have the same color
    public static boolean hasSameColors(TileSet tiles) {
        // start from first non-joker tile for easier condition checking
        int startIndex = tiles.getNonJokerIndex();
        List<Color> colors = tiles.getColors();
        Color firstTileColor = colors.get(startIndex);
        for (int i = startIndex; i < tiles.getQuantity(); i++) {
            if (colors.get(i) != firstTileColor && colors.get(i) != Color.JOKER) {
                return false;
            }
        }
        return true;
    }

    // A run cannot have a joker before a 1 or after a 13
    public static boolean noMisplacedJokersInRun(TileSet tiles) {
        boolean jokerAtIndexZero = (tiles.getTile(0) == Tile.JOKER);
        boolean oneAtIndexOne = (tiles.getTile(1).getValue() == Value.ONE);
        boolean jokerAtEnd = (tiles.getTile(tiles.getQuantity() - 1) == Tile.JOKER);
        boolean thirteenAtOneBeforeLastIndex = (tiles.getValues().get(tiles.getQuantity() - 2) == Value.THIRTEEN);
        return !(jokerAtIndexZero && oneAtIndexOne) && !(jokerAtEnd && thirteenAtOneBeforeLastIndex);
    }
}

