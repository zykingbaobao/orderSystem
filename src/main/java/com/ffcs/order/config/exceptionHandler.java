package com.ffcs.order.config;

import io.jsonwebtoken.SignatureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
//public class exceptionHandler {
//    @ExceptionHandler(value = { SignatureException.class })
//    @ResponseBody
//    public ResultBO<?> authorizationException(SignatureException e){
//        return ResultTool.error(new ExceptionInfoBO(1008,e.getMessage()));
//    }
//
//}
