package helloWorld;

import java.util.Scanner;

public class Controller {
	View view = new View();
	
    public void getResult() {
        Scanner scanner = new Scanner(System.in);
        String firstInputLine = scanner.nextLine();
        String secondInputLine = scanner.nextLine();
        InputData inputData = new InputData(firstInputLine, secondInputLine);
        
    	if (!firstInputLine.equals(View.FIRST_WORD_CANONICAL)) {
    		view.printMessage(view.ERROR_MESSAGE);;
    	}
        if (firstInputLine.equals(View.FIRST_WORD_CANONICAL)) {
            if (secondInputLine.equals(inputData.getFirstWord() + " " + inputData.getSecondWord()))
            	view.printMessage(View.ERROR_MESSAGE);
            	view.printMessage(inputData.getFirstWord() + " " + inputData.getSecondWord());
            	scanner.close();
            }
        }
}