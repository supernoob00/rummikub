import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TileSetsTest {
    @Test 
    public void moveTileTest() {
        TileSet firstTileSet = new TileSet(List.of(Tile.BLUE_ONE, Tile.BLUE_TWO, Tile.BLUE_THREE));
        TileSet secondTileSet = new TileSet(List.of(Tile.RED_ONE, Tile.RED_TWO, Tile.RED_THREE));
        TileSets.moveTile(firstTileSet, secondTileSet, 0, 1);
        TileSet expectedFirst = new TileSet(List.of(Tile.BLUE_TWO, Tile.BLUE_THREE));
        TileSet expectedSecond = new TileSet(List.of(Tile.RED_ONE, Tile.BLUE_ONE, Tile.RED_TWO, Tile.RED_THREE));
        assertTrue(expectedFirst.equals(firstTileSet));
        assertTrue(expectedSecond.equals(secondTileSet));
    }
}
