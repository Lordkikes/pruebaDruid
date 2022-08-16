package com.pruebadruid.controllers;

import com.pruebadruid.dto.Message;
import com.pruebadruid.dto.UserDTO;
import com.pruebadruid.entities.UserEntity;
import com.pruebadruid.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listAll")
    public ResponseEntity<List<UserEntity>> listAll(){
        List<UserEntity> list = userService.listAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity(new Message("Fallo"), HttpStatus.NOT_ACCEPTABLE);
        }

        if(StringUtils.isBlank(userDTO.getName()))
            return new ResponseEntity(new Message("The Name is Required"), HttpStatus.BAD_REQUEST);
        UserEntity user = new UserEntity(userDTO.getName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getBirthDate());
        userService.save(user);
        return new ResponseEntity(new Message("User Created"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long id){
        if(!userService.existsById(id))
            return new ResponseEntity(new Message("not exists"), HttpStatus.NOT_FOUND);
        userService.delete(id);
        return new ResponseEntity(new Message("User deleted"), HttpStatus.OK);
    }


}
