package helloWorldTask;

import java.util.Scanner;

public class Controller {
    public void getResult() {
        Scanner scanner = new Scanner(System.in);
        InputData inputData = new InputData(scanner.nextLine(), scanner.nextLine());
        
    	while (!scanner.nextLine().equals(View.FIRST_WORD_CANONICAL)) {
    		System.out.println("wtf");
    	}
    	
        if (inputData.getFirstWord().equals(View.FIRST_WORD_CANONICAL) && inputData.getSecondWord().equals(View.SECOND_WORD_CANONICAL)) {
           System.out.println(inputData.getFirstWord() + " " + inputData.getSecondWord());
        }   else {
            System.out.println(View.ERROR_MESSAGE);
        }
    }
}