package com.upaep.ecommerce.artesanias.models;

import com.upaep.ecommerce.artesanias.constraints.ArtesanoValid;
import com.upaep.ecommerce.artesanias.constraints.MonedaValid;
import com.upaep.ecommerce.artesanias.constraints.TipoArtesaniaValid;
import com.upaep.ecommerce.artesanias.constraints.group.Add;
import lombok.Data;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ArtesaniaModel implements Serializable {

    private Integer id;

    @NotNull(message = "El nombre de la artesania es requerido", groups = {Add.class})
    @NotEmpty(message = "El nombre de la artesania es requerido", groups = {Add.class})
    private String nombre;

    @NotNull(message = "La descripcion de la artesania es requerido", groups = {Add.class})
    @NotEmpty(message = "La descripcion de la artesania es requerido", groups = {Add.class})
    private String descripcion;

    @TipoArtesaniaValid(message = "El tipo de artesania no existe", groups = {Add.class})
    @NotNull(message = "El tipo de artesania es obligatorio", groups = {Add.class})
    private TipoArtesaniaModel tipoArtesania;

    @ArtesanoValid( message = "El artesano no existe", groups = {Add.class})
    @NotNull(message = "El artesano es obligatorio", groups = {Add.class})
    private ArtesanoModel artesano;

    @MonedaValid(message = "La moneda no existe", groups = {Add.class})
    @NotNull(message = "La moneda es obligatoria", groups = {Add.class})
    private MonedaModel moneda;

    @DecimalMin(value = "1.00", message = "El precio debe ser mayor a 0", groups = {Add.class})
    private BigDecimal precio;

    @NotNull(message = "La imagen de la artesania es requerida", groups = {Add.class})
    @NotEmpty(message = "La imagen de la artesania es requerida", groups = {Add.class})
    private String rutaImagen;

    private Boolean aprobado;

    private String fechaCreacion;
}
