import java.util.List;

public final class Group {
    private Group() {}

    public static boolean isGroup(TileSet tiles) {
        boolean isGroup = hasRequiredQuantity(tiles) 
            && hasSameValue(tiles) 
            && hasUniqueColors(tiles)
            && lessThanFour(tiles);
        return isGroup;
    }

    // All valid tile sets must have at least three tiles
    public static boolean hasRequiredQuantity(TileSet tiles) {
        boolean isRequiredLength = tiles.getTileCount() >= 3;
        return isRequiredLength;
    }
    
    // A group must have same value
    public static boolean hasSameValue(TileSet tiles) {
        List<Value> values = tiles.getValues();
        // get first non-joker tile in the set to compare the rest to
        int i = tiles.getNonJokerIndex();
        Value refTileValue = tiles.getTile(i).getValue();
        // compare all other tile values to make sure they are the same
        for (Value val : values) {
            if (val != refTileValue && val != Value.JOKER) {
                return false;
            }
        }
        return true;
    }

    // A group must have unique colors
    public static boolean hasUniqueColors(TileSet tiles) {
        // Only four colors exists (a joker cannot become a new color)
        if (tiles.getTileCount() > Color.values().length) {
            return false;
        }
        List<Color> colors = tiles.getColors();
        // Check tile set for any repeating colors
        for (int i = 0; i < colors.size() - 1; i++) {
            Color currentColor = colors.get(i);
            // remaining list to loop over, excluding current index
            List<Color> remainingList = colors.subList(i+1, colors.size());
            // Check if remainder of arraylist contains current color (there can be more than one joker)
            if (remainingList.contains(currentColor) && currentColor != Color.JOKER) {
                return false;
            }
        }
        return true;
    }

    // A group cannot be greater than the number of unique colors (4)
    public static boolean lessThanFour(TileSet tiles) {
        int colorCount = Color.getColorCount();
        return tiles.getTileCount() <= colorCount;
    }
}