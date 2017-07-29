package regexTask;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class NoteBookService {
	
	NoteBook noteBook = new NoteBook(new ArrayList<Contact>());
	
	/**
	 * Name, SecondName, Patronymic
	 */
	public static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z][a-z]{1,25}$");
	public static final Pattern NICKNAME_PATTERN = Pattern.compile("^[^\\s*][A-Za-z0-9_-]{1,25}$");
	public static final Pattern COMMENT_PATTERN = Pattern.compile("^.{1,50}");
	/**
	 * phone number in format +38000-000-00-00
	 */
	public static final Pattern PHONE_PATTERN = Pattern.compile("^\\+380[0-9]{9}$");
	public static final Pattern ADDITIONAL_PHONE_PATTERN = Pattern.compile("^\\+380[0-9]{9}||\\s{1}$");
	public static final Pattern MAIL_PATTERN = Pattern.compile("^[A-Za-z0-9_]{2,255}@[a-z]{1,15}\\.[a-z]{1,5}$");
	public static final Pattern INDEX_PATTERN = Pattern.compile("^[0-9]{5}$");
	public static final Pattern CITY__PATTERN = Pattern.compile("^[A-Z][a-z]{1,15}[-A-Z]*{1,15}[a-z]*{1,15}[-A-Z]*{1,15}[a-z]*{1,15}$");
	/**
	 * for streets (include numerals and space).
	 */
	public static final Pattern STREET_PATTERN = Pattern.compile("^[A-Z][a-z]{1,25}[\\s-A-Z]*{1,25}[\\sa-z]*{1,25}[\\s-A-Z]*{1,25}[\\sa-z]*{1,25}$");
	public static final Pattern HOUSE_AND_APPARTMENT_PATTERN = Pattern.compile("^[0-9]{1,3}-*[A-Za-z]*{1}$");
	/**
	 * dd-mm-yyyy format
	 */
	public static final Pattern DATE_PATTERN = Pattern.compile("^[0-3][0-9]-[0-1][0-9]-20[0-9]{2}$");
	
	
	

	

	

	

}
