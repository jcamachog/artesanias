package com.upaep.ecommerce.artesanias.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "calificaciones")
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "idartesano", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Artesano artesano;

    @JoinColumn(name = "idcomprador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comprador comprador;

    @JoinColumn(name = "idartesania", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Artesania artesania;

    @Column(name = "fechacreacion")
    @NotNull
    private String fechaCreacion;

    @Column(name = "fechaactualizacion")
    private String fechaActualizacion;

    @Column(name = "calificacion")
    @NotNull
    private Integer calificacion;

    @Column(name = "comentario")
    private String comentario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calificacion that = (Calificacion) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "com.upaep.ecommerce.artesanias.entities.Calificacion{" +
                "id=" + id +
                '}';
    }
}
