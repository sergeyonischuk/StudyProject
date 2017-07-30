package regexTask;

import java.util.ArrayList;

public class NoteBook {
	
	private ArrayList<Contact> contactBase = new ArrayList<Contact>();
		
	public NoteBook(ArrayList<Contact> arrayList) {
		this.contactBase = arrayList;
	}
	
	public void addContact(Contact contact) {
		contactBase.add(contact);
	}

	public ArrayList<Contact> getContacts() {
		return contactBase;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contactBase = contacts;
	}
}
