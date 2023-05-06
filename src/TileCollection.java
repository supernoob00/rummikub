import java.util.ArrayList;
import java.util.List;

public class TileCollection {
    private List<TileSet> tileArrays = new ArrayList<TileSet>();

    public TileCollection() {

    }

    public TileSet getTileArray(int i) {
        return tileArrays.get(i);
    }

    public void addTileArray(TileSet tiles) {
        tileArrays.add(tiles);
    }

    public void splitTileArray(int tileArrayIndex, int splitIndex) {
        
    }
}