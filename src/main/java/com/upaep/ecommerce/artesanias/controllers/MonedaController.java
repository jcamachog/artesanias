package com.upaep.ecommerce.artesanias.controllers;

import com.upaep.ecommerce.artesanias.entities.Moneda;
import com.upaep.ecommerce.artesanias.services.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
public class MonedaController {

    private MonedaService service;

    @Autowired
    public MonedaController(MonedaService service) {
        this.service = service;
    }

    @GetMapping("/monedas")
    public List<Moneda> getMonedas() {
        return service.getMonedas();
    }
}
