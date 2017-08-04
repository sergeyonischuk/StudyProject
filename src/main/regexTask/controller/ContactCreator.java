package controller;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enums.ContactGroup;
import model.NoteBook;
import model.UniqueNickNameException;
import view.RegexView;

public class ContactCreator {
	
	private Scanner scanner;
	
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
	
	/**
	 * Based on the information entered, creating new Contact in notebook. 
	 */
	public void addNewContactInNoteBook(NoteBook noteBook) {
		Objects.requireNonNull(noteBook);
		addContactGroup();
		addNameInfo();
		try {

			checkUniqueNickname(nickName, noteBook.getContacts());
		} catch (Exception e) {
				RegexView.printMessage(RegexView.NOT_UNIQUE_NICKNAME);
				RegexView.printMessage(RegexView.REQUEST_NICKNAME);
				nickName = validateUserInput(scanner.nextLine(), NoteBookRegex.NICKNAME_PATTERN);
		}
		addContactsInfo();
		addAdressInfo();

		noteBook.getContacts().add(createContact());
		
		RegexView.printMessage(RegexView.SUCCESS_NEW_CONTACT);
	}
	
	public Contact createContact() {
		
		Contact contact = new ContactBuilder().buildName(name).buildSecondName(secondName).buildPatronymic(patronymic)
				.buildNickName(nickName).buildComment(comment).buildContactGroup(contactGroup)
				.buildMobileNumber(mobileNumber).buildAdditionalMobileNumber(additionalMobileNumber)
				.buildEmail(eMail).buildSkype(skype).buildIndex(index).buildCity(city).buildStreet(street)
				.buildHouseNumber(houseNumber).buildApartmentsNumber(apartmentNumber).build();
		return contact;
	}

	/**
	 * If nickname, that was inputed by user, is not unique - throw UniqueNickNameExceptoion.
	 * @param nickname
	 * @param arr
	 * @throws UniqueNickNameException
	 */
	public boolean checkUniqueNickname(String nickname, ArrayList<Contact> arr) throws UniqueNickNameException {
		Objects.requireNonNull(nickname);
		Objects.requireNonNull(arr);
		
		for (int i = 0; i < arr.size(); i++) {
			if(nickname.equals(arr.get(i).getNickName())) {
				throw new UniqueNickNameException("this nickname is not unique");
			}
		}
		return true;
	}
	
	/**
	 * Scan user's input and record it in a Contact.
	 */
	private void addNameInfo() {
		scanner = new Scanner(System.in);

			RegexView.printMessage(RegexView.REQUEST_NAME);
			name = validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_SECOND_NAME);
			secondName = validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_PATRONYMIC);
			patronymic = validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_NICKNAME);
			nickName = validateUserInput(scanner.nextLine(), NoteBookRegex.NICKNAME_PATTERN);
	}
	
	private void addContactsInfo() {
		scanner = new Scanner(System.in);

			RegexView.printMessage(RegexView.REQUEST_COMMENT);
			comment = validateUserInput(scanner.nextLine(), NoteBookRegex.COMMENT_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_MOBILE_NUMBER);
			mobileNumber = validateUserInput(scanner.nextLine(), NoteBookRegex.PHONE_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_MOBILE_NUMBER2);
			additionalMobileNumber = validateUserInput(scanner.nextLine(), NoteBookRegex.ADDITIONAL_PHONE_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_EMAIL);
			eMail = validateUserInput(scanner.nextLine(), NoteBookRegex.MAIL_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_SKYPE);
			skype = validateUserInput(scanner.nextLine(), NoteBookRegex.NICKNAME_PATTERN);
	}
	
	private void addAdressInfo() {
		scanner = new Scanner(System.in);

			RegexView.printMessage(RegexView.REQUEST_INDEX);
			index = validateUserInput(scanner.nextLine(), NoteBookRegex.INDEX_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_CITY);
			city = validateUserInput(scanner.nextLine(), NoteBookRegex.CITY__PATTERN);
			RegexView.printMessage(RegexView.REQUEST_STREET);
			street = validateUserInput(scanner.nextLine(), NoteBookRegex.STREET_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_HOUSE_NUMBER);
			houseNumber  = validateUserInput(scanner.nextLine(), NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN);
			RegexView.printMessage(RegexView.REQUEST_APPARTMENTS_NUMBER);
			apartmentNumber = validateUserInput(scanner.nextLine(), NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN);
	}
	
	/**
	 * Scan user's input number and find the contact group (in enum class), that corresponding to this value.
	 */

	private void addContactGroup() {
		scanner = new Scanner(System.in);
		RegexView.printMessage(RegexView.REQUEST_CONTACT_GROUP);
		RegexView.printGroupsList();
		
		int temp = 0;

		try {
			temp = scanner.nextInt();	
		} catch (InputMismatchException e) {
				RegexView.printMessage(RegexView.WRONG_INPUT);
				RegexView.printMessage(RegexView.REQUEST_CONTACT_GROUP);
				RegexView.printGroupsList();
				scanner = new Scanner(System.in);
				temp = scanner.nextInt();
		}

		ContactGroup[] cg = ContactGroup.values();
		contactGroup = cg[temp - 1];

}
	/**
	 * Validating user's input data.
	 * @param input - user's input
	 * @param pattern - regex pattern to validate data.
	 * @return validated data.
	 */
	public String validateUserInput(String input, Pattern pattern) {
		Objects.requireNonNull(input);
		Objects.requireNonNull(pattern);
		
		Scanner s = new Scanner(System.in);
		Matcher matcher = pattern.matcher(input);
			while(!matcher.find()) {
				try {
					RegexView.printHelpMessage(pattern);
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
