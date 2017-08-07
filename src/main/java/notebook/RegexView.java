package notebook;

import java.util.regex.Pattern;
import java.util.Locale;
import java.util.ResourceBundle;

public class RegexView {
	
	private static Locale locale_ru = new Locale("ru_RU");
	private static Locale locale_en = new Locale("en_US");
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("texts", locale_en);
	
	
	public static final String REQUEST_NAME = bundle.getString("name");
	public static final String REQUEST_SECOND_NAME = bundle.getString("secondName");
	public static final String REQUEST_PATRONYMIC = bundle.getString("patronymic");
	public static final String REQUEST_NICKNAME = bundle.getString("nickname");
	public static final String REQUEST_COMMENT = bundle.getString("comment");
	public static final String REQUEST_CONTACT_GROUP = bundle.getString("contactGroup");
	public static final String REQUEST_MOBILE_NUMBER = bundle.getString("mobileNumber");
	public static final String REQUEST_MOBILE_NUMBER2 = bundle.getString("additionalMobileNumber");
	public static final String REQUEST_EMAIL = bundle.getString("eMail");
	public static final String REQUEST_SKYPE = bundle.getString("skype");
	public static final String REQUEST_INDEX = bundle.getString("index");
	public static final String REQUEST_CITY = bundle.getString("city");
	public static final String REQUEST_STREET = bundle.getString("street");
	public static final String REQUEST_HOUSE_NUMBER = bundle.getString("houseNumber");
	public static final String REQUEST_APPARTMENTS_NUMBER = bundle.getString("apartmentsNumber");
	
	public static final String SUCCESS_NEW_CONTACT = bundle.getString("successNewContact");
	public static final String WRONG_INPUT = bundle.getString("wrongInput");
	public static final String NOT_UNIQUE_NICKNAME = bundle.getString("notUniqueNickname");
	
	public static void printGroupsList() {
		ContactGroup[] newList = ContactGroup.values();
		
		for (int i = 0; i < newList.length; i++) {
			System.out.print(newList[i].toString() + "(" + (i + 1) + ") ");
		}
		printMessage("");
	}
	
	public static void printMessage(String text) {
		System.out.println(text);
	}
	
	/**
	 * Based on the input pattern, this method printing in a console help message.
	 * @param pattern - Non-transmitted pattern name.
	 */
	public static void printHelpMessage(Pattern pattern) {
		if(pattern.equals(NoteBookRegex.NAME_PATTERN)) {
			printMessage(bundle.getString("nameErr"));
		} else if(pattern.equals(NoteBookRegex.NICKNAME_PATTERN)) {
			printMessage(bundle.getString("nicknameErr"));
		} else if(pattern.equals(NoteBookRegex.COMMENT_PATTERN)) {
			printMessage(bundle.getString("commentErr"));
		} else if(pattern.equals(NoteBookRegex.PHONE_PATTERN)) {
			printMessage(bundle.getString("mobileNumberErr"));
		} else if(pattern.equals(NoteBookRegex.ADDITIONAL_PHONE_PATTERN)) {
			printMessage(bundle.getString("additionalMobileNumberErr"));
		} else if(pattern.equals(NoteBookRegex.MAIL_PATTERN)) {
			printMessage(bundle.getString("eMailErr"));
		} else if(pattern.equals(NoteBookRegex.INDEX_PATTERN)) {
			printMessage(bundle.getString("indexErr"));
		} else if(pattern.equals(NoteBookRegex.CITY__PATTERN)) {
			printMessage(bundle.getString("cityErr"));
		} else if(pattern.equals(NoteBookRegex.STREET_PATTERN)) {
			printMessage(bundle.getString("streetErr"));
		} else if(pattern.equals(NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN)) {
			printMessage(bundle.getString("houseAndApartmentNumberErr"));
		} else {
			printMessage(bundle.getString("elseErr"));
		}
	}
}