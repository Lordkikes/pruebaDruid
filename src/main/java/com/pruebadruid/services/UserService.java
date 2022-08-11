package com.pruebadruid.services;

import com.pruebadruid.dto.UserDTO;
import com.pruebadruid.entities.UserEntity;
import com.pruebadruid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> listAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> getOne(Long id){
        return userRepository.findById(id);
    }

    public Optional<UserEntity> getByName(String name){
        return userRepository.findByName(name);
    }

    public void  save(UserEntity user){
        userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return userRepository.existsByName(name);
    }

}
