package com.example.demo.advice;

import com.example.demo.exception.ServiceException;
import com.example.demo.utils.Result;
import com.example.demo.utils.ResultUtil;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResultUtil.error(400, objectError.getDefaultMessage());
    }

    @ExceptionHandler(value = ServiceException.class)
    public Result handleServiceException(ServiceException e) {
        return ResultUtil.error(500, e.getMessage());
    }
}
