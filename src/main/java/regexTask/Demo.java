package regexTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) {
		NoteBookService noteBookService = new NoteBookService();
		
		System.out.println(noteBookService.validateUserInput("1st avenue", NoteBookService.STREET_PATTERN));
	}

}
