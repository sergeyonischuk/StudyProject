package regexTask;

import java.util.ArrayList;

public class NoteBook {
	
	private ArrayList<Contact> contactList = new ArrayList<Contact>();
		
	public NoteBook(ArrayList<Contact> arrayList) {
		this.contactList = arrayList;
	}

	public ArrayList<Contact> getContacts() {
		return contactList;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contactList = contacts;
	}
}
