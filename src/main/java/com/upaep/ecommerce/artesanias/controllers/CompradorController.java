package com.upaep.ecommerce.artesanias.controllers;

import com.upaep.ecommerce.artesanias.constraints.group.Add;
import com.upaep.ecommerce.artesanias.models.CompradorModel;
import com.upaep.ecommerce.artesanias.services.CompradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(value = "/api")
@RestController
public class CompradorController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CompradorController.class);

    private CompradorService compradorService;

    @Autowired
    public CompradorController(CompradorService compradorService) {
        this.compradorService = compradorService;
    }

    @PostMapping("/compradores")
    public ResponseEntity<CompradorModel> registrarComprador(@RequestBody @Validated({Add.class}) CompradorModel compradorModel) {
        LOGGER.info("POST /compradores {}", compradorModel);
        CompradorModel model = compradorService.crearComprador(compradorModel);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
}
