import java.util.List;

public class App {
    public static void main(String[] args) {
        /* 
         * Game myGame = new Game();
        myGame.run();
        */
        TileSet t1 = new TileSet(List.of(Tile.RED_ONE));
        TileSet t2 = new TileSet(List.of(Tile.RED_ONE));
        boolean equals = t1.equals(t2);
        boolean equals2 = t1.equals(t2);
        System.out.println(equals2);
    }
}
