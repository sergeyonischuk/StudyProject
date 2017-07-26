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
	Scanner scannerString = new Scanner("ahahah");
	Scanner scannerValue = new Scanner("12");
	
	@Test
	public void testIsInRange() {
		Assert.assertNotSame(gService.isInRange(25) | gService.isInRange(77), gService.isInRange(26));
	}
	
	
	@Test
	public void TestIsInputScannerDataNotString() {
		Assert.assertNotSame(gService.isInputScannerDataNotString(scannerString), gService.isInputScannerDataNotString(scannerValue));
	}
	
	@Test
	public void testIsWin() {
		int winValue = 29;
		Assert.assertNotSame(gService.isWin(winValue), gService.isWin(34));
	}
}