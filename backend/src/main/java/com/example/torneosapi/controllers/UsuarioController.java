package com.example.torneosapi.controllers;

import com.example.torneosapi.dtos.UsuarioDTO;
import com.example.torneosapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.saveUsuario(usuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }
}
