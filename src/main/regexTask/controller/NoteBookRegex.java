package controller;

import java.util.regex.Pattern;


public class NoteBookRegex {
	
	/**
	 * Name, SecondName, Patronymic. The first letter should be capitalized, the rest - lowercase. Max symbols - 25.
	 */
	public static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z][a-z]{1,25}$");
	
	/**
	 * Nickname, Skype. Any A-z letters, symbols ".", "_", and "-". Max symbols - 25.
	 */
	public static final Pattern NICKNAME_PATTERN = Pattern.compile("^[^\\s*][\\.*A-Za-z0-9_-]{1,25}$");
	public static final Pattern COMMENT_PATTERN = Pattern.compile("^.{1,50}");
	/**
	 * phone number in format +38000-000-00-00
	 */
	public static final Pattern PHONE_PATTERN = Pattern.compile("^\\+380[0-9]{9}$");
	/**
	 * This pattern is identical PHONE_PATTERN, except for the opportunity to skip this field.
	 */
	public static final Pattern ADDITIONAL_PHONE_PATTERN = Pattern.compile("^\\+380[0-9]{9}||\\s{1}$");
	/**
	 * Mail adress. 2-255 symbols + "@" + domain name.
	 */
	public static final Pattern MAIL_PATTERN = Pattern.compile("^[A-Za-z0-9_]{2,255}@[a-z]{1,15}\\.[a-z]{1,5}$");
	public static final Pattern INDEX_PATTERN = Pattern.compile("^[0-9]{5}$");
	/**
	 * City. The first letter should be capitalized. It is possible to use two "-" symbols (exeple - Frankfurt-am-Main"). 
	 */
	public static final Pattern CITY__PATTERN = Pattern.compile("^[A-Z][a-z]{1,15}[-A-Z]*{1,15}[a-z]*{1,15}[-A-Z]*{1,15}[a-z]*{1,15}$");
	/**
	 * Streets. Include numerals and space.
	 */
	public static final Pattern STREET_PATTERN = Pattern.compile("^[A-Z][a-z]{1,25}[\\s-A-Z]*{1,25}[\\sa-z]*{1,25}[\\s-A-Z]*{1,25}[\\sa-z]*{1,25}$");
	public static final Pattern HOUSE_AND_APPARTMENT_PATTERN = Pattern.compile("^[0-9]{1,3}-*[A-Za-z]*{1}$");
}
