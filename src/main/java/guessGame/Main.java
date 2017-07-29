package guessGame;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	    ValuesStorage valueStorage = new ValuesStorage(0, 100, new ArrayList<Integer>());
        GameService engine = new GameService();
        engine.startGame();

    }
}