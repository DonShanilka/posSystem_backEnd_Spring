package lk.ijse.pos_system_backend_spring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.pos_system_backend_spring.dao.OrderDao;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDto;
import lk.ijse.pos_system_backend_spring.entity.impl.Order;
import lk.ijse.pos_system_backend_spring.exception.DataPersistException;
import lk.ijse.pos_system_backend_spring.service.OrderService;
import lk.ijse.pos_system_backend_spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDto orderDto) {
        Order order = mapping.toOrderEntity(orderDto);
        Order savedOrder = orderDao.save(order);

        if (savedOrder == null) {
            throw new DataPersistException("Order not saved");
        }
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
