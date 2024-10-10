package lk.ijse.pos_system_backend_spring.dao;

import lk.ijse.pos_system_backend_spring.entity.impl.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
}
