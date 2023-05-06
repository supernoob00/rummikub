// utility class for tile sets

public final class TileSets {
    private TileSets() {}

    // move tile from specified index at source to end of dest
    public static void moveTile(TileSet source, TileSet dest, int sourceIndex) {
        Tile tileToMove = source.removeTile(sourceIndex);
        dest.addTile(tileToMove);
    }

    // move tile from specified index at source to end of dest at specfied index
    public static void moveTile(
        TileSet source, 
        TileSet dest, 
        int sourceIndex, 
        int destIndex) 
    {
        Tile tileToMove = source.removeTile(sourceIndex);
        dest.insertTile(tileToMove, destIndex);
    }

    // move multiple tiles from specified index at source to end of dest
    public static void moveTiles(
        TileSet sourceTileArray, 
        TileSet destTileArray, 
        int sourceStartIndex,
        int sourceEndIndex) 
    {
        TileSet tilesToMove = sourceTileArray.removeTiles(sourceStartIndex, sourceEndIndex);
        destTileArray.addTiles(tilesToMove);
    }

    // move multiple tiles from specified index at source to end of dest at specfied index
    public static void moveTiles(
        TileSet sourceTileArray, 
        TileSet destTileArray, 
        int sourceStartIndex,
        int sourceEndIndex,
        int destIndex) 
    {
        TileSet tilesToMove = sourceTileArray.removeTiles(sourceStartIndex, sourceEndIndex);
        destTileArray.insertTiles(tilesToMove, destIndex);
    }

    /* 
    A valid tile set is either:
    Group: Same value with unique colors. Has a max size of four, which is the number of colors.
    Run: Same color with sequential values which increment by one. Any joker used within must represent a valid value 1-13.
    */

    public static boolean isValid(TileSet tiles) {
        boolean isValid = Group.isGroup(tiles) || Run.isRun(tiles);
        return isValid;
    }
}