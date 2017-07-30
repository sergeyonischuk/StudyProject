package regexTask;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactCreator {
	
	private String name;
	private String secondName;
	private String patronymic;
	private String nickName;
	
	private String comment;
	private ContactGroup contactGroup;
	private String mobileNumber;
	private String additionalMobileNumber;
	private String eMail;
	private String skype;
	
	private String index;
	private String city;
	private String street;
	private String houseNumber;
	private String apartmentNumber;
	
	private Scanner scanner;
	private Scanner scanner2;
	private Scanner scanner3;
	
	/**
	 * Creating (with builder pattern) and returning new contact. 
	 * @return
	 */
	public Contact createNewContact() {
		Contact newContact;
		addContactGroup();
		addNameInfo();
		addContactsInfo();
		addAdressInfo();
		
		newContact = Contact.newBuilder().setName(name).setSecondName(secondName).setPatronymic(patronymic)
				.setNickName(nickName).setComment(comment).setContactGroup(contactGroup).setMobileNumber(mobileNumber).setMobileNumber2(additionalMobileNumber)
				.setEMail(eMail).setSkype(skype).setIndex(index).setCity(city).setStreet(street)
				.setHouseNumber(houseNumber).setApartmentNumber(apartmentNumber).setHouseNumber(houseNumber).build();
		View.printMessage(View.SUCCESS_NEW_CONTACT);
		return newContact;
	}
	
	/**
	 * Scan user's input and record it in appropriate variable.
	 */
	public void addNameInfo() {
		scanner = new Scanner(System.in);

			View.printMessage(View.REQUEST_NAME);
			name = validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN);
			View.printMessage(View.REQUEST_SECOND_NAME);
			secondName = validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN);
			View.printMessage(View.REQUEST_PATRONYMIC);
			patronymic = validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN);
			View.printMessage(View.REQUEST_NICKNAME);
			nickName = validateUserInput(scanner.nextLine(), NoteBookRegex.NICKNAME_PATTERN);
	}
	
	public void addContactsInfo() {
		scanner2 = new Scanner(System.in);

			View.printMessage(View.REQUEST_COMMENT);
			comment = validateUserInput(scanner2.nextLine(), NoteBookRegex.COMMENT_PATTERN);
			View.printMessage(View.REQUEST_MOBILE_NUMBER);
			mobileNumber = validateUserInput(scanner2.nextLine(), NoteBookRegex.PHONE_PATTERN);
			View.printMessage(View.REQUEST_MOBILE_NUMBER2);
			additionalMobileNumber = validateUserInput(scanner2.nextLine(), NoteBookRegex.ADDITIONAL_PHONE_PATTERN);
			View.printMessage(View.REQUEST_EMAIL);
			eMail = validateUserInput(scanner2.nextLine(), NoteBookRegex.MAIL_PATTERN);
			View.printMessage(View.REQUEST_SKYPE);
			skype = validateUserInput(scanner2.nextLine(), NoteBookRegex.NICKNAME_PATTERN);
	}
	
	public void addAdressInfo() {
		scanner3 = new Scanner(System.in);

		View.printMessage(View.REQUEST_INDEX);
			index = validateUserInput(scanner3.nextLine(), NoteBookRegex.INDEX_PATTERN);
			View.printMessage(View.REQUEST_CITY);
			city = validateUserInput(scanner3.nextLine(), NoteBookRegex.CITY__PATTERN);
			View.printMessage(View.REQUEST_STREET);
			street = validateUserInput(scanner3.nextLine(), NoteBookRegex.STREET_PATTERN);
			View.printMessage(View.REQUEST_HOUSE_NUMBER);
			houseNumber = validateUserInput(scanner3.nextLine(), NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN);
			View.printMessage(View.REQUEST_APPARTMENTS_NUMBER);
			apartmentNumber = validateUserInput(scanner3.nextLine(), NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN);
	}
	
	public void addCreationDay() {
		// must be realized soon...
	}
	
	public void updateDateOfLastChangeInContact() {
		// must be realized soon...
	}
	
	/**
	 * Scan user's input number and find the contact group (in enum class), that corresponding to this value.
	 */
	public void addContactGroup() {
		Scanner scanner = new Scanner(System.in);
		View.printMessage(View.REQUEST_CONTACT_GROUP);
		
		int temp = scanner.nextInt();
		
		while(temp <= 0 || temp > ContactGroup.values().length) {
			try {
				View.printMessage(View.WRONG_INPUT);
				View.printMessage(View.REQUEST_CONTACT_GROUP);
				scanner = new Scanner(System.in);
				temp = scanner.nextInt();

			} catch (IllegalArgumentException e) {
				scanner.close();
			}
		}
		ContactGroup[] cg = ContactGroup.values();
		contactGroup = cg[temp - 1];
	}
	/**
	 * User's input data validator.
	 * @param input - user's input
	 * @param pattern - regex pattern to validate data.
	 * @return validated data.
	 */
	public String validateUserInput(String input, Pattern pattern) {
		Scanner s = new Scanner(System.in);
		Matcher matcher = pattern.matcher(input);
			while(!matcher.find()) {
				try {
					View.printHelpMessage(pattern);
					 s = new Scanner(System.in);
					input = s.nextLine();
					matcher = pattern.matcher(input);
				} catch (IllegalArgumentException e) {
					s.close();
				}
			}
			return input;
	}

}
