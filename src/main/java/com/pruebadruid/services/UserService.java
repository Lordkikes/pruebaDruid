package com.pruebadruid.services;

import com.pruebadruid.dto.UserDTO;

public interface UserService {

    public UserDTO createUser(UserDTO userDTO);

    public UserDTO listAll();

    public void deleteUserById(Long id);

}
