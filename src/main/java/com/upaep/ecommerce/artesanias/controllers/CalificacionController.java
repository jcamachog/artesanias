package com.upaep.ecommerce.artesanias.controllers;

import com.upaep.ecommerce.artesanias.constraints.group.Add;
import com.upaep.ecommerce.artesanias.models.CalificacionModel;
import com.upaep.ecommerce.artesanias.services.CalificacionService;
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

@RequestMapping(value = "/api")
@RestController
public class CalificacionController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CalificacionController.class);

    private CalificacionService calificacionService;

    @Autowired
    public CalificacionController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @PostMapping("/calificaciones")
    public ResponseEntity<CalificacionModel> registrarCalificacion(@RequestBody @Validated({Add.class}) CalificacionModel calificacionModel) {
        LOGGER.info("POST /calificaciones {}", calificacionModel);
        CalificacionModel model = calificacionService.crearCalificacion(calificacionModel);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

}
