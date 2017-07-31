package model;

import java.util.ArrayList;

public class NoteBook {
	
	private ArrayList<Contact> contactBase = new ArrayList<Contact>();
		
	public NoteBook(ArrayList<Contact> arrayList) {
		this.contactBase = arrayList;
	}
	
//	public boolean checkUniqueNickName(String nickName) throws UniqueNickNameException {
//		for(int i = 0; i < this.contactBase.size(); i++) {
//			if(this.contactBase.get(i).getNickName().equals(nickName)) {
//				throw new UniqueNickNameException("nickname must be unique. This nickName is already taken");
//			}
//		}
//		
//		return true;
//		
//	}
	
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
