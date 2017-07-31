package model;

import enums.ContactGroup;

public class Contact {
	

	private String dateOfCreate, dateOfLastChange;

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

	public Contact() {

	}
	
	//Concatenation methods.
	
	public String getSecondNameAndNameFirstLetter() {
		return secondName + " " + name.charAt(0) + ".";
	}
	
	public String getAdress() {
		return index + ", " + city + ", " + street + ", " + houseNumber + ", " + apartmentNumber;
	}
	
	// getters

	public String getName() {
		return name;
	}

	public String getSecondName() {
		return secondName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public String getNickName() {
		return nickName;
	}

	public String getComment() {
		return comment;
	}

	public ContactGroup getContactGroup() {
		return contactGroup;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getMobileNumber2() {
		return additionalMobileNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public String getSkype() {
		return skype;
	}

	public String getIndex() {
		return index;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public String getCreateDate() {
		return dateOfCreate;
	}
	
	public String getDateOfLastChange() {
		return dateOfLastChange;
	}
	
	public String getAdditionalMobileNumber() {
		return additionalMobileNumber;
	}
	
	// Setters

	public void setDateOfLastChange(String dateOfLastChange) {
		this.dateOfLastChange = dateOfLastChange;
	}

	public void setAdditionalMobileNumber(String additionalMobileNumber) {
		this.additionalMobileNumber = additionalMobileNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setContactGroup(ContactGroup contactGroup) {
		this.contactGroup = contactGroup;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	

	public void setDateOfCreate(String dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}

}
