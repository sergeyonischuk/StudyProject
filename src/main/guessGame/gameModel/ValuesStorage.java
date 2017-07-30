package gameModel;

import java.util.ArrayList;
import java.util.Random;

public class ValuesStorage {

    private int minRangeValue;
    private int maxRangeValue;
    private int currentValue;
    private ArrayList<Integer> attemptsArchive;
    
    public ValuesStorage(int minRangeValue, int maxRangeValue, ArrayList<Integer> attemptsArchive) {
        this.minRangeValue = minRangeValue;
        this.maxRangeValue = maxRangeValue;
        this.currentValue = 0;
        this.attemptsArchive = attemptsArchive;
    }
    
    public ValuesStorage() {
    	
    }
    
    public int getRandomValue(int min, int max) {
        max -= min;
        Random rand = new Random();
        return rand.nextInt(max - 1) + (min + 1);
    }
    
    public ArrayList<Integer> addPreviousAttemptToStorage(ArrayList<Integer> prevAttempts, int currentValue) {
    	if(currentValue < maxRangeValue && currentValue > minRangeValue) {
        	prevAttempts.add(currentValue);
    	}
    	return prevAttempts;
    }
    
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