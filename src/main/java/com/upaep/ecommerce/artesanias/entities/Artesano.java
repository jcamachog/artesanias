package com.upaep.ecommerce.artesanias.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "artesanos")
public class Artesano implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "clave")
    @NotNull
    private String clave;

    @Column(name = "nombres")
    @NotNull
    private String nombres;

    @Column(name = "apellidopaterno")
    @NotNull
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;

    @JoinColumn(name = "idpais", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pais pais;

    @Column(name = "correoelectronico")
    @NotNull
    private String correoElectronico;

    @Column(name = "clavetelefonica")
    @NotNull
    private String claveTelefonica;

    @Column(name = "numerocelular")
    @NotNull
    private String numeroCelular;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "referenciaentrega")
    private String referenciaEntrega;

    @Column(name = "fechacreacion")
    @NotNull
    private String fechaCreacion;

    @Column(name = "fechaactualizacion")
    private String fechaActualizacion;

    @Column(name = "estado")
    @NotNull
    private Boolean estado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artesano artesano = (Artesano) o;
        return id.equals(artesano.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "com.upaep.ecommerce.artesanias.entities.Artesano{" +
                "id=" + id +
                '}';
    }
}
