import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class GroupTest {
    @RunWith(Parameterized.class)
    public static class ValidGroupTest {
        @Parameters
        public static List<TileSet> testTileSets() {
            return List.of(
                new TileSet(List.of(Tile.JOKER, Tile.JOKER, Tile.BLUE_ONE)),
                new TileSet(List.of(Tile.YELLOW_TWO, Tile.JOKER, Tile.JOKER)),
                new TileSet(List.of(Tile.BLACK_ONE, Tile.RED_ONE, Tile.BLUE_ONE)),
                new TileSet(List.of(Tile.BLACK_ONE, Tile.RED_ONE, Tile.JOKER)),
                new TileSet(List.of(Tile.BLACK_ONE, Tile.RED_ONE, Tile.BLUE_ONE, Tile.YELLOW_ONE)),
                new TileSet(List.of(Tile.JOKER, Tile.JOKER, Tile.BLUE_ONE, Tile.YELLOW_ONE))
            );
        }

        @Parameter
        public TileSet testTileSet;

        @Test 
        public void passesRequiredQuantity() {
            boolean hasRequiredQuantity = Group.hasRequiredQuantity(testTileSet);
            assertTrue(hasRequiredQuantity);
        }

        @Test 
        public void passesUniqueColors() {
            boolean hasUniqueColors = Group.hasUniqueColors(testTileSet);
            assertTrue(hasUniqueColors);
        }

        @Test
        public void passesSameValue() {
            boolean hasSameValue = Group.hasSameValue(testTileSet);
            assertTrue(hasSameValue);
        }

        @Test 
        public void passesGroup() {
            boolean isGroup = Group.isGroup(testTileSet);
            assertTrue(isGroup);
        }
    }

        @RunWith(Parameterized.class)
        public static class InvalidGroupTest {
            @Parameters
            public static List<TileSet> testTileSets2() {
                return List.of(
                    new TileSet(List.of(Tile.BLACK_ONE, Tile.BLACK_ONE)),
                    new TileSet(List.of(Tile.BLACK_ONE, Tile.BLACK_ONE, Tile.BLUE_ONE)),
                    new TileSet(List.of(Tile.BLACK_ONE, Tile.BLUE_TWO, Tile.JOKER)),
                    new TileSet(List.of(Tile.JOKER, Tile.BLUE_TWO, Tile.JOKER, Tile.BLUE_TWO)),
                    new TileSet(List.of(Tile.BLACK_ONE, Tile.BLACK_ONE, Tile.BLUE_ONE, Tile.YELLOW_ONE)),
                    new TileSet(List.of(Tile.JOKER, Tile.JOKER, Tile.BLUE_ONE, Tile.YELLOW_ONE, Tile.BLACK_ONE))
                );
            }

            @Parameter
            public TileSet testTileSet2;

            @Test 
            public void failsGroup() {
                boolean isGroup = Group.isGroup(testTileSet2);
                assertFalse(isGroup);
            }
        }
    }
