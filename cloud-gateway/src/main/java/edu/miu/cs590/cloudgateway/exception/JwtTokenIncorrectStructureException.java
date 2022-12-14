package edu.miu.cs590.cloudgateway.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
@Slf4j
public class JwtTokenIncorrectStructureException extends RuntimeException{
    public JwtTokenIncorrectStructureException(String message){
        super(message);
        log.error(this.getClass().getName() + ": " + message);
    }
}
