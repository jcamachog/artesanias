package com.upaep.ecommerce.artesanias.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "artesanias")
public class Artesania implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    @NotNull
    private String nombre;

    @Column(name = "descripcion")
    @NotNull
    private String descripcion;

    @JoinColumn(name = "idtipoartesania", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoArtesania tipoArtesania;

    @JoinColumn(name = "idtipomoneda", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moneda moneda;

    @JoinColumn(name = "idartesano", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Artesano artesano;

    @Column(name = "precio")
    @NotNull
    private Float precio;

    @Column(name = "rutaimagen")
    @NotNull
    private String rutaImagen;

    @Column(name = "fechacreacion")
    @NotNull
    private String fechaCreacion;

    @Column(name = "aprobado")
    @NotNull
    private Boolean aprobado;

    @Column(name = "fechaactualizacion")
    private String fechaActualizacion;

    @Column(name = "estado")
    private Boolean estado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artesania artesania = (Artesania) o;
        return id.equals(artesania.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "com.upaep.ecommerce.artesanias.entities.Artesania{" +
                "id=" + id +
                '}';
    }
}
