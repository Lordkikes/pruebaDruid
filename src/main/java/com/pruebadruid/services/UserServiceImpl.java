package com.pruebadruid.services;

import com.pruebadruid.dto.UserDTO;
import com.pruebadruid.entities.UserEntity;
import com.pruebadruid.exception.ResourceNotFoundException;
import com.pruebadruid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity userEntity = mapeerEntity(userDTO);
        UserEntity newUser = userRepository.save(userEntity);

        return mapperDTO(newUser);
    }

    @Override
    public UserDTO listAll() {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userRepository.delete(userEntity);

    }

    //Entity to DTO
    private UserDTO mapperDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setLastName(userEntity.getLastName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setBirthDate(userEntity.getBirthDate());
        return userDTO;
    }

    // DTO to Entity
    private UserEntity mapeerEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(userDTO.getName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setBirthDate(userDTO.getBirthDate());
        return userEntity;
    }
}
