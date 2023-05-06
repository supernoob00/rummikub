import java.util.List;
import java.util.ArrayList; 
import java.util.Collections;

public class TileSet {
    private List<Tile> tiles;

    public TileSet() {
        this.tiles = new ArrayList<Tile>();
    }

    public TileSet(List<Tile> tiles) {
        this.tiles = new ArrayList<Tile>(tiles);
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }

    public Tile getTile(int i) {
        Tile tile = getTiles().get(i);
        return tile;
    }

    public int getIndexOfTile(Tile tile) {
        int index = getTiles().indexOf(tile);
        return index;
    }

    // Returns index of first number (non-joker) tile. If all tiles are joker returns joker.
    public int getNonJokerIndex() {
        int i = 0;
        while (getTile(i) == Tile.JOKER && i < getQuantity()) {
            i++;
        }
        return i;
    }

    public TileSet getSubTileSet(int startIndex, int endIndex) {
        TileSet tileArray = new TileSet();
        for (int i = startIndex; i < endIndex; i++) {
            Tile tile = getTile(i);
            tileArray.addTile(tile);
        }
        return tileArray;
    }

    public void addTile(Tile tile) {
        this.tiles.add(tile);
    }

    public void addTiles(TileSet tiles) {
        for (Tile tile : tiles.getTiles()) {
            addTile(tile);
        }
    }

    public void insertTile(Tile tile, int i) {
        this.tiles.add(i, tile);
    }

    public void insertTiles(TileSet tiles, int index) {
        for (int i = 0; i < tiles.getQuantity(); i++) {
            insertTile(tiles.getTile(i), index + i);
        }
    }

    public Tile removeTile(int i) {
        Tile removedTile = this.tiles.remove(i);
        return removedTile;
    }
    
    public TileSet removeTiles(int startIndex, int endIndex) {
        TileSet removedTiles = new TileSet();
        for (int i = startIndex; i < endIndex; i++) {
            Tile removedTile = removeTile(i);
            removedTiles.addTile(removedTile);
        }
        return removedTiles;
    }

    public TileSet removeTiles(int startIndex) {
        TileSet removedTiles = removeTiles(startIndex, getQuantity());
        return removedTiles;
    }

    public TileSet removeNumOfTiles(int count) {
        TileSet removedTiles = removeTiles(getQuantity() - count);
        return removedTiles;
    }

    public boolean hasTile(Tile tile) {
        boolean hasTile = this.tiles.contains(tile);
        return hasTile;
    }

    public void shuffle() {
        Collections.shuffle(tiles);
    }

    public int getQuantity() {
        return this.tiles.size();
    }

    public boolean isEmpty() {
        return this.tiles.size() == 0;
    }

    public List<Color> getColors() {
        List<Color> colors = new ArrayList<Color>();
        for (Tile tile : this.tiles) {
            Color tileColor = tile.getColor();
            colors.add(tileColor);
        }
        return colors;
    }

    public List<Value> getValues() {
        List<Value> values = new ArrayList<Value>();
        for (Tile tile : this.tiles) {
            Value tileValue = tile.getValue();
            values.add(tileValue);
        }
        return values;
    }

    public String toString() {
        String tileSetString = "";
        for (Tile tile : getTiles()) {
            tileSetString = tileSetString + " " + tile.toString();
        }
        return tileSetString;
    }

    public boolean equals(TileSet anotherTileSet) {
        for (int i = 0; i < getQuantity(); i++) {
            if (getTile(i) != anotherTileSet.getTile(i)) {
                return false;
            }
        }
        return true;
    }
}