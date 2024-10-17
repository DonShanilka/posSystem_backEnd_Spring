package lk.ijse.pos_system_backend_spring.service.impl;

import lk.ijse.pos_system_backend_spring.dao.OrderDetailDao;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDetailsDto;
import lk.ijse.pos_system_backend_spring.entity.impl.OrderDetail;
import lk.ijse.pos_system_backend_spring.exception.DataPersistException;
import lk.ijse.pos_system_backend_spring.service.OrderDetailsService;
import lk.ijse.pos_system_backend_spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrderDetail(OrderDetailsDto orderDetailDto) {
        OrderDetail orderDetail = mapping.toOrderDetailEntity(orderDetailDto);

        OrderDetail savedOrderDetail = orderDetailDao.save(orderDetail);
        if (savedOrderDetail == null) {
            throw new DataPersistException("OrderDetail not saved");
        }
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
