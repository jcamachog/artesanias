package com.upaep.ecommerce.artesanias.repositories;

import com.upaep.ecommerce.artesanias.entities.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompradorRepository extends JpaRepository<Comprador, Integer> {

    Comprador findByCorreoElectronico(String correo);

}
