package com.upaep.ecommerce.artesanias.repositories;

import com.upaep.ecommerce.artesanias.entities.Artesano;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtesanoRepository extends JpaRepository<Artesano, Integer> {

    Artesano findByClave(String clave);

    Artesano findByCorreoElectronico(String correo);
}
