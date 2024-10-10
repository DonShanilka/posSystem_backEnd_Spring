package lk.ijse.pos_system_backend_spring.customStatusCode;

import lk.ijse.pos_system_backend_spring.dto.custom.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedOrderErrorStatus implements OrderStatus {
    private int status;
    private String statusMessage;
}
