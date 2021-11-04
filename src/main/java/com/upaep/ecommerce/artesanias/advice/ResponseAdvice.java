package com.upaep.ecommerce.artesanias.advice;

import com.upaep.ecommerce.artesanias.models.Result;
import com.upaep.ecommerce.artesanias.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestControllerAdvice(basePackages = "com.upaep.ecommerce.artesanias")
public class ResponseAdvice implements ResponseBodyAdvice {

    private final static Logger LOGGER = LoggerFactory.getLogger(ResponseAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(Objects.isNull(body)){
            return Result.builder().status("success").build();
        }

        if(body instanceof Result){
            return body;
        }

        return Result.builder().status("success").data(body).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> exceptionHandler(HttpServletRequest request, Exception e) {
        LOGGER.error(e.getMessage());
        return Result.builder().message(e.getMessage()).status(Result.fail).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Result<?> methodArgumentNotValidExceptionExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException methodArgumentNotValidException) {
        Result result = new Result();
        LOGGER.error("methodArgumentNotValidException");
        return ResultUtils.INSTANCE.getFailResult(methodArgumentNotValidException.getBindingResult(),result);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
    public Result<?> illegalArgumentExceptionHandler(HttpServletRequest request, IllegalArgumentException illegalArgumentExceptionException) {
        LOGGER.error("illegalArgumentExceptionException");
        return Result.builder().message(illegalArgumentExceptionException.getMessage()).status(Result.fail).build();
    }

}
