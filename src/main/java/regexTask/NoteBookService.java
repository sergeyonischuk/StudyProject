package regexTask;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteBookService {
	
	private Scanner scanner = new Scanner(System.in);
	
	private String name;
	private String secondName;
	private String patronymic;
	private String nickName;
	
	private String comment;
	private ContactGroup contactGroup;
	private String mobileNumber;
	private String mobileNumber2;
	private String eMail;
	private String skype;
	
	private int index;
	private String city;
	private String street;
	private String houseNumber;
	private int apartmentNumber;
	
	private String dateOfCreate;
	private String dateOfLastChange;
	
	/**
	 * Name, SecondName, Patronymic
	 */
	public static final Pattern NAME_PATTERN = Pattern.compile("[A-Z][a-z]{1,25}");
	public static final Pattern COMMENT_PATTERN = Pattern.compile(".{1,50}");
	/**
	 * phone number in format +38000-000-00-00
	 */
	public static final Pattern PHONE_PATTERN = Pattern.compile("\\+380[0-9]{9}");
	public static final Pattern MAIL_PATTERN = Pattern.compile("[A-Za-z0-9_]{2,255}@[a-z]{1,15}\\.[a-z]{1,5}");
	public static final Pattern INDEX_PATTERN = Pattern.compile("[0-9]{1,10}");
	public static final Pattern CITY__PATTERN = Pattern.compile("[A-Za-z]{1,15}[-A-Z]*{1,15}[a-z]*{1,15}[-A-Z]*{1,15}[a-z]*{1,15}");
	/**
	 * for streets (include numerals and space).
	 */
	public static final Pattern STREET_PATTERN = Pattern.compile("[A-Za-z0-9]{1,15}[\\s-A-Z]*{1,15}[\\sa-z]*{1,15}[\\s-A-Z]*{1,15}[\\sa-z]*{1,15}");
	public static final Pattern HOUSE_AND_APPARTMENT_PATTERN = Pattern.compile("[0-9]{1,3}-*[a-z]*{1}");
	/**
	 * dd-mm-yyyy format
	 */
	public static final Pattern DATE_PATTERN = Pattern.compile("[0-3][0-9]-[0-1][0-9]-20[0-9]{2}");
	
	
	
	public boolean validateUserInput(String input, Pattern pattern) {
		Matcher matcher = pattern.matcher(input);
		if(matcher.matches() == true) {
			name = input;
//			System.out.println("success");
			return true;
		} else {
//			System.out.println("Please, enter correct data (First letter must be capital, length must not exceed 25 characters");
			return false;
		}
		
	}
	
	
	

}
