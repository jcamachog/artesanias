package com.upaep.ecommerce.artesanias.repositories;

import com.upaep.ecommerce.artesanias.entities.Artesania;
import com.upaep.ecommerce.artesanias.entities.Artesano;
import com.upaep.ecommerce.artesanias.entities.Calificacion;
import com.upaep.ecommerce.artesanias.entities.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {
    Calificacion findByArtesaniaAndCompradorAndArtesano(Artesania artesania, Comprador comprador, Artesano artesano);
}
