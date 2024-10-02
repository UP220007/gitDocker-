package com.example.torneosapi.controllers;

import com.example.torneosapi.dtos.EquipoDTO;
import com.example.torneosapi.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<EquipoDTO> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    @PostMapping
    public EquipoDTO createEquipo(@RequestBody EquipoDTO equipoDTO) {
        return equipoService.saveEquipo(equipoDTO);
    }

    @GetMapping("/{id}")
    public EquipoDTO getEquipoById(@PathVariable Integer id) {
        return equipoService.getEquipoById(id);
    }
}
