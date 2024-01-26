package ru.altacod.prmo.service;

import org.modelmapper.ModelMapper;
import ru.altacod.prmo.DTO.UserDTO;
import ru.altacod.prmo.model.User;
import ru.altacod.prmo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(UserDTO user) {
        User userEntity = toEntity(user);
        return userRepository.save(userEntity);
    }

    public User updateUser(Long id, UserDTO userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setPassword(userDetails.getPassword()); // Здесь должно быть шифрование пароля
                    user.setRole(userDetails.getRole());
                    user.setDepartmentId(userDetails.getDepartmentId());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    userDetails.setUserId(id);
                    User userEntity=toEntity(userDetails);
                    return userRepository.save(userEntity);
                });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
