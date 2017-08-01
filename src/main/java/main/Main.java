package main;

import java.util.ArrayList;

import controller.ContactCreator;
import enums.ContactGroup;
import model.Contact;
import model.NoteBook;
import view.RegexView;

public class Main {
	
	static RegexView regexView = new RegexView();
	static ContactGroup cG;

	public static void main(String[] args) {
//        Controller controller = new Controller();
//        controller.getResult();
		
//	    ValuesStorage valueStorage = new ValuesStorage(0, 100, new ArrayList<Integer>());
//        GameService engine = new GameService();
//        engine.startGame();
		
		NoteBook noteBook = new NoteBook(new ArrayList<Contact>());
		ContactCreator contactCreator = new ContactCreator();
		noteBook.addContact(contactCreator.createNewContact());
		System.out.println("creation day: " + noteBook.getContacts().get(0).getDateOfCreate());
		System.out.println("last changes day: " + noteBook.getContacts().get(0).getDateOfLastChange());
		System.out.println("group: " + noteBook.getContacts().get(0).getContactGroup());
		System.out.println("name: " + noteBook.getContacts().get(0).getSecondNameAndNameFirstLetter());
		

	}

}