package regexTask;

import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) {
		NoteBook noteBook = new NoteBook(new ArrayList<Contact>());
		ContactCreator cc = new ContactCreator();
		
//		System.out.println(noteBookService.validateUserInput("1st avenue", NoteBookService.STREET_PATTERN));
		cc.addContact(noteBook.getContacts(), cc.createNewContact());
		System.out.println(noteBook.getContacts().get(0).getAdressGroup());
	}

}
