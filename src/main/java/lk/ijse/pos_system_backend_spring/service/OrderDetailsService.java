package lk.ijse.pos_system_backend_spring.service;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsService {
    void saveOrderDetail(OrderDetailsDto orderDetailsDto);
    OrderDetailsDto getOrderDetailById(String orderDetailId);
    List<OrderDetailsDto> getAllOrderDetails();
    void updateOrderdetail(String orderDetailId, OrderDetailsDto orderDetailsDto);
    void deleteOrderDetail(String orderDetailId);
}
