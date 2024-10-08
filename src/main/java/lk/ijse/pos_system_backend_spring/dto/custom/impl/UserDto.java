package lk.ijse.pos_system_backend_spring.dto.custom.impl;

import lk.ijse.pos_system_backend_spring.dto.custom.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements UserStatus {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private List<CustomerDto> customerDto;
    private List<ItemDto> itemDto;
}
