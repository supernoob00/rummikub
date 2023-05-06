import java.util.ArrayList;
import java.util.List;

public class TileCollection {
    private List<TileSet> tileArrays = new ArrayList<TileSet>();

    public TileCollection() {

    }

    public List<TileSet> getTileSets() {
        return this.tileArrays;
    }

    public TileSet getTileSet(int i) {
        return tileArrays.get(i);
    }

    public void addTileSet(TileSet tiles) {
        tileArrays.add(tiles);
    }

    public void splitTileArray(int tileArrayIndex, int splitIndex) {
        
    }
}