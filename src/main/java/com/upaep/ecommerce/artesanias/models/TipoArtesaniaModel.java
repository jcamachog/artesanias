package com.upaep.ecommerce.artesanias.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class TipoArtesaniaModel implements Serializable {

    private Integer id;

    private String tipoArtesania;
}
