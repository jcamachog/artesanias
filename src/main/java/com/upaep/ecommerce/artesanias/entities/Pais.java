package com.upaep.ecommerce.artesanias.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "paises")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "clave")
    private String clave;

    @Column(name = "pais")
    private String pais;

    @Column(name = "fechacreacion")
    private String fechaCreacion;

    @Column(name = "fechaactualizacion")
    private String fechaActualizacion;

    @Column(name = "estado")
    private Boolean estado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return id.equals(pais.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "com.upaep.ecommerce.artesanias.entities.Pais{" +
                "id=" + id +
                '}';
    }
}
