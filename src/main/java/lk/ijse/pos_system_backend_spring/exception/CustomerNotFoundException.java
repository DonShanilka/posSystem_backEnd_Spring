package lk.ijse.pos_system_backend_spring.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message){
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public CustomerNotFoundException(Throwable cause){
        super(cause);
    }
}
