package com.upaep.ecommerce.artesanias.services;

import com.upaep.ecommerce.artesanias.entities.Pais;
import com.upaep.ecommerce.artesanias.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    private PaisRepository paisRepository;

    @Autowired
    public PaisService(PaisRepository repository) {
        paisRepository = repository;
    }

    public List<Pais> getPaises() {
        return paisRepository.findAll();
    }
}
