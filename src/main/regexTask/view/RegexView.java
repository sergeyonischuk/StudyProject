package view;

import java.util.regex.Pattern;

import controller.NoteBookRegex;
import enums.ContactGroup;

public class RegexView {
	
	public static final String REQUEST_NAME = "Enter the name";
	public static final String REQUEST_SECOND_NAME = "Enter the second name";
	public static final String REQUEST_PATRONYMIC = "Enter the patronymic";
	public static final String REQUEST_NICKNAME = "Enter the nickname";
	public static final String REQUEST_COMMENT = "Enter the comment";
	public static final String REQUEST_CONTACT_GROUP = "Enter number of group: " + ContactGroup.FAMILY + "(1), " + ContactGroup.FRIENDS + "(2), " + ContactGroup.WORK + "(3), " + ContactGroup.OTHER + "(4)";
	public static final String REQUEST_MOBILE_NUMBER = "Enter the mobile number in format +380";
	public static final String REQUEST_MOBILE_NUMBER2 = "Enter the additional mobile number (or leave this field empty)";
	public static final String REQUEST_EMAIL = "Enter the email";
	public static final String REQUEST_SKYPE = "Enter the skype";
	public static final String REQUEST_INDEX = "Enter the index";
	public static final String REQUEST_CITY = "Enter the city";
	public static final String REQUEST_STREET = "Enter the street";
	public static final String REQUEST_HOUSE_NUMBER = "Enter the house number";
	public static final String REQUEST_APPARTMENTS_NUMBER = "Enter the appartments number";
	
	public static final String SUCCESS_NEW_CONTACT = "***New contact was created***";
	public static final String WRONG_INPUT = "Wrong input";
	
	
	
	public static void printMessage(String text) {
		System.out.println(text);
	}
	
	/**
	 * Based on the input pattern, this method printing in a console help message.
	 * @param pattern - Non-transmitted pattern name.
	 */
	public static void printHelpMessage(Pattern pattern) {
		if(pattern.equals(NoteBookRegex.NAME_PATTERN)) {
			printMessage("Try again. The first letter should be capitalized, the rest - lowercase. Max symbols - 25");
		} else if(pattern.equals(NoteBookRegex.NICKNAME_PATTERN)) {
			printMessage("Try again. You can use capital and lowercase letters, numbers, symbols \"_\" \"-\" and \".\". Max symbols - 25");
		} else if(pattern.equals(NoteBookRegex.COMMENT_PATTERN)) {
			printMessage("Try again. You can use any symbols, but not more than 50");
		} else if(pattern.equals(NoteBookRegex.PHONE_PATTERN)) {
			printMessage("Try again. Number must start with +380 and 10 numbers");
		} else if(pattern.equals(NoteBookRegex.ADDITIONAL_PHONE_PATTERN)) {
			printMessage("Try again. Number must start with +380 and 10 numbers, or leave this field empty");
		} else if(pattern.equals(NoteBookRegex.MAIL_PATTERN)) {
			printMessage("Try again. Mail adress must have left side (max 255 symbols) + symbol @, domain server's name (for example - gmail.com)");
		} else if(pattern.equals(NoteBookRegex.INDEX_PATTERN)) {
			printMessage("Try again. It must be 5 numbers");
		} else if(pattern.equals(NoteBookRegex.CITY__PATTERN)) {
			printMessage("Try again. The first letter should be capitalized. Also you can use \"-\" symbol ");
		} else if(pattern.equals(NoteBookRegex.STREET_PATTERN)) {
			printMessage("Try again. The first letter should be capitalized. Also you can use \"-\" symbol ");
		} else if(pattern.equals(NoteBookRegex.STREET_PATTERN)) {
			printMessage("Try again. You can use numbers (max symbols - 3). Also you can use \"-\", and any english letter");
		} else {
			printMessage("Hm.. You entered something wrong, but I do not know what :( Try to decide it on your own, okay?");
		}
	}

}
