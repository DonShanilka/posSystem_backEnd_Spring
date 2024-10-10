package lk.ijse.pos_system_backend_spring.customStatusCode;

import lk.ijse.pos_system_backend_spring.dto.custom.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserErrorStatus implements UserStatus {
    private int status;
    private String statusMessage;
}
