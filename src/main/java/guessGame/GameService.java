package guessGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller class.
 * @author Sergey Onischuk
 *
 */
public class GameService {
	
	private View view = new View();
    private ValuesStorage valuesStorage = new ValuesStorage();
    
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
    	view.numberCall();
    	
    	int rand = valuesStorage.getRandomValue(valuesStorage.getMinRangeValue(), valuesStorage.getMaxRangeValue());
        
        while (rand != valuesStorage.getCurrentValue()) {
            Scanner scanner = new Scanner(System.in);
            isInputScannerDataCorrect(scanner);
            view.playerChoise(valuesStorage.getCurrentValue());
            takeNextStep(rand);
            view.printPreviousResluts(valuesStorage.getAttemptsArchive());
        }
    }
    
    /**
     * This method created for validating scanner input data.
     * @param scanner - user-entered value.
     * @return
     */
    public boolean isInputScannerDataCorrect(Scanner scanner) {
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
        valuesStorage.addPreviousAttemptToStorage(valuesStorage.getAttemptsArchive(), valuesStorage.getCurrentValue());
    	return false;
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