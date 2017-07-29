package regexTask;

import java.util.ArrayList;
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
	private String mobileNumber2;
	private String eMail;
	private String skype;
	
	private int index;
	private String city;
	private String street;
	private String houseNumber;
	private String apartmentNumber;
	
	private String dateOfCreate;
	private String dateOfLastChange;
	
	public String validateUserInput(String input, Pattern pattern) {
		Scanner s = new Scanner(System.in);
		Matcher matcher = pattern.matcher(input);
			while(!matcher.find()) {
				try {
					View.printError(pattern);
					 s = new Scanner(System.in);
					input = s.nextLine();
					matcher = pattern.matcher(input);
				} catch (IllegalArgumentException e) {
					s.close();
				}
			}
			return input;
	}
	
	public void createNameInfo() {
		Scanner scanner = new Scanner(System.in);

			View.printMessage(View.REQUEST_NAME);
			name = validateUserInput(scanner.nextLine(), NoteBookService.NAME_PATTERN);
			View.printMessage(View.REQUEST_SECOND_NAME);
			secondName = validateUserInput(scanner.nextLine(), NoteBookService.NAME_PATTERN);
			View.printMessage(View.REQUEST_PATRONYMIC);
			patronymic = validateUserInput(scanner.nextLine(), NoteBookService.NAME_PATTERN);
			View.printMessage(View.REQUEST_NICKNAME);
			nickName = validateUserInput(scanner.nextLine(), NoteBookService.NICKNAME_PATTERN);
	}
	
	public void createContactInfo() {
		Scanner scanner = new Scanner(System.in);

			View.printMessage(View.REQUEST_COMMENT);
			comment = validateUserInput(scanner.nextLine(), NoteBookService.COMMENT_PATTERN);
			View.printMessage(View.REQUEST_MOBILE_NUMBER);
			mobileNumber = validateUserInput(scanner.nextLine(), NoteBookService.PHONE_PATTERN);
			View.printMessage(View.REQUEST_MOBILE_NUMBER2);
			mobileNumber2 = validateUserInput(scanner.nextLine(), NoteBookService.ADDITIONAL_PHONE_PATTERN);
			View.printMessage(View.REQUEST_EMAIL);
			eMail = validateUserInput(scanner.nextLine(), NoteBookService.MAIL_PATTERN);
			View.printMessage(View.REQUEST_SKYPE);
			skype = validateUserInput(scanner.nextLine(), NoteBookService.NICKNAME_PATTERN);
	}
	
	public void createAdressInfo() {
		Scanner scanner = new Scanner(System.in);

		View.printMessage(View.REQUEST_INDEX);
			index = Integer.parseInt(validateUserInput(scanner.nextLine(), NoteBookService.INDEX_PATTERN));
			View.printMessage(View.REQUEST_CITY);
			city = validateUserInput(scanner.nextLine(), NoteBookService.CITY__PATTERN);
			View.printMessage(View.REQUEST_STREET);
			street = validateUserInput(scanner.nextLine(), NoteBookService.STREET_PATTERN);
			View.printMessage(View.REQUEST_HOUSE_NUMBER);
			houseNumber = validateUserInput(scanner.nextLine(), NoteBookService.HOUSE_AND_APPARTMENT_PATTERN);
			View.printMessage(View.REQUEST_APPARTMENTS_NUMBER);
			apartmentNumber = validateUserInput(scanner.nextLine(), NoteBookService.HOUSE_AND_APPARTMENT_PATTERN);
	}
	
	public Contact createNewContact() {
		Contact newContact;
		addContactGroup();
		createNameInfo();
		createContactInfo();
		createAdressInfo();
		
		newContact = Contact.newBuilder().setName(name).setSecondName(secondName).setPatronymic(patronymic)
				.setNickName(nickName).setComment(comment).setAdressGroup(contactGroup).setMobileNumber(mobileNumber).setMobileNumber2(mobileNumber2)
				.setEMail(eMail).setSkype(skype).setIndex(index).setCity(city).setStreet(street)
				.setHouseNumber(houseNumber).setApartmentNumber(apartmentNumber).setHouseNumber(houseNumber).build();
		System.out.println("***new contact created***");
		return newContact;
	}
	
	public void addContactGroup() {
		Scanner scanner = new Scanner(System.in);
		View.printMessage(View.REQUEST_CONTACT_GROUP);
		int temp = scanner.nextInt();
		if(temp > 0 && temp <= ContactGroup.values().length) {
			ContactGroup[] cg = ContactGroup.values();

			contactGroup = cg[temp - 1];
		}
		else {
			 throw new IllegalArgumentException ("Please, enter correct number");
		}
	}
	
	public ArrayList<Contact> addContact(ArrayList<Contact> arr, Contact contact) {
		arr.add(contact);
		return arr;
	}

}
