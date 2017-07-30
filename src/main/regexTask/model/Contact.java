package model;

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

	private String dateOfCreate;
	private String dateOfLastChange;

	private Contact() {

	}

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

	public String getLastChangeDate() {
		return dateOfLastChange;
	}

	//Concatenation methods.
	
	public String getSecondNameAndNameFirstLetter() {
		return secondName + " " + name.charAt(0) + ".";
	}

	public String getAdress() {
		return index + ", " + city + ", " + street + ", " + houseNumber + ", " + apartmentNumber;
	}

	public static Builder newBuilder() {
		return new Contact().new Builder();
	}

	/**
	 * Nested class Builder, according to the Builder pattern.
	 * 
	 * @author Sergey Onischuk
	 *
	 */

	public class Builder {

		private Builder() {

		}

		public Builder setName(String name) {
			Contact.this.name = name;
			return this;
		}

		public Builder setSecondName(String secondName) {
			Contact.this.secondName = secondName;
			return this;
		}

		public Builder setPatronymic(String patronymic) {
			Contact.this.patronymic = patronymic;
			return this;
		}

		public Builder setNickName(String nickName) {
			Contact.this.nickName = nickName;
			return this;
		}

		public Builder setComment(String comment) {
			Contact.this.comment = comment;
			return this;
		}

		public Builder setContactGroup(ContactGroup contactGroup) {
			Contact.this.contactGroup = contactGroup;
			return this;
		}

		public Builder setMobileNumber(String mobileNumber) {
			Contact.this.mobileNumber = mobileNumber;
			return this;
		}

		public Builder setMobileNumber2(String mobileNumber2) {
			Contact.this.additionalMobileNumber = mobileNumber2;
			return this;
		}

		public Builder setEMail(String eMail) {
			Contact.this.eMail = eMail;
			return this;
		}

		public Builder setSkype(String skype) {
			Contact.this.skype = skype;
			return this;
		}

		public Builder setIndex(String index) {
			Contact.this.index = index;
			return this;
		}

		public Builder setCity(String city) {
			Contact.this.city = city;
			return this;
		}

		public Builder setStreet(String street) {
			Contact.this.street = street;
			return this;
		}

		public Builder setHouseNumber(String houseNumber) {
			Contact.this.houseNumber = houseNumber;
			return this;
		}

		public Builder setApartmentNumber(String apartmentNumber) {
			Contact.this.apartmentNumber = apartmentNumber;
			return this;
		}

		public Builder setDateOfCreate(String dateOfCreate) {
			Contact.this.dateOfCreate = dateOfCreate;
			return this;

		}

		public Builder setDateOfLastChange(String dateOfLastChange) {
			Contact.this.dateOfLastChange = dateOfLastChange;
			return this;

		}

		public Contact build() {
			return Contact.this;
		}
	}
}
