import java.util.ArrayList;
import java.util.List;

public class TileCollection {
    private List<TileSet> tileSets;

    public TileCollection() {
        tileSets = new ArrayList<TileSet>();
    }

    public List<TileSet> getTileSets() {
        return this.tileSets;
    }

    public TileSet getTileSet(int i) {
        return tileSets.get(i);
    }

    public int getTileSetCount() {
        return getTileSets().size();
    }

    public void addTileSet(TileSet tiles) {
        tileSets.add(tiles);
    }

    public TileSet removeTileSet(int i) {
        TileSet removedSet = getTileSets().remove(i);
        return removedSet;
    }

    public void addTile(Tile tile) {
        TileSet ts = new TileSet();
        ts.addTile(tile);
        addTileSet(ts);
    }

    public void splitTileArray(int tileArrayIndex, int splitIndex) {
        
    }

    public boolean isValid() {
        for (TileSet ts : getTileSets()) {
            if (!TileSetRules.isValid(ts)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return getTileSets().size() == 0;
    }

    public String toString() {
        String tcString = "";
        for (TileSet ts : getTileSets()) {
            tcString = tcString + ts.toString() + "\n";
        }
        return tcString;
    }
}