package lk.ijse.pos_system_backend_spring.util;

import java.util.regex.Pattern;

public class RegexUtil {
    private static final String CUSTOMER_ID_REGEX = "^CUSID-[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final String USER_ID_REGEX = "^USERID-[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final String ITEM_ID_REGEX = "^ITEMID-[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final String ORDER_ID_REGEX = "^ORDERID-[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final String ORDERDETAIL_ID_REGEX = "^ORDERDETAILID-[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    public static boolean isValidCustomerId(String customerId) {
        Pattern regexPattern = Pattern.compile(CUSTOMER_ID_REGEX);
        return regexPattern.matcher(customerId).matches();
    }

    public static boolean isValidItemId(String itemId) {
        Pattern regexPattern = Pattern.compile(ITEM_ID_REGEX);
        return regexPattern.matcher(itemId).matches();
    }

    public static boolean isValidUserId(String userId){
        Pattern regexPattern = Pattern.compile(USER_ID_REGEX);
        return regexPattern.matcher(userId).matches();
    }

    public static boolean isValidOrderId(String orderId){
        Pattern regexPattern = Pattern.compile(ORDER_ID_REGEX);
        return regexPattern.matcher(orderId).matches();
    }

    public static boolean isValidOrderDetailId(String orderDetailId){
        Pattern regexPattern = Pattern.compile(ORDERDETAIL_ID_REGEX);
        return regexPattern.matcher(orderDetailId).matches();
    }
}
