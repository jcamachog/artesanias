package com.upaep.ecommerce.artesanias.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "clavestelefonicas")
public class ClaveTelefonica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "clave")
    @NotNull
    private String clave;

    @JoinColumn(name = "idpais", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pais pais;

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
        ClaveTelefonica that = (ClaveTelefonica) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "com.upaep.ecommerce.artesanias.entities.ClaveTelefonica{" +
                "id=" + id +
                '}';
    }
}
