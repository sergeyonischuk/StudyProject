package guessGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Model class with data.
 * @author Sergey Onischuk
 *
 */
public class ValuesStorage {
	/**
	 * The minimum allowed value, considering previous attempts
	 */
    private int minRangeValue;
	/**
	 * The maximum allowed value, considering previous attempts
	 */
    private int maxRangeValue;
    /**
     * Current value, that selected by user.
     */
    private int currentValue;
    /**
     * ArrayList with previous attempts.
     */
    private ArrayList<Integer> attemptsArchive;
    
/**
 * Constructor class
 */
    public ValuesStorage(int minRangeValue, int maxRangeValue, ArrayList<Integer> attemptsArchive) {
        this.minRangeValue = minRangeValue;
        this.maxRangeValue = maxRangeValue;
        this.currentValue = 0;
        this.attemptsArchive = attemptsArchive;
    }
    
    public ValuesStorage() {
    	
    }
    
    /**
     * Random generator. Random value always will be less by 1 than minRangeValue, and bigger by 1 than maxRangeValue (value should not include borders).
     * @param min - minimal range value.
     * @param max - maximal range value.
     * @return random value.
     */
    public int getRandomValue(int min, int max) {
        max -= min;
        Random rand = new Random();
        return rand.nextInt(max - 1) + (min + 1);
    }
    
    /**
     * 
     * @param arr - arrayList of user attempts.
     * @param currentValue - iterator.
     */
    public ArrayList<Integer> addPreviousAttemptToStorage(ArrayList<Integer> prevAttempts, int currentValue) {
    	if(currentValue < maxRangeValue && currentValue > minRangeValue) {
        	prevAttempts.add(currentValue);
    	}
    	return prevAttempts;
    }

    // Getters and setters.
    
    public int getMinRangeValue() {
        return minRangeValue;
    }

    public void setMinRangeValue(int minRangeValue) {
        this.minRangeValue = minRangeValue;
    }

    public int getMaxRangeValue() {
        return maxRangeValue;
    }

    public void setMaxRangeValue(int maxRangeValue) {
        this.maxRangeValue = maxRangeValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public ArrayList<Integer> getAttemptsArchive() {
        return attemptsArchive;
    }

    public void setAttemptsArchive(ArrayList<Integer> attemptsArchive) {
        this.attemptsArchive = attemptsArchive;
    }
}