package exception;

public class ContactException extends RuntimeException{
    public ContactException(String message){
        super(message);
    }
    public ContactException(Throwable cause)
    {
        super(cause);
    }
}
