package com.upaep.ecommerce.artesanias.controllers;

import com.upaep.ecommerce.artesanias.constraints.group.Add;
import com.upaep.ecommerce.artesanias.models.ArtesanoModel;
import com.upaep.ecommerce.artesanias.services.ArtesanoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;


@RequestMapping(value = "/api")
@RestController
public class ArtesanoController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArtesanoController.class);

    private ArtesanoService artesanoService;

    @Autowired
    public ArtesanoController(ArtesanoService artesanoService) {
        this.artesanoService = artesanoService;
    }

    @GetMapping(value = "/artesanos", params = {"clave"})
    public ResponseEntity<ArtesanoModel> encontrarArtesanoPorClave(@RequestParam("clave") String clave) {
        ArtesanoModel model = artesanoService.obtenerPorClave(clave);
        if(model == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(model);
    }

    @PostMapping("/artesanos")
    public ResponseEntity<ArtesanoModel> registrarArtesano(@RequestBody @Validated({Add.class}) ArtesanoModel artesanoModel) {
        LOGGER.info("POST /artesanos {}", artesanoModel);
        ArtesanoModel model = artesanoService.crearArtesano(artesanoModel);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

}
