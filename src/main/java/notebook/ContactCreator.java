package notebook;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactCreator extends ContactBuilder {
	
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * Based on the information entered, creating new Contact in notebook. 
	 */
	public void addNewContactInNoteBook(NoteBook noteBook) {
		Objects.requireNonNull(noteBook);
		Contact contact = createContact();
		noteBook.getContacts().add(contact);
		try {
			checkUniqueNickname(contact.getNickName(), noteBook.getContacts());
		} catch (Exception e) {
				RegexView.printMessage(RegexView.NOT_UNIQUE_NICKNAME);
				RegexView.printMessage(RegexView.REQUEST_NICKNAME);
				contact.setNickName(validateUserInput(NoteBookRegex.NICKNAME_PATTERN, RegexView.REQUEST_NICKNAME));
		}	


		
		RegexView.printMessage(RegexView.SUCCESS_NEW_CONTACT);
	}
	
	public Contact createContact() {
		Contact contact = new ContactBuilder()
			.buildName(validateUserInput(NoteBookRegex.NAME_PATTERN, RegexView.REQUEST_NAME))
			.buildSecondName(validateUserInput(NoteBookRegex.NAME_PATTERN, RegexView.REQUEST_SECOND_NAME))
			.buildPatronymic(validateUserInput(NoteBookRegex.NAME_PATTERN, RegexView.REQUEST_PATRONYMIC))
			.buildNickName(validateUserInput(NoteBookRegex.NICKNAME_PATTERN, RegexView.REQUEST_NICKNAME))
			.buildComment(validateUserInput(NoteBookRegex.COMMENT_PATTERN, RegexView.REQUEST_COMMENT))
			.buildContactGroup(addContactGroup())
			.buildMobileNumber(validateUserInput(NoteBookRegex.PHONE_PATTERN, RegexView.REQUEST_MOBILE_NUMBER))
			.buildAdditionalMobileNumber(validateUserInput(NoteBookRegex.ADDITIONAL_PHONE_PATTERN, RegexView.REQUEST_MOBILE_NUMBER2))
			.buildEmail(validateUserInput(NoteBookRegex.MAIL_PATTERN, RegexView.REQUEST_EMAIL))
			.buildSkype(validateUserInput(NoteBookRegex.NICKNAME_PATTERN, RegexView.REQUEST_SKYPE))
			.buildIndex(validateUserInput(NoteBookRegex.INDEX_PATTERN, RegexView.REQUEST_INDEX))
			.buildCity(validateUserInput(NoteBookRegex.CITY__PATTERN, RegexView.REQUEST_CITY))
			.buildStreet(validateUserInput(NoteBookRegex.STREET_PATTERN, RegexView.REQUEST_STREET))
			.buildHouseNumber(validateUserInput(NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN, RegexView.REQUEST_HOUSE_NUMBER))
			.buildApartmentsNumber(validateUserInput(NoteBookRegex.HOUSE_AND_APPARTMENT_PATTERN, RegexView.REQUEST_APPARTMENTS_NUMBER))
			.build();
		return contact;
	}

	/**
	 * If nickname, that was inputed by user, is not unique - throw UniqueNickNameExceptoion.
	 * @param nickname - current nickname
	 * @param arr - notebook list
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
	 * Scan user's input number and find the contact group (in enum class), that corresponding to this value.
	 */

	private ContactGroup addContactGroup() {
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
		return cg[temp - 1];

}
	/**
	 * Validating user's input data.
	 * @param pattern - regex pattern to validate data.
	 * @param message - request message from Regex.
	 * @return validated data.
	 */
	public String validateUserInput(Pattern pattern, String message) {
		RegexView.printMessage(message);
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Objects.requireNonNull(input);
		Objects.requireNonNull(pattern);

		Matcher matcher = pattern.matcher(input);

			while(!matcher.find()) {
				try {
					RegexView.printHelpMessage(pattern);
					scanner = new Scanner(System.in);
					input = scanner.nextLine();
					matcher = pattern.matcher(input);
				} catch (IllegalArgumentException e) {
					scanner.close();
				}
			}
			return input;
	}
}
