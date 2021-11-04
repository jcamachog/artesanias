package com.upaep.ecommerce.artesanias.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class PaisModel implements Serializable {

    private Integer id;

    private String clave;

    private String pais;
}
