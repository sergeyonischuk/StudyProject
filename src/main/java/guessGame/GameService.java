package guessGame;

import java.util.Scanner;

public class GameService {
	private View view = new View();
    private ValuesStorage valuesStorage = new ValuesStorage();
    private Scanner scanner = new Scanner(System.in);
    
    public GameService (ValuesStorage valuesStorage) {
    	this.valuesStorage = valuesStorage;
    }

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
            view.printPreviousAttempts(valuesStorage.getAttemptsArchive());
        }
    }

    public boolean isInputScannerDataNotString(Scanner scanner) {
        if (!scanner.hasNextInt()) {
        	view.printDataTypeError();
        	return false;
        }
        return true;
    }
    
    public boolean isInRange() {        
        if (valuesStorage.getCurrentValue() >= valuesStorage.getMaxRangeValue()) {
        	view.printOutOfRangeGreater(valuesStorage.getMaxRangeValue());
        	return false;
        }
        else if (valuesStorage.getCurrentValue() <= valuesStorage.getMinRangeValue()) {
        	view.printOutOfRangeLess(valuesStorage.getMinRangeValue());
        	return false;
        }
    	return true;
    }
    
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