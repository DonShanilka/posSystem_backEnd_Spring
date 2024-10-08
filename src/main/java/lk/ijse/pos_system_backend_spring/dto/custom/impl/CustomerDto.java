package lk.ijse.pos_system_backend_spring.dto.custom.impl;

import lk.ijse.pos_system_backend_spring.dto.custom.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements CustomerStatus {
    private String customerID;
    private String customerName;
    private String address;
    private String contactNo;
    private List<OrderDto> orderDto;
}
