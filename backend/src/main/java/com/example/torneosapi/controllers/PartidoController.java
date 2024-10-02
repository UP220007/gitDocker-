package com.example.torneosapi.controllers;

import com.example.torneosapi.dtos.PartidoDTO;
import com.example.torneosapi.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<PartidoDTO> getAllPartidos() {
        return partidoService.getAllPartidos();
    }

    @GetMapping("/{id}")
    public PartidoDTO getPartidoById(@PathVariable Integer id) {
        return partidoService.getPartidoById(id);
    }
}
