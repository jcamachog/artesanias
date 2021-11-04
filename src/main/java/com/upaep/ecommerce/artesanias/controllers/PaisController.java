package com.upaep.ecommerce.artesanias.controllers;

import com.upaep.ecommerce.artesanias.entities.Pais;
import com.upaep.ecommerce.artesanias.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
public class PaisController {

    private PaisService service;

    @Autowired
    public PaisController(PaisService service) {
        this.service = service;
    }

    @GetMapping("/paises")
    public List<Pais> getPaises() {
        return service.getPaises();
    }

}
