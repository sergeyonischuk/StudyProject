package guessGame;

import java.util.Scanner;

/**
 * Controller class.
 * @author Sergey Onischuk
 *
 */
public class GameService {
	private View view = new View();
    private ValuesStorage valuesStorage = new ValuesStorage();
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * Constructor
     * @param dataBox - model object.
     */
    public GameService (ValuesStorage valuesStorage) {
    	this.valuesStorage = valuesStorage;
    }

    /**
     * Engine method. Describes actions for a particular step.
     */
    public void startGame () {
    	int rand = valuesStorage.getRandomValue(valuesStorage.getMinRangeValue(), valuesStorage.getMaxRangeValue());
    	view.numberCall();
        
        while (rand != valuesStorage.getCurrentValue()) {
        	isInputScannerDataNotString(scanner);
            valuesStorage.setCurrentValue(scanner.nextInt());
            isInRange();
            valuesStorage.addPreviousAttemptToStorage(valuesStorage.getAttemptsArchive(), valuesStorage.getCurrentValue());
            view.playerChoise(valuesStorage.getCurrentValue());
            takeNextStep(rand);
            view.printPreviousResluts(valuesStorage.getAttemptsArchive());
        }
    }
    /**
     * Checking method
     * @return check result.
     */
    public boolean isInputScannerDataNotString(Scanner scanner) {
        if (!scanner.hasNextInt()) {
        	view.printDataTypeError();
        	return false;
        }
        return true;
    }
    
    /**
     * Checking current value for the ranges.
     * @return check result.
     */
    public boolean isInRange() {        
        if (valuesStorage.getCurrentValue() >= valuesStorage.getMaxRangeValue()) {
        	view.printOutOfRangeBigger(valuesStorage.getMaxRangeValue());
        	return false;
        }
        else if (valuesStorage.getCurrentValue() <= valuesStorage.getMinRangeValue()) {
        	view.printOutOfRangeLess(valuesStorage.getMinRangeValue());
        	return false;
        }
    	return true;
    }
    
    /**
     * Method, that analyzing current situation in the game.
     * @param winValue - current value.
     */
    public void takeNextStep(int winValue) {
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
}