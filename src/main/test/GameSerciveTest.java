import java.util.ArrayList;

import guessGame.GameService;
import guessGame.ValuesStorage;
import guessGame.View;

public class GameSerciveTest {
	ValuesStorage vStorage = new ValuesStorage(25, 71, new ArrayList<Integer>());
	GameService gService = new GameService(vStorage);
	View view = new View();
	

}
