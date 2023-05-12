public final class TileSetRules {
    private TileSetRules() {}
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