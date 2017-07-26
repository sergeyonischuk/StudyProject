import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import guessGame.ValuesStorage;

public class ValuesStorageTest {
	
	ValuesStorage vs = new ValuesStorage(6, 8, new ArrayList<Integer>());
	
	@Test
	public void testGetRandomValue() {
		Assert.assertTrue(vs.getRandomValue(6, 8) > 6 && vs.getRandomValue(6, 8) < 8);
	}
	
	@Test
	public void testAddPreviousAttemptToStorage() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		ArrayList<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(7);
		
		Assert.assertEquals(vs.addPreviousAttemptToStorage(list, 7), expectedList);
		
	}
}