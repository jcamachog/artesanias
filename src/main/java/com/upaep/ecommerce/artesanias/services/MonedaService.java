package com.upaep.ecommerce.artesanias.services;

import com.upaep.ecommerce.artesanias.entities.Moneda;
import com.upaep.ecommerce.artesanias.repositories.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonedaService {

    private MonedaRepository monedaRepository;

    @Autowired
    public MonedaService(MonedaRepository repository) {
        monedaRepository = repository;
    }

    public List<Moneda> getMonedas() {
        return monedaRepository.findAll();
    }
}
