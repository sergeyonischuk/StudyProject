import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import guessGame.GameService;
import guessGame.ValuesStorage;
import guessGame.View;
import junit.framework.Assert;

public class GameSerciveTest {
	
	ValuesStorage vStorage = new ValuesStorage(25, 71, new ArrayList<Integer>());
	GameService gService = new GameService(vStorage);
	View view = new View();
	Scanner scanner = new Scanner(System.in);
	
	@Test
	public void testIsInputScannerDataNotString() {
		Assert.assertTrue(gService.isInputScannerDataNotString(scanner));
	}
	
	@Test
	public void testIsInRange() {
		Assert.assertFalse(gService.isInRange());
		vStorage.setCurrentValue(27);
		Assert.assertTrue(gService.isInRange());
		vStorage.setCurrentValue(999);
		Assert.assertFalse(gService.isInRange());
	}
}
