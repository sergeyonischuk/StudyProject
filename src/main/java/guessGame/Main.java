package guessGame;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	    ValuesStorage dataBox = new ValuesStorage(0, 100, new ArrayList<Integer>());
        Engine engine = new Engine(dataBox);
        engine.startGame();

    }
}