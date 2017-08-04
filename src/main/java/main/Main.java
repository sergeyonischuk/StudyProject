package main;

import java.util.ArrayList;
import java.util.Objects;

import controller.Contact;
import controller.ContactCreator;
import enums.ContactGroup;
import model.NoteBook;
import model.UniqueNickNameException;
import view.RegexView;

public class Main {

	public static void main(String[] args) {
		NoteBook noteBook = new NoteBook(new ArrayList<Contact>());
		ContactCreator contactCreator = new ContactCreator();
		
		contactCreator.addNewContactInNoteBook(noteBook);
		System.out.println(noteBook.getContacts().get(0).toString());
	}
}