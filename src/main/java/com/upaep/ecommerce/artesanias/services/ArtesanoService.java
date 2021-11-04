package com.upaep.ecommerce.artesanias.services;

import com.upaep.ecommerce.artesanias.entities.Artesano;
import com.upaep.ecommerce.artesanias.entities.Pais;
import com.upaep.ecommerce.artesanias.models.ArtesanoModel;
import com.upaep.ecommerce.artesanias.repositories.ArtesanoRepository;
import com.upaep.ecommerce.artesanias.repositories.PaisRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtesanoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArtesanoService.class);

    private ModelMapper modelMapper;
    private ArtesanoRepository artesanoRepository;
    private PaisRepository paisRepository;

    @Autowired
    public ArtesanoService(ModelMapper modelMapper, ArtesanoRepository artesanoRepository, PaisRepository paisRepository) {
        this.modelMapper = modelMapper;
        this.artesanoRepository = artesanoRepository;
        this.paisRepository = paisRepository;
    }

    public ArtesanoModel obtenerPorClave(String clave) {
        Artesano entity = artesanoRepository.findByClave(clave);
        if(entity == null) return null;
        ArtesanoModel artesanoModel = modelMapper.map(entity, ArtesanoModel.class);
        return artesanoModel;
    }

    public List<ArtesanoModel> obtenerLista() {
        List<Artesano> artesanos = artesanoRepository.findAll();

        return artesanos
                .stream()
                .map(artesano -> modelMapper.map(artesano, ArtesanoModel.class))
                .collect(Collectors.toList());
    }

    public ArtesanoModel crearArtesano(ArtesanoModel model) {
        Artesano artesano = modelMapper.map(model, Artesano.class);

        Pais pais = paisRepository.getById(model.getPais().getId());
        artesano.setClave(String.valueOf(Math.random())); // Genera una clave numerica aleatoria provisional
        artesano.setPais(pais);
        artesano.setFechaCreacion(Instant.now().toString());
        artesano.setEstado(true);

        Artesano entity = artesanoRepository.save(artesano);

        entity.setClave(pais.getClave()+"-"+entity.getId());

        Artesano entityUpdated = artesanoRepository.save(entity);

        ArtesanoModel artesanoModel = modelMapper.map(entityUpdated, ArtesanoModel.class);

        LOGGER.info("Nuevo Artesano {}", artesanoModel);
        return artesanoModel;
    }
}
