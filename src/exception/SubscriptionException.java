package exception;

public class SubscriptionException extends RuntimeException{
    public SubscriptionException(String message){
        super(message);
    }
    public SubscriptionException(Throwable cause)
    {
        super(cause);
    }
}
