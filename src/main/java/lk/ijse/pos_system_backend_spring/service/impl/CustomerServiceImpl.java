package lk.ijse.pos_system_backend_spring.service.impl;


import jakarta.transaction.Transactional;
import lk.ijse.pos_system_backend_spring.customStatusCode.SelectedCustomerErrorStatus;
import lk.ijse.pos_system_backend_spring.dao.CustomerDao;
import lk.ijse.pos_system_backend_spring.dto.custom.CustomerStatus;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.CustomerDto;
import lk.ijse.pos_system_backend_spring.entity.impl.Customer;
import lk.ijse.pos_system_backend_spring.exception.CustomerNotFoundException;
import lk.ijse.pos_system_backend_spring.exception.DataPersistException;
import lk.ijse.pos_system_backend_spring.service.CustomerService;
import lk.ijse.pos_system_backend_spring.util.AppUtil;
import lk.ijse.pos_system_backend_spring.util.Mapping;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao dao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(CustomerDto dto) {
        dto.setCustomerID(AppUtil.generateCustomerId());
        Customer savedCustomer = dao.save(mapping.toCustomerEntity(dto));

        if (savedCustomer == null){
            throw new DataPersistException("Customer has not saved");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> foundCustomer = dao.findById(id);

        if (!foundCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> allCustomer = dao.findAll();
        return mapping.asCustomerDto(allCustomer);
    }

    @SneakyThrows
    @Override
    public CustomerStatus getCustomer(String id) {
        if (dao.existsById(id)){
            Customer selectedCustomer = dao.getReferenceById(id);
            return mapping.toCustomerDto(selectedCustomer);
        } else {
            return new SelectedCustomerErrorStatus(2, "Selected Customer Not Found");
        }
    }

    @Override
    public void updateCustomer(CustomerDto dto, String id) {
        Optional<Customer> byId = dao.findById(id);

        if (!byId.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found");
        } else {
            byId.get().setCustomerName(dto.getCustomerName());
            byId.get().setCustomerAddress(dto.getAddress());
            byId.get().setCustomerPhone(dto.getContactNo());
        }
    }
}
