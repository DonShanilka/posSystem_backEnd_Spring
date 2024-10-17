package lk.ijse.pos_system_backend_spring.service.impl;


import lk.ijse.pos_system_backend_spring.dao.OrderDao;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDto;
import lk.ijse.pos_system_backend_spring.entity.impl.Order;
import lk.ijse.pos_system_backend_spring.exception.DataPersistException;
import lk.ijse.pos_system_backend_spring.exception.OrderNotFoundException;
import lk.ijse.pos_system_backend_spring.service.OrderService;
import lk.ijse.pos_system_backend_spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        Optional<Order> orderOptional = orderDao.findById(orderId);

        if (orderOptional.isPresent()) {
            return mapping.toOrderDto(orderOptional.get());
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found");
        }
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderDao.findAll();
        return mapping.asOrderDto(orders);
    }

    @Override
    public void updateOrder(String orderId, OrderDto orderDto) {
        Optional<Order> orderOptional = orderDao.findById(orderId);

        if (!orderOptional.isPresent()) {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found");
        } else {
            Order orderToUpdate = orderOptional.get();
            orderToUpdate.setOrderDate(orderDto.getOrderDate());

            orderDao.save(orderToUpdate);
        }
    }

    @Override
    public void deleteOrder(String orderId) {
        Optional<Order> orderOptional = orderDao.findById(orderId);

        if (!orderOptional.isPresent()) {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found");
        } else {
            // Delete the order
            orderDao.deleteById(orderId);
        }
    }
}
