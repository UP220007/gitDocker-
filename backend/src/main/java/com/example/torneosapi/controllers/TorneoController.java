package com.example.torneosapi.controllers;

import com.example.torneosapi.dtos.TorneoDTO;
import com.example.torneosapi.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneos")
public class TorneoController {

    @Autowired
    private TorneoService torneoService;

    @GetMapping
    public List<TorneoDTO> getAllTorneos() {
        return torneoService.getAllTorneos();
    }

    @GetMapping("/{id}")
    public TorneoDTO getTorneoById(@PathVariable Integer id) {
        return torneoService.getTorneoById(id);
    }
}
