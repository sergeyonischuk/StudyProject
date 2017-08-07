package notebook;

import java.util.ArrayList;

public class NoteBook {
	
	private ArrayList<Contact> contactBase = new ArrayList<Contact>();
		
	public NoteBook(ArrayList<Contact> arrayList) {this.contactBase = arrayList;}

	public ArrayList<Contact> getContacts() {return contactBase;}
	public void setContacts(ArrayList<Contact> contacts) {this.contactBase = contacts;}
}
