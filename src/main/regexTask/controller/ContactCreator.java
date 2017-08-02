package controller;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enums.ContactGroup;
import model.Contact;
import model.NoteBook;
import model.UniqueNickNameException;
import view.RegexView;

public class ContactCreator {
	
	private Scanner scanner;
	
	
	/**
	 * Based on the information entered, creating new Contact in notebook. 
	 */
	public void addNewContactInNoteBook(NoteBook noteBook) throws UniqueNickNameException {
		Objects.requireNonNull(noteBook);
		Contact newContact = new Contact();
		
		addContactGroup(newContact);
		addNameInfo(newContact);
		
		try {

			checkUniqueNickname(newContact.getNickName(), noteBook.getContacts());
		} catch (Exception e) {
				RegexView.printMessage(RegexView.NOT_UNIQUE_NICKNAME);
				RegexView.printMessage(RegexView.REQUEST_NICKNAME);
				newContact.setNickName(validateUserInput(scanner.nextLine(), NoteBookRegex.NICKNAME_PATTERN));
		}
		
		addContactsInfo(newContact);
		addAdressInfo(newContact);

		noteBook.getContacts().add(newContact);
		
		RegexView.printMessage(RegexView.SUCCESS_NEW_CONTACT);
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
	private Contact addNameInfo(Contact contact) {
		scanner = new Scanner(System.in);

			RegexView.printMessage(RegexView.REQUEST_NAME);
			contact.setName(validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_SECOND_NAME);
			contact.setSecondName(validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_PATRONYMIC);
			contact.setPatronymic(validateUserInput(scanner.nextLine(), NoteBookRegex.NAME_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_NICKNAME);
			contact.setNickName(validateUserInput(scanner.nextLine(), NoteBookRegex.NICKNAME_PATTERN));
			
			return contact;
	}
	
	private Contact addContactsInfo(Contact contact) {
		scanner = new Scanner(System.in);

			RegexView.printMessage(RegexView.REQUEST_COMMENT);
			contact.setComment(validateUserInput(scanner.nextLine(), NoteBookRegex.COMMENT_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_MOBILE_NUMBER);
			contact.setMobileNumber(validateUserInput(scanner.nextLine(), NoteBookRegex.PHONE_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_MOBILE_NUMBER2);
			contact.setAdditionalMobileNumber(validateUserInput(scanner.nextLine(), NoteBookRegex.ADDITIONAL_PHONE_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_EMAIL);
			contact.seteMail(validateUserInput(scanner.nextLine(), NoteBookRegex.MAIL_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_SKYPE);
			contact.setSkype(validateUserInput(scanner.nextLine(), NoteBookRegex.NICKNAME_PATTERN));
			
			return contact;
	}
	
	private Contact addAdressInfo(Contact contact) {
		scanner = new Scanner(System.in);

			RegexView.printMessage(RegexView.REQUEST_INDEX);
			contact.setIndex(validateUserInput(scanner.nextLine(), NoteBookRegex.INDEX_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_CITY);
			contact.setCity(validateUserInput(scanner.nextLine(), NoteBookRegex.CITY__PATTERN));
			RegexView.printMessage(RegexView.REQUEST_STREET);
			contact.setStreet(validateUserInput(scanner.nextLine(), NoteBookRegex.STREET_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_HOUSE_NUMBER);
			contact.setHouseNumber(validateUserInput(scanner.nextLine(), NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN));
			RegexView.printMessage(RegexView.REQUEST_APPARTMENTS_NUMBER);
			contact.setApartmentNumber(validateUserInput(scanner.nextLine(), NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN));
			
			return contact;
	}
	
	/**
	 * Scan user's input number and find the contact group (in enum class), that corresponding to this value.
	 */

	private Contact addContactGroup(Contact contact) {
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
		contact.setContactGroup(cg[temp - 1]);
		return contact;
}
	/**
	 * User's input data validator.
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
