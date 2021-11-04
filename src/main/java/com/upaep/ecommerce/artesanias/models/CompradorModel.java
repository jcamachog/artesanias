package com.upaep.ecommerce.artesanias.models;

import com.upaep.ecommerce.artesanias.constraints.CorreoCompradorValid;
import com.upaep.ecommerce.artesanias.constraints.PaisValid;
import com.upaep.ecommerce.artesanias.constraints.group.Add;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class CompradorModel implements Serializable {

    private Integer id;

    @NotNull(message = "El nombre del comprador es requerido", groups = {Add.class})
    private String nombres;

    @NotNull(message = "El apellidpo paterno del comprador es requerido", groups = {Add.class})
    private String apellidoPaterno;

    private String apellidoMaterno;

    @NotNull(message = "El país de origen del comprador es requerido", groups = {Add.class})
    @PaisValid(message = "El país no existe", groups = {Add.class})
    private PaisModel pais;

    @NotNull(message = "El correo electrónico del comprador es requerido", groups = {Add.class})
    @CorreoCompradorValid(message = "El correo electrónico ya esta registrado", groups = {Add.class})
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "El correo electrónico no tiene el formato correcto", groups = {Add.class})
    private String correoElectronico;

    @NotNull(message = "El la clave telefónica es requerida", groups = {Add.class})
    private String claveTelefonica;

    @NotNull(message = "El número telefónico del comprador es requerido", groups = {Add.class})
    private String numeroCelular;

    private String fechaCreacion;
}
