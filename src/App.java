public class App {
    public static void main(String[] args) {
        Game myGame = new Game(2);
        GameInterface myInterface = new GameInterface();
        GameController myController = new GameController(myGame, myInterface);
        myController.startGame();
    }
}
