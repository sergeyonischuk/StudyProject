package main;

import java.util.ArrayList;

import controller.ContactCreator;
import enums.ContactGroup;
import model.Contact;
import model.NoteBook;
import model.UniqueNickNameException;
import view.RegexView;

public class Main {
	
	static RegexView regexView = new RegexView();
	static ContactGroup cG;

	public static void main(String[] args) throws UniqueNickNameException {
//        Controller controller = new Controller();
//        controller.getResult();
		
//	    ValuesStorage valueStorage = new ValuesStorage(0, 100, new ArrayList<Integer>());
//        GameService engine = new GameService();
//        engine.startGame();
		
		NoteBook noteBook = new NoteBook(new ArrayList<Contact>());
		ContactCreator contactCreator = new ContactCreator();
		
		contactCreator.addNewContactInNoteBook(noteBook);
		contactCreator.addNewContactInNoteBook(noteBook);
//		System.out.println(noteBook.getContacts().get(0).getNickName());
//		System.out.println(noteBook.getContacts().get(1).getNickName());
		
	}

}
