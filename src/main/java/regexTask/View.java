package regexTask;

import java.util.regex.Pattern;

public class View {
	
	public static final String REQUEST_NAME = "Enter the name";
	public static final String REQUEST_SECOND_NAME = "Enter the second name";
	public static final String REQUEST_PATRONYMIC = "Enter the patronymic";
	public static final String REQUEST_NICKNAME = "Enter the nickname";
	public static final String REQUEST_COMMENT = "Enter the comment";
	public static final String REQUEST_CONTACT_GROUP = "Enter number of group: " + ContactGroup.FAMILY + ", " + ContactGroup.FRIENDS + ", " + ContactGroup.WORK + ", " + ContactGroup.OTHER;
	public static final String REQUEST_MOBILE_NUMBER = "Enter the mobile number";
	public static final String REQUEST_MOBILE_NUMBER2 = "Enter the additional mobile number (or leave this field empty)";
	public static final String REQUEST_EMAIL = "Enter the email";
	public static final String REQUEST_SKYPE = "Enter the skype";
	public static final String REQUEST_INDEX = "Enter the index";
	public static final String REQUEST_CITY = "Enter the city";
	public static final String REQUEST_STREET = "Enter the street";
	public static final String REQUEST_HOUSE_NUMBER = "Enter the house number";
	public static final String REQUEST_APPARTMENTS_NUMBER = "Enter the appartments number";
	
	
	
	public static void printMessage(String text) {
		System.out.println(text);
	}
	
	public static void printError(Pattern pattern) {
		if(pattern.equals(NoteBookService.NAME_PATTERN)) {
			System.out.println("Try again. The first letter should be capitalized, the rest - lowercase. Max symbols - 25");
		} else if(pattern.equals(NoteBookService.NICKNAME_PATTERN)) {
			System.out.println("Try again. You can use capital and lowercase letters, numbers, symbols _ and -. Max symbols - 25");
		} else if(pattern.equals(NoteBookService.COMMENT_PATTERN)) {
			System.out.println("Try again. You can use any symbols, but not more than 50");
		} else if(pattern.equals(NoteBookService.PHONE_PATTERN)) {
			System.out.println("Try again. Number must start with +380 and 10 numbers");
		} else if(pattern.equals(NoteBookService.ADDITIONAL_PHONE_PATTERN)) {
			System.out.println("Try again. Number must start with +380 and 10 numbers, or leave this field empty");
		} else if(pattern.equals(NoteBookService.MAIL_PATTERN)) {
			System.out.println("Try again. Mail adress must have left side (max 255 symbols) + symbol @, domain server's name (for example - gmail.com)");
		} else if(pattern.equals(NoteBookService.INDEX_PATTERN)) {
			System.out.println("Try again. It must be 5 numbers");
		} else if(pattern.equals(NoteBookService.CITY__PATTERN)) {
			System.out.println("Try again. The first letter should be capitalized. Also you can use \"-\" symbol ");
		} else if(pattern.equals(NoteBookService.STREET_PATTERN)) {
			System.out.println("Try again. The first letter should be capitalized. Also you can use \"-\" symbol ");
		} else if(pattern.equals(NoteBookService.STREET_PATTERN)) {
			System.out.println("Try again. You can use numbers (max symbols - 3). Also you can use \"-\", and any english letter");
		} else if(pattern.equals(NoteBookService.DATE_PATTERN)) {
			System.out.println("Try again. It must be dd-mm-yyyy format (Considering \"-\" symbol");
		}
	}

}
