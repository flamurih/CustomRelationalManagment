package exception;

public class ContractException extends RuntimeException{
    public ContractException(String message){
        super(message);
    }
    public ContractException(Throwable cause)
    {
        super(cause);
    }
}
