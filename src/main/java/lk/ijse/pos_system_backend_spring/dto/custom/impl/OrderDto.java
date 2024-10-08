package lk.ijse.pos_system_backend_spring.dto.custom.impl;

import lk.ijse.pos_system_backend_spring.dto.custom.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements OrderStatus {
    private Long orderId;
    private String customerId;
    private String orderDate;
    private List<OrderDetailsDto> orderDetailsDto;
}
