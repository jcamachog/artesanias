package com.upaep.ecommerce.artesanias.services;

import com.upaep.ecommerce.artesanias.entities.Artesania;
import com.upaep.ecommerce.artesanias.entities.Artesano;
import com.upaep.ecommerce.artesanias.entities.Moneda;
import com.upaep.ecommerce.artesanias.entities.TipoArtesania;
import com.upaep.ecommerce.artesanias.models.ArtesaniaModel;
import com.upaep.ecommerce.artesanias.repositories.ArtesaniaRepository;
import com.upaep.ecommerce.artesanias.repositories.ArtesanoRepository;
import com.upaep.ecommerce.artesanias.repositories.MonedaRepository;
import com.upaep.ecommerce.artesanias.repositories.TipoArtesaniaRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ArtesaniaService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArtesaniaService.class);

    private ModelMapper modelMapper;
    private ArtesaniaRepository artesaniaRepository;
    private TipoArtesaniaRepository tipoArtesaniaRepository;
    private MonedaRepository monedaRepository;
    private ArtesanoRepository artesanoRepository;

    @Autowired
    public ArtesaniaService(ModelMapper modelMapper, ArtesaniaRepository artesaniaRepository, TipoArtesaniaRepository tipoArtesaniaRepository, MonedaRepository monedaRepository, ArtesanoRepository artesanoRepository) {
        this.modelMapper = modelMapper;
        this.artesaniaRepository = artesaniaRepository;
        this.tipoArtesaniaRepository = tipoArtesaniaRepository;
        this.monedaRepository = monedaRepository;
        this.artesanoRepository = artesanoRepository;
    }

    public ArtesaniaModel crearArtesania(ArtesaniaModel artesaniaModel) {
        Artesania artesania = modelMapper.map(artesaniaModel, Artesania.class);

        Moneda moneda = monedaRepository.getById(artesania.getMoneda().getId());
        TipoArtesania tipoArtesania = tipoArtesaniaRepository.getById(artesania.getTipoArtesania().getId());
        Artesano artesano = artesanoRepository.getById(artesania.getArtesano().getId());
        artesania.setMoneda(moneda);
        artesania.setTipoArtesania(tipoArtesania);
        artesania.setArtesano(artesano);
        artesania.setFechaCreacion(Instant.now().toString());
        artesania.setEstado(true);
        artesania.setAprobado(false);

        Artesania entity = artesaniaRepository.save(artesania);

        ArtesaniaModel model = modelMapper.map(entity, ArtesaniaModel.class);
        LOGGER.info("Nueva Artesania {}", model);
        return model;
    }
}
