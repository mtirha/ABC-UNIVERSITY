package edu.miu.adminservice.exception;

public class AdminException extends RuntimeException{
	 public AdminException(String message){
	        super(message);
	    }
	    public AdminException(long id){
	        super("Id not Found"+id);
	    }
}
