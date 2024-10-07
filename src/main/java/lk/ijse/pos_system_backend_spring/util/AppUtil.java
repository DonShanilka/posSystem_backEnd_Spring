package lk.ijse.pos_system_backend_spring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateUserId(){
        return "USERID-" + UUID.randomUUID();
    }

    public static String generateCustomerId(){
        return "CUSTOMERID-" + UUID.randomUUID();
    }

    public static String generateItemId(){
        return "ITEMID-" + UUID.randomUUID();
    }

    public static String generateOrderId(){
        return "ORDERID-" + UUID.randomUUID();
    }

    public static String generateOrderDetailsId(){
        return "ORDERDETAILSID-" + UUID.randomUUID();
    }
}
