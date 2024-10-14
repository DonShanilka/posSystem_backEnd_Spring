package lk.ijse.pos_system_backend_spring.service.impl;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDto;
import lk.ijse.pos_system_backend_spring.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(OrderDto orderDto) {

    }

    @Override
    public OrderDto getOrderById(String orderId) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return List.of();
    }

    @Override
    public void updateOrder(String orderId, OrderDto orderDto) {

    }

    @Override
    public void deleteOrder(String orderId) {

    }
}
