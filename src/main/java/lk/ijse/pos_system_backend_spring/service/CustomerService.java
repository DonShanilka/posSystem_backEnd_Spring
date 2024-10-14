package lk.ijse.pos_system_backend_spring.service;

import lk.ijse.pos_system_backend_spring.dto.custom.CustomerStatus;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    void saveCustomer(CustomerDto dto);
    void deleteCustomer(String id);
    List<CustomerDto> getAllCustomers();
    CustomerStatus getCustomer(String id);
    void updateCustomer(CustomerDto dto, String id);
}
