package main;


import java.util.ArrayList;
import regexTask.Contact;
import regexTask.ContactCreator;
import regexTask.NoteBook;

public class Main {

	public static void main(String[] args) {
//        Controller controller = new Controller();
//        controller.getResult();
		
//	    ValuesStorage valueStorage = new ValuesStorage(0, 100, new ArrayList<Integer>());
//        GameService engine = new GameService();
//        engine.startGame();
		
		NoteBook noteBook = new NoteBook(new ArrayList<Contact>());
		ContactCreator contactCreator = new ContactCreator();
		noteBook.addContact(contactCreator.createNewContact());
	}

}
