package guessGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller class.
 * @author Sergey Onischuk
 *
 */
public class Engine {
	
	private View view = new View();
    private ValuesStorage valuesStorage = new ValuesStorage();
    
    /**
     * Constructor
     * @param dataBox - model object.
     */
    public Engine (ValuesStorage dataBox) {
    	this.valuesStorage = dataBox;
    }

    /**
     * Engine method. Describes actions for a particular step.
     */
    public void startGame () {
    	view.numberCall();
    	
    	int rand = valuesStorage.getRandomValue(valuesStorage.getMinRangeValue(), valuesStorage.getMaxRangeValue());
        
        while (rand != valuesStorage.getCurrentValue()) {
            Scanner scanner = new Scanner(System.in);
            dataValidator(scanner);
            view.playerChoise(valuesStorage.getCurrentValue());
            nextStep(rand);
            view.printPreviousResluts(valuesStorage.getAttemptsArchive());
        }
    }
    
    /**
     * This method created for validating scanner input data.
     * @param scanner - user-entered value.
     * @return
     */
    public boolean dataValidator(Scanner scanner) {
        if (!scanner.hasNextInt()) {
        	view.printDataTypeError();
        	return true;
        }

        valuesStorage.setCurrentValue(scanner.nextInt());
        if (valuesStorage.getCurrentValue() >= valuesStorage.getMaxRangeValue()) {
        	view.printOutOfRangeBigger(valuesStorage.getMaxRangeValue());
        	return true;
        }
        else if (valuesStorage.getCurrentValue() <= valuesStorage.getMinRangeValue()) {
        	view.printOutOfRangeLess(valuesStorage.getMinRangeValue());
        	return true;
        }
        addPreviousResults(valuesStorage.getAttemptsArchive(), valuesStorage.getCurrentValue());
    	return false;
    }
    
    /**
     * Method, that analyzing current situation in the game.
     * @param winValue - current value.
     */
    public void nextStep(int winValue) {
        if (valuesStorage.getCurrentValue() == winValue) {
            view.printWinStatistic();
        } else if (valuesStorage.getCurrentValue() < winValue && valuesStorage.getCurrentValue() > valuesStorage.getMinRangeValue()) {
            valuesStorage.setMinRangeValue(valuesStorage.getCurrentValue());
            view.moveUp(valuesStorage.getMinRangeValue());
        } else if (valuesStorage.getCurrentValue() > winValue && valuesStorage.getCurrentValue() < valuesStorage.getMaxRangeValue()) {
            valuesStorage.setMaxRangeValue(valuesStorage.getCurrentValue());
            view.moveDown(valuesStorage.getMaxRangeValue());
        }
    }
    
    /**
     * 
     * @param arr - arrayList of user attempts.
     * @param currentValue - iterator.
     * @return arrayList with new element.
     */
    private ArrayList<Integer> addPreviousResults(ArrayList<Integer> arr, int currentValue) {
        arr.add(currentValue);
        return arr;
    }
}