package model;

public class UniqueNickNameException extends Exception{
		
	    private String nickname;
	    private Contact contact;
	    
	    public UniqueNickNameException(String message){
	     
	        super(message);
	        
	    }
	

}
