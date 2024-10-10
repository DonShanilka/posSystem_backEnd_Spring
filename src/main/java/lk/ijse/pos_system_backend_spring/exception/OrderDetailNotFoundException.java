package lk.ijse.pos_system_backend_spring.exception;

public class OrderDetailNotFoundException extends RuntimeException {
    public OrderDetailNotFoundException(String message) {
        super(message);
    }

    public OrderDetailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDetailNotFoundException(Throwable cause) {
        super(cause);
    }
}
