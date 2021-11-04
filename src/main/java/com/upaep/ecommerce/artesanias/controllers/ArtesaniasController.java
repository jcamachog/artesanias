package com.upaep.ecommerce.artesanias.controllers;

import com.upaep.ecommerce.artesanias.constraints.group.Add;
import com.upaep.ecommerce.artesanias.models.ArtesaniaModel;
import com.upaep.ecommerce.artesanias.services.ArtesaniaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/api")
@RestController
public class ArtesaniasController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArtesaniasController.class);

    private ArtesaniaService artesaniaService;

    @Autowired
    public ArtesaniasController(ArtesaniaService artesaniaService) {
        this.artesaniaService = artesaniaService;
    }

    @PostMapping("/artesanias")
    public ResponseEntity<ArtesaniaModel> registrarArtesania(@RequestBody @Validated({Add.class}) ArtesaniaModel artesaniaModel) {
        LOGGER.info("POST /clientes {}", artesaniaModel);
        ArtesaniaModel model = artesaniaService.crearArtesania(artesaniaModel);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
}
