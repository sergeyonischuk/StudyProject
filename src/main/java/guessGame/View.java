package guessGame;

import java.util.ArrayList;

/**
 * View class with Strings.
 * @author Sergey Onischuk
 *
 */
public class View {
	private final String NUMBER_CALL = "Please, call a number";
	private final String OUT_OF_RANGE_LESS = "Your value less than min number. Please, input number, that bigger than ";
	private final String OUT_OF_RANGE_BIGGER = "Your value bigger than max number. Please, input number, that less than ";
	private final String DATA_TYPE_ERROR = "Please, enter a number, not string";
	private final String PLAYER_CHOISE = "Your number is ";
	private final String MOVE_UP = "Move up. New min range number is ";
	private final String MOVE_DOWN = "Move down. New max range number is ";
	
	
	public void printMessage(String text) {
		System.out.println(text);
	}
	/**
	 * just greeting.
	 */
	
	public void numberCall() {
		printMessage(NUMBER_CALL);
	}
	/**
	 * Error text, which is displayed when user tries to enter a string or OutOfRange value.
	 * @param min - current minimal value.
	 * @param max - current maximal value.
	 */
	public void printErrorValue(int min, int max) {
		printMessage("You need to call number from " + min + " to " + max);
	}
	/**
	 * text, which is displayed when user tries to enter a value, that less than current minimal value.
	 * @param value - current value.
	 */
	public void printOutOfRangeLess(int value) {
		printMessage(OUT_OF_RANGE_LESS + value);
	}
	/**
	 * text, which is displayed when user tries to enter a value, that bigger than current maximal value.
	 * @param value - current value.
	 */
	public void printOutOfRangeBigger(int value) {
		printMessage(OUT_OF_RANGE_BIGGER + value);
	}
	/**
	 * Wrong input data type.
	 */
	public void printDataTypeError() {
		printMessage(DATA_TYPE_ERROR);
	}
	
	/**
	 * print current player's value.
	 * @param value - current value.
	 */
	public void playerChoise(int value) {
		printMessage(PLAYER_CHOISE + value);
	}
	/**
	 * text, which is displayed when user did not guess the number, that is bigger than current.
	 * @param value - current value
	 */
	public void moveUp(int value) {
		printMessage(MOVE_UP + value);
	}
	/**
	 * text, which is displayed when user did not guess the number, that is less than current.
	 * @param value - current value
	 */
	public void moveDown(int value) {
		printMessage(MOVE_DOWN + value);
	}
	/**
	 * Print win-message with statistic and stupid prize.
	 */
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
    
    /**
     * print method.
     * @param arr - ArrayList with previous attempts to print.
     */
    public void printPreviousResluts(ArrayList<Integer> arr) {
        System.out.print("Entered values: ");
        for (Object anArr : arr) {
            System.out.print(anArr + " ");
        }
        printMessage("");
    }
}
