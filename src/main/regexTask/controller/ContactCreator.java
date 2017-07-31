package controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enums.ContactGroup;
import model.Contact;
import model.NoteBook;
import model.UniqueNickNameException;
import view.RegexView;

public class ContactCreator {
	
	private Contact newContact = new Contact();
	private Scanner scanner;
	
	/**
	 * Creating and returning new contact. 
	 * @return
	 */
	public Contact createNewContact() {
		addContactGroup(newContact);
		addNameInfo(newContact);
		addContactsInfo(newContact);
		addAdressInfo(newContact);
		RegexView.printMessage(RegexView.SUCCESS_NEW_CONTACT);
		
		return newContact;
	}
	
	/**
	 * Scan user's input and record it in appropriate variable.
	 */
	public Contact addNameInfo(Contact contact) {
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
	
	public Contact addContactsInfo(Contact contact) {
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
	
	public Contact addAdressInfo(Contact contact) {
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
	public Contact addContactGroup(Contact contact) {
		Scanner scanner = new Scanner(System.in);
		RegexView.printMessage(RegexView.REQUEST_CONTACT_GROUP);
		
		int temp = scanner.nextInt();
		
		while(temp <= 0 || temp > ContactGroup.values().length) {
			try {
				RegexView.printMessage(RegexView.WRONG_INPUT);
				RegexView.printMessage(RegexView.REQUEST_CONTACT_GROUP);
				scanner = new Scanner(System.in);
				temp = scanner.nextInt();

			} catch (IllegalArgumentException e) {
				scanner.close();
			}
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
