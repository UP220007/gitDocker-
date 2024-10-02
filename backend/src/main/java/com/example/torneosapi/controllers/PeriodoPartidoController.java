package com.example.torneosapi.controllers;

import com.example.torneosapi.dtos.PeriodoPartidoDTO;
import com.example.torneosapi.service.PeriodoPartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodos")
public class PeriodoPartidoController {

    @Autowired
    private PeriodoPartidoService periodoPartidoService;

    @GetMapping
    public List<PeriodoPartidoDTO> getAllPeriodos() {
        return periodoPartidoService.getAllPeriodos();
    }

    @GetMapping("/{idPartido}/{numeroPeriodo}")
    public PeriodoPartidoDTO getPeriodoById(@PathVariable Integer idPartido, @PathVariable Integer numeroPeriodo) {
        return periodoPartidoService.getPeriodoById(idPartido, numeroPeriodo);
    }
}
