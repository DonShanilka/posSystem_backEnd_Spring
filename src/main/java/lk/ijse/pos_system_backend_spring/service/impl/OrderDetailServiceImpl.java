package lk.ijse.pos_system_backend_spring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.pos_system_backend_spring.dao.OrderDetailDao;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDetailsDto;
import lk.ijse.pos_system_backend_spring.entity.impl.OrderDetail;
import lk.ijse.pos_system_backend_spring.exception.DataPersistException;
import lk.ijse.pos_system_backend_spring.exception.OrderDetailNotFoundException;
import lk.ijse.pos_system_backend_spring.service.OrderDetailsService;
import lk.ijse.pos_system_backend_spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
        Optional<OrderDetail> orderDetail = orderDetailDao.findById(orderDetailId);
        if (orderDetail.isPresent()) {
            return mapping.toOrderDetailDto(orderDetail.get());
        } else {
            throw new OrderDetailNotFoundException("OrderDetail not found");
        }
    }

    @Override
    public List<OrderDetailsDto> getAllOrderDetails() {
        List<OrderDetail> allOrderDetails = orderDetailDao.findAll();
        return mapping.asOrderDetailDto(allOrderDetails);
    }

    @Override
    public void updateOrderdetail(String orderDetailId, OrderDetailsDto orderDetailDto) {
        Optional<OrderDetail> orderDetailOptional = orderDetailDao.findById(orderDetailId);
        if (orderDetailOptional.isPresent()) {
            OrderDetail orderDetailToUpdate = orderDetailOptional.get();

            orderDetailToUpdate.setQty(orderDetailDto.getQuantity());
            orderDetailToUpdate.setUnitPrice(orderDetailDto.getUnitPrice());
            orderDetailToUpdate.setItem(mapping.toItemEntity(orderDetailDto.getItemDto()));

            orderDetailDao.save(orderDetailToUpdate);
        } else {
            throw new OrderDetailNotFoundException("OrderDetail not found for update");
        }
    }

    @Override
    public void deleteOrderDetail(String orderDetailId) {
        Optional<OrderDetail> orderDetailOptional = orderDetailDao.findById(orderDetailId);
        if (orderDetailOptional.isPresent()) {
            orderDetailDao.deleteById(orderDetailId);
        } else {
            throw new OrderDetailNotFoundException("OrderDetail not found for deletion");
        }
    }
}
