package lk.ijse.pos_system_backend_spring.customStatusCode;

import lk.ijse.pos_system_backend_spring.dto.custom.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomerErrorStatus implements CustomerStatus {
    private int status;
    private String statusMessage;
}
