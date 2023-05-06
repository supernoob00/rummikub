import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class RunTest {
    @RunWith(Parameterized.class) 
    public static class ValidRunTest {
        @Parameters
        public static List<TileSet> testTileSets() {
            return List.of(
                new TileSet(List.of(Tile.BLACK_ONE, Tile.BLACK_TWO, Tile.BLACK_THREE)),
                new TileSet(List.of(Tile.JOKER, Tile.JOKER, Tile.BLACK_THREE)),
                new TileSet(List.of(Tile.JOKER, Tile.JOKER, Tile.BLACK_THIRTEEN)),
                new TileSet(List.of(Tile.BLACK_ONE, Tile.BLACK_TWO, Tile.BLACK_THREE, Tile.JOKER)),
                new TileSet(List.of(Tile.JOKER, Tile.JOKER, Tile.BLACK_THREE, Tile.BLACK_FOUR)),
                new TileSet(List.of(Tile.JOKER, Tile.YELLOW_ELEVEN, Tile.JOKER, Tile.YELLOW_THIRTEEN)),
                new TileSet(List.of(Tile.RED_TWO, Tile.JOKER, Tile.JOKER, Tile.RED_FIVE))
            );
        }

        @Parameter
        public TileSet testTileSet;

        @Test 
        public void passesRequiredQuantity() {
            boolean hasRequiredQuantity = Run.hasRequiredQuantity(testTileSet);
            assertTrue(hasRequiredQuantity);
        }

        @Test 
        public void passesHasSequentialValues() {
            boolean hasSequentialValues = Run.hasSequentialValues(testTileSet);
            assertTrue(hasSequentialValues);
        }

        @Test 
        public void passesHasSameColors() {
            boolean hasSameColors = Run.hasSameColors(testTileSet);
            assertTrue(hasSameColors);
        }

        @Test 
        public void noMisplacedJokersInRun() {
            boolean noMisplacedJokers = Run.noMisplacedJokersInRun(testTileSet);
            assertTrue(noMisplacedJokers);
        }

        @Test
        public void passesRun() {
            boolean isRun = Run.isRun(testTileSet);
            assertTrue(isRun);
        }
    }

    @RunWith(Parameterized.class)
    public static class InvalidRunTest {
        @Parameters
        public static List<TileSet> testTileSets2() {
            return List.of(
                new TileSet(List.of(Tile.BLACK_ONE, Tile.BLACK_TWO)),
                new TileSet(List.of(Tile.BLACK_ONE, Tile.BLACK_ONE, Tile.BLACK_TWO)),
                new TileSet(List.of(Tile.BLACK_ONE, Tile.BLACK_TWO, Tile.BLACK_FOUR)),
                new TileSet(List.of(Tile.RED_ONE, Tile.BLACK_TWO, Tile.BLACK_THREE)),
                new TileSet(List.of(Tile.RED_ONE, Tile.JOKER, Tile.BLACK_THREE)),
                new TileSet(List.of(Tile.JOKER, Tile.BLACK_ONE, Tile.BLACK_THREE)),
                new TileSet(List.of(Tile.JOKER, Tile.JOKER, Tile.BLACK_ONE, Tile.BLACK_THREE)),
                new TileSet(List.of(Tile.BLACK_TWELVE, Tile.BLACK_THIRTEEN, Tile.JOKER)),
                new TileSet(List.of(Tile.BLACK_ONE, Tile.JOKER, Tile.BLACK_FOUR)),
                new TileSet(List.of(Tile.BLACK_THREE, Tile.BLACK_TWO, Tile.BLACK_ONE)),
                new TileSet(List.of(Tile.BLACK_ONE, Tile.JOKER, Tile.JOKER, Tile.BLACK_FIVE)),
                new TileSet(List.of(Tile.JOKER, Tile.BLACK_FIVE, Tile.JOKER, Tile.BLACK_FOUR))
            );
        }

        @Parameter
        public TileSet testTileSet2;

        @Test
        public void failsRun() {
            boolean isRun = Run.isRun(testTileSet2);
            assertFalse(isRun);
        }
    }
}
