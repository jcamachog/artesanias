package com.upaep.ecommerce.artesanias.utils;

import com.upaep.ecommerce.artesanias.models.CustomError;
import com.upaep.ecommerce.artesanias.models.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public enum ResultUtils {

    INSTANCE;

    public <T> Result<T> getFailResult(BindingResult bindingResult, Result<T> result) {

        Logger logger = LoggerFactory.getLogger(ResultUtils.class);

        result.setStatus(Result.fail);
        List<ObjectError> errorList = bindingResult.getAllErrors();

        StringBuilder messages = new StringBuilder();
        errorList.forEach(error -> {
            CustomError customError = new CustomError();
            for (Object e : error.getArguments()) {
                customError.setField(((DefaultMessageSourceResolvable)e).getDefaultMessage());
                break;
            }
            customError.setMessage(error.getDefaultMessage());
            result.getErrors().add(customError);
        });
        return result;
    }
}
