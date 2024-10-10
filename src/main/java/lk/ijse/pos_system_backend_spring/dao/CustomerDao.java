package lk.ijse.pos_system_backend_spring.dao;

import lk.ijse.pos_system_backend_spring.entity.impl.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,String> {
}
