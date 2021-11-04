package com.upaep.ecommerce.artesanias.services;

import com.upaep.ecommerce.artesanias.entities.Comprador;
import com.upaep.ecommerce.artesanias.entities.Pais;
import com.upaep.ecommerce.artesanias.models.CompradorModel;
import com.upaep.ecommerce.artesanias.repositories.CompradorRepository;
import com.upaep.ecommerce.artesanias.repositories.PaisRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CompradorService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompradorService.class);

    private ModelMapper modelMapper;
    private CompradorRepository compradorRepository;
    private PaisRepository paisRepository;

    @Autowired
    public CompradorService(ModelMapper modelMapper, CompradorRepository compradorRepository, PaisRepository paisRepository) {
        this.modelMapper = modelMapper;
        this.compradorRepository = compradorRepository;
        this.paisRepository = paisRepository;
    }

    public CompradorModel crearComprador(CompradorModel model) {
        Comprador comprador = modelMapper.map(model, Comprador.class);

        Pais pais = paisRepository.getById(model.getPais().getId());

        comprador.setPais(pais);
        comprador.setFechaCreacion(Instant.now().toString());
        comprador.setEstado(true);

        Comprador entity = compradorRepository.save(comprador);

        CompradorModel compradorModel = modelMapper.map(entity, CompradorModel.class);

        LOGGER.info("Nuevo Comprador {}", compradorModel);
        return compradorModel;
    }
}
