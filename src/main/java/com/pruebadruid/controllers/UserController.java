package com.pruebadruid.controllers;

import com.pruebadruid.dto.Message;
import com.pruebadruid.dto.UserDTO;
import com.pruebadruid.entities.UserEntity;
import com.pruebadruid.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        if(StringUtils.isBlank(userDTO.getName()))
            return new ResponseEntity(new Message("The Name is Required"), HttpStatus.BAD_REQUEST);
        /*if(userDTO.getPrecio()==null || productoDto.getPrecio()<0 )
            return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(productoService.existsByNombre(productoDto.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);*/
        UserEntity user = new UserEntity(userDTO.getName(), userDTO.getLastName(), userDTO.getPassword(), userDTO.getBirthDate());
        userService.save(user);
        return new ResponseEntity(new Message("User Created"), HttpStatus.OK);
    }

  /*  @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted...", HttpStatus.OK);
    }

   */
}
