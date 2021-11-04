package com.upaep.ecommerce.artesanias.models;

import com.upaep.ecommerce.artesanias.constraints.ArtesaniaValid;
import com.upaep.ecommerce.artesanias.constraints.ArtesanoValid;
import com.upaep.ecommerce.artesanias.constraints.CompradorValid;
import com.upaep.ecommerce.artesanias.constraints.group.Add;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CalificacionModel implements Serializable {

    private Integer id;

    @NotNull(message = "El artesano es un campo obligatorio", groups = {Add.class})
    @ArtesanoValid( message = "El artesano no existe", groups = {Add.class})
    private ArtesanoModel artesano;

    @NotNull(message = "El comprador es un campo obligatorio", groups = {Add.class})
    @CompradorValid(message = "El comprador no existe", groups = {Add.class})
    private CompradorModel comprador;

    @NotNull(message = "La artesanía es un campo obligatorio", groups = {Add.class})
    @ArtesaniaValid(message = "La artesanía elegida no existe", groups = {Add.class})
    private ArtesaniaModel artesania;

    @NotNull(message = "La calificacion es un campo obligatorio", groups = {Add.class})
    @Max(value = 5, message = "El valor máximo es 5", groups = {Add.class})
    @Min(value = 1, message = "El valor mínimo es 1", groups = {Add.class})
    private Integer calificacion;

    private String comentario;

    private String fechaCreacion;
}
