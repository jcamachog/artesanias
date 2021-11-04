package com.upaep.ecommerce.artesanias.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {

    public static final String success = "success";
    public static final String fail = "fail";

    private String status = success;
    private String message = "";
    private List<CustomError> errors = new ArrayList<>();
    private T data;
}
