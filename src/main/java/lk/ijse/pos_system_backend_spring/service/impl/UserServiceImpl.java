package lk.ijse.pos_system_backend_spring.service.impl;


import lk.ijse.pos_system_backend_spring.dto.custom.impl.UserDto;
import lk.ijse.pos_system_backend_spring.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(UserDto userDto) {

    }

    @Override
    public UserDto getUserById(String userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public void updateUser(String userId, UserDto userDto) {

    }

    @Override
    public void deleteUser(String userId) {

    }
}
