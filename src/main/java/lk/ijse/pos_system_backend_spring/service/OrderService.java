package lk.ijse.pos_system_backend_spring.service;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    void saveOrder(OrderDto orderDto);
    OrderDto getOrderById(String orderId);
    List<OrderDto> getAllOrders();
    void updateOrder(String orderId, OrderDto orderDto);
    void deleteOrder(String orderId);
}
