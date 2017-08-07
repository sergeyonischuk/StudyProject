package notebook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
	
	private String name;
	private String secondName;
	private String patronymic;
	private String nickName;

	private String comment;
	private ContactGroup contactGroup;
	private String mobileNumber;
	private String additionalMobileNumber;
	private String eMail;
	private String skype;

	private String index;
	private String city;
	private String street;
	private String houseNumber;
	private String apartmentNumber;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
	private String dateOfCreate = dateFormat.format(new Date());
	private String dateOfLastChange = dateFormat.format(new Date());

	public Contact() {

	}
	
	//Concatenation methods.
	
	public String getSecondNameAndNameFirstLetter() {
		return secondName + " " + name.charAt(0) + ".";
	}
	
	public String getAdress() {
		return index + ", " + city + ", " + street + ", " + houseNumber + ", " + apartmentNumber;
	}

	// getters and setters

	public String getName() {return name;}
	public String getSecondName() {return secondName;}
	public String getPatronymic() {return patronymic;}
	public String getNickName() {return nickName;}
	public String getComment() {return comment;}
	public ContactGroup getContactGroup() {return contactGroup;}
	public String getMobileNumber() {return mobileNumber;}
	public String getAdditionalMobileNumber() {return additionalMobileNumber;}
	public String geteMail() {return eMail;}
	public String getSkype() {return skype;}
	public String getIndex() {return index;}
	public String getCity() {return city;}
	public String getStreet() {return street;}
	public String getHouseNumber() {return houseNumber;}
	public String getApartmentNumber() {return apartmentNumber;}
	public SimpleDateFormat getFormat() {return dateFormat;}
	public String getDateOfLastChange() {return dateOfLastChange;}
	public String getDateOfCreate() {return dateOfCreate;}
	
	public void setName(String name) {this.name = name;}
	public void setSecondName(String secondName) {this.secondName = secondName;}
	public void setPatronymic(String patronymic) {this.patronymic = patronymic;}
	public void setNickName(String nickName) {this.nickName = nickName;}
	public void setComment(String comment) {this.comment = comment;}
	public void setContactGroup(ContactGroup contactGroup) {this.contactGroup = contactGroup;}
	public void setMobileNumber(String mobileNumber) {this.mobileNumber = mobileNumber;}
	public void setAdditionalMobileNumber(String additionalMobileNumber) {this.additionalMobileNumber = additionalMobileNumber;}
	public void seteMail(String eMail) {this.eMail = eMail;}
	public void setSkype(String skype) {this.skype = skype;}
	public void setIndex(String index) {this.index = index;}
	public void setCity(String city) {this.city = city;}
	public void setStreet(String street) {this.street = street;}
	public void setHouseNumber(String houseNumber) {this.houseNumber = houseNumber;}
	public void setApartmentNumber(String apartmentNumber) {this.apartmentNumber = apartmentNumber;}
	public void setFormat(SimpleDateFormat format) {this.dateFormat = format;}
	public void setDateOfLastChange(String dateOfLastChange) {this.dateOfLastChange = dateOfLastChange;}
	
	@Override
	public String toString() {
		return "SecondName: " + secondName + "\n"
				+ "Name: " + name + "\n" 
				+ "Second name: " + secondName + "\n"
				+ "Patronymic: " + patronymic + "\n"
				+ "Nickname: " + nickName + "\n"
				+ "Comment: " + comment + "\n"
				+ "Contact Group: " + contactGroup + "\n"
				+ "Mobile number: " + mobileNumber + "\n"
				+ "Additional mobile number: " + additionalMobileNumber + "\n"
				+ "email: " + eMail + "\n"
				+ "Skype: " + skype + "\n"
				+ "Index: " + index + "\n"
				+ "City: " + city + "\n"
				+ "Street: " + street + "\n"
				+ "House number: " + houseNumber + "\n"
				+ "Apartments number: " + apartmentNumber + "\n"
				+ "Date of create: " + dateOfCreate + "\n"
				+ "Date of last change: " + dateOfLastChange + "\n";
	}
}

//Builder class
class ContactBuilder{
	private String name;
	private String secondName;
	private String patronymic;
	private String nickName;

	private String comment;
	private ContactGroup contactGroup;
	private String mobileNumber;
	private String additionalMobileNumber;
	private String eMail;
	private String skype;

	private String index;
	private String city;
	private String street;
	private String houseNumber;
	private String apartmentNumber;


	public ContactBuilder buildName(String name) {
		this.name = name;
		return this;
	}
	public ContactBuilder buildSecondName(String secondName) {
		this.secondName = secondName;
		return this;
	}
	public ContactBuilder buildPatronymic(String patronymic) {
		this.patronymic = patronymic;
		return this;
	}
	public ContactBuilder buildNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}
	
	public ContactBuilder buildComment(String comment) {
		this.comment = comment;
		return this;
	}
	public ContactBuilder buildContactGroup(ContactGroup contactGroup) {
		this.contactGroup = contactGroup;
		return this;
	}
	public ContactBuilder buildMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}
	public ContactBuilder buildAdditionalMobileNumber(String additionalMobileNumber) {
		this.additionalMobileNumber = additionalMobileNumber;
		return this;
	}
	public ContactBuilder buildEmail(String eMail) {
		this.eMail = eMail;
		return this;
	}
	public ContactBuilder buildSkype(String skype) {
		this.skype = skype;
		return this;
	}
	
	public ContactBuilder buildIndex(String index) {
		this.index = index;
		return this;
	}
	public ContactBuilder buildCity(String city) {
		this.city = city;
		return this;
	}
	public ContactBuilder buildStreet(String street) {
		this.street = street;
		return this;
	}
	public ContactBuilder buildHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}
	public ContactBuilder buildApartmentsNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
		return this;
	}
	
	public Contact build() {
		Contact contact = new Contact();
		
		contact.setName(name);
		contact.setSecondName(secondName);
		contact.setPatronymic(patronymic);
		contact.setNickName(nickName);
		
		contact.setComment(comment);
		contact.setContactGroup(contactGroup);
		contact.setMobileNumber(mobileNumber);
		contact.setAdditionalMobileNumber(additionalMobileNumber);
		contact.seteMail(eMail);
		contact.setSkype(skype);
		
		contact.setIndex(index);
		contact.setCity(city);
		contact.setStreet(street);
		contact.setHouseNumber(houseNumber);
		contact.setApartmentNumber(apartmentNumber);
		
		return contact;
	}
}