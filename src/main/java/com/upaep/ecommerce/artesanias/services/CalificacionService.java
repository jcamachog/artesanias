package com.upaep.ecommerce.artesanias.services;

import com.upaep.ecommerce.artesanias.entities.Artesania;
import com.upaep.ecommerce.artesanias.entities.Artesano;
import com.upaep.ecommerce.artesanias.entities.Calificacion;
import com.upaep.ecommerce.artesanias.entities.Comprador;
import com.upaep.ecommerce.artesanias.models.CalificacionModel;
import com.upaep.ecommerce.artesanias.repositories.ArtesaniaRepository;
import com.upaep.ecommerce.artesanias.repositories.ArtesanoRepository;
import com.upaep.ecommerce.artesanias.repositories.CalificacionRepository;
import com.upaep.ecommerce.artesanias.repositories.CompradorRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CalificacionService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CalificacionService.class);

    private CalificacionRepository calificacionRepository;
    private ArtesanoRepository artesanoRepository;
    private CompradorRepository compradorRepository;
    private ArtesaniaRepository artesaniaRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CalificacionService(CalificacionRepository calificacionRepository, ArtesanoRepository artesanoRepository, CompradorRepository compradorRepository, ArtesaniaRepository artesaniaRepository, ModelMapper modelMapper) {
        this.calificacionRepository = calificacionRepository;
        this.artesanoRepository = artesanoRepository;
        this.compradorRepository = compradorRepository;
        this.artesaniaRepository = artesaniaRepository;
        this.modelMapper = modelMapper;
    }

    public CalificacionModel crearCalificacion(CalificacionModel model) {
        Calificacion calificacion = modelMapper.map(model, Calificacion.class);

        Comprador comprador = compradorRepository.getById(model.getComprador().getId());
        Artesano artesano = artesanoRepository.getById(model.getArtesano().getId());
        Artesania artesania = artesaniaRepository.getById(model.getArtesania().getId());

        Calificacion calificacionExistente = calificacionRepository.findByArtesaniaAndCompradorAndArtesano(artesania, comprador, artesano);

        if(calificacionExistente != null) {
            calificacion.setId(calificacionExistente.getId());
            calificacion.setFechaActualizacion(Instant.now().toString());
        }

        calificacion.setArtesano(artesano);
        calificacion.setComprador(comprador);
        calificacion.setArtesania(artesania);
        calificacion.setFechaCreacion(Instant.now().toString());
        calificacion.setComentario(model.getComentario());

        Calificacion entity = calificacionRepository.save(calificacion);

        CalificacionModel calificacionModel = modelMapper.map(entity, CalificacionModel.class);

        LOGGER.info("Nueva Calificacion {}", calificacionModel);
        return calificacionModel;
    }

}
