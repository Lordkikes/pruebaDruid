package com.pruebadruid.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String nameResource;
    private String nameField;
    private Long valueField;

    public ResourceNotFoundException(String nameResource, String nameField, Long valueField) {
        super(String.format("%s not found with : %s : '%s'",nameResource, nameField, valueField));
        this.nameResource = nameResource;
        this.nameField = nameField;
        this.valueField = valueField;
    }
}
