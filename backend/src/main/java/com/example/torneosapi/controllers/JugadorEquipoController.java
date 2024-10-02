package com.example.torneosapi.controllers;

import com.example.torneosapi.dtos.JugadorEquipoDTO;
import com.example.torneosapi.service.JugadorEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadorEquipos")
public class JugadorEquipoController {

    @Autowired
    private JugadorEquipoService jugadorEquipoService;

    @GetMapping
    public List<JugadorEquipoDTO> getAllJugadorEquipos() {
        return jugadorEquipoService.getAllJugadorEquipos();
    }

    @PostMapping
    public JugadorEquipoDTO createJugadorEquipo(@RequestBody JugadorEquipoDTO jugadorEquipoDTO) {
        return jugadorEquipoService.saveJugadorEquipo(jugadorEquipoDTO);
    }

    @GetMapping("/{id}")
    public JugadorEquipoDTO getJugadorEquipoById(@PathVariable Integer id) {
        return jugadorEquipoService.getJugadorEquipoById(id);
    }
}

