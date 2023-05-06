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
        TileSet source, 
        TileSet dest, 
        int sourceStartIndex,
        int sourceEndIndex) 
    {
        TileSet tilesToMove = source.removeTiles(sourceStartIndex, sourceEndIndex);
        dest.addTiles(tilesToMove);
    }

    // move multiple tiles from specified index at source to end of dest at specfied index
    public static void moveTiles(
        TileSet source, 
        TileSet dest, 
        int sourceStartIndex,
        int sourceEndIndex,
        int destIndex) 
    {
        TileSet tilesToMove = source.removeTiles(sourceStartIndex, sourceEndIndex);
        dest.insertTiles(tilesToMove, destIndex);
    }
}