package gameController;

import java.util.Scanner;

import gameModel.ValuesStorage;
import gameView.GameView;

public class GameService {
	private GameView view = new GameView();
    private ValuesStorage valuesStorage = new ValuesStorage();
    private Scanner scanner = new Scanner(System.in);

    public void startGame () {
    	int rand = valuesStorage.getRandomValue(valuesStorage.getMinRangeValue(), valuesStorage.getMaxRangeValue());
    	view.numberCall();
        
        while (rand != valuesStorage.getCurrentValue()) {
        	isInputScannerDataNotString(scanner);
            valuesStorage.setCurrentValue(scanner.nextInt());
            isInRange(valuesStorage.getCurrentValue());
            valuesStorage.addPreviousAttemptToStorage(valuesStorage.getAttemptsArchive(), valuesStorage.getCurrentValue());
            view.playerChoise(valuesStorage.getCurrentValue());
            isWin(rand);
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
    
    public boolean isInRange(int value) {        
        if (value >= valuesStorage.getMaxRangeValue()) {
        	view.printOutOfRangeGreater(valuesStorage.getMaxRangeValue());
        	return false;
        }
        else if (value <= valuesStorage.getMinRangeValue()) {
        	view.printOutOfRangeLess(valuesStorage.getMinRangeValue());
        	return false;
        }
    	return true;
    }
    
    public boolean isWin(int winValue) {
        if (valuesStorage.getCurrentValue() < winValue && valuesStorage.getCurrentValue() > valuesStorage.getMinRangeValue()) {
            valuesStorage.setMinRangeValue(valuesStorage.getCurrentValue());
            view.moveUp(valuesStorage.getMinRangeValue());
            return false;
        } else if (valuesStorage.getCurrentValue() > winValue && valuesStorage.getCurrentValue() < valuesStorage.getMaxRangeValue()) {
            valuesStorage.setMaxRangeValue(valuesStorage.getCurrentValue());
            view.moveDown(valuesStorage.getMaxRangeValue());
            return false;
        }
        view.printWinStatistic();
        return true;
    }
}