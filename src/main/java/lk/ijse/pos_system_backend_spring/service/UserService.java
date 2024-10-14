package lk.ijse.pos_system_backend_spring.service;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveUser(UserDto userDto);
    UserDto getUserById(String userId);
    List<UserDto> getAllUsers();
    void updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
}
