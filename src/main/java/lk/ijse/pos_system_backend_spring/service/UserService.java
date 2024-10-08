package lk.ijse.pos_system_backend_spring.service;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    UserDto getUserById(String userId);
    List<UserDto> getAllUsers();
    void updateUser(String userId, UserDto userDto);
    void deleteUser(String userId);
}
