package lk.ijse.pos_system_backend_spring.service.impl;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDetailsDto;
import lk.ijse.pos_system_backend_spring.service.OrderDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailsService {
    @Override
    public void saveOrderDetail(OrderDetailsDto orderDetailDto) {

    }

    @Override
    public OrderDetailsDto getOrderDetailById(String orderDetailId) {
        return null;
    }

    @Override
    public List<OrderDetailsDto> getAllOrderDetails() {
        return List.of();
    }

    @Override
    public void updateOrderdetail(String orderDetailId, OrderDetailsDto orderDetailDto) {

    }

    @Override
    public void deleteOrderDetail(String orderDetailId) {

    }
}
