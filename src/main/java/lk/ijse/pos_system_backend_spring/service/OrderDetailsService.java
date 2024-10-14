package lk.ijse.pos_system_backend_spring.service;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDetailsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailsService {
    void saveOrderDetail(OrderDetailsDto orderDetailsDto);
    OrderDetailsDto getOrderDetailById(String orderDetailId);
    List<OrderDetailsDto> getAllOrderDetails();
    void updateOrderdetail(String orderDetailId, OrderDetailsDto orderDetailsDto);
    void deleteOrderDetail(String orderDetailId);
}
