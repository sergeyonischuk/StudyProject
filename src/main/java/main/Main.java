package main;

import java.util.ArrayList;

import notebook.Contact;
import notebook.ContactCreator;
import notebook.NoteBook;

public class Main {

	public static void main(String[] args) {
		NoteBook noteBook = new NoteBook(new ArrayList<Contact>());
		ContactCreator contactCreator = new ContactCreator();
		
		contactCreator.addNewContactInNoteBook(noteBook);
		contactCreator.addNewContactInNoteBook(noteBook);
		System.out.println(noteBook.getContacts().get(0).toString());
	}
}