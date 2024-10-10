package lk.ijse.pos_system_backend_spring.customStatusCode;

import lk.ijse.pos_system_backend_spring.dto.custom.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedItemErrorStatus implements ItemStatus {
    private int status;
    private String statusMessage;
}
