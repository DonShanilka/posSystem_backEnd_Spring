package lk.ijse.pos_system_backend_spring.dto.custom.impl;

import lk.ijse.pos_system_backend_spring.dto.custom.OrderDetailsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto implements OrderDetailsStatus {
    private Long orderDetailsId;
    private String itemCode;
    private int quantity;
    private double unitPrice;
}
