package moreOrLess;

import java.util.ArrayList;

public class GameView {
	private final static String NUMBER_CALL = "Please, call a number";
	private final static String OUT_OF_RANGE_LESS = "Your value less than min number. Please, input number, that bigger than ";
	private final static String OUT_OF_RANGE_GREATER = "Your value greater than max number. Please, input number, that less than ";
	private final static String DATA_TYPE_ERROR = "Please, enter a number, not string";
	private final static String PLAYER_CHOISE = "Your number is ";
	private final static String MOVE_UP = "Move up. New min range number is ";
	private final static String MOVE_DOWN = "Move down. New max range number is ";
	
	
	public void printMessage(String text) {
		System.out.println(text);
	}
	
	public void numberCall() {
		printMessage(NUMBER_CALL);
	}

	public void printErrorValue(int min, int max) {
		printMessage("You need to call number from " + min + " to " + max);
	}

	public void printOutOfRangeLess(int value) {
		printMessage(OUT_OF_RANGE_LESS + value);
	}

	public void printOutOfRangeGreater(int value) {
		printMessage(OUT_OF_RANGE_GREATER + value);
	}

	public void printDataTypeError() {
		printMessage(DATA_TYPE_ERROR);
	}
	
	public void playerChoise(int value) {
		printMessage(PLAYER_CHOISE + value);
	}

	public void moveUp(int value) {
		printMessage(MOVE_UP + value);
	}

	public void moveDown(int value) {
		printMessage(MOVE_DOWN + value);
	}

    public void printWinStatistic() {
    	printMessage("***************");
    	printMessage("Gracias! You win!");
    	printMessage("Your prize - Omar Hayam's poem:");
    	printMessage("***************");
    	printMessage("Khayyam, who stitched the tents of science,");
    	printMessage("Has fallen in grief's furnace and been suddenly burned");
    	printMessage("The shears of Fate have cut the tent ropes of his life");
    	printMessage("And the broker of Hope has sold him for nothing!");
    	printMessage("***************");
    }
    
    public void printPreviousAttempts(ArrayList<Integer> arr) {
        System.out.print("Entered values: ");
        for (Object anArr : arr) {
            System.out.print(anArr + " ");
        }
        printMessage("");
    }
}
