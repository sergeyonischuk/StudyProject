package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.ContactGroup;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ContactGroup getContactGroup() {
		return contactGroup;
	}

	public void setContactGroup(ContactGroup contactGroup) {
		this.contactGroup = contactGroup;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAdditionalMobileNumber() {
		return additionalMobileNumber;
	}

	public void setAdditionalMobileNumber(String additionalMobileNumber) {
		this.additionalMobileNumber = additionalMobileNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	
	public SimpleDateFormat getFormat() {
		return dateFormat;
	}

	public void setFormat(SimpleDateFormat format) {
		this.dateFormat = format;
	}

	public String getDateOfLastChange() {
		return dateOfLastChange;
	}

	public void setDateOfLastChange(String dateOfLastChange) {
		this.dateOfLastChange = dateOfLastChange;
	}

	public String getDateOfCreate() {
		return dateOfCreate;
	}
	
	

}
