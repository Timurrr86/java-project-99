package hexlet.code.service;

import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.UserMapper;
import hexlet.code.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getAll() {
        var users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .toList();
    }

    public UserDTO findById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        return userMapper.map(user);
    }

    public UserDTO create(UserCreateDTO dto) {
        var user = userMapper.map(dto);
        var hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPasswordDigest(hashedPassword);
        userRepository.save(user);
        return userMapper.map(user);
    }

    public UserDTO update(UserUpdateDTO dto, Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
        userMapper.update(dto, user);
        var hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPasswordDigest(hashedPassword);
        userRepository.save(user);
        return userMapper.map(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
