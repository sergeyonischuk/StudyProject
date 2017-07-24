package testGuessGame;

import java.util.ArrayList;

import org.junit.Test;

import guessGame.ValuesStorage;
import junit.framework.Assert;

public class TestValuesStorage {
	
    ValuesStorage valuesStorage = new ValuesStorage(0, 100, new ArrayList<Integer>());
	
	@Test
	public void testGetRandomValue() {
		int min = 5;
		int max = 7;
		Assert.assertTrue(valuesStorage.getRandomValue(min, max) == 6);
	}

}
