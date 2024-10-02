package com.example.torneosapi.service;

import com.example.torneosapi.dtos.JugadorEquipoDTO;
import com.example.torneosapi.models.Equipo;
import com.example.torneosapi.models.JugadorEquipo;
import com.example.torneosapi.models.Usuario;
import com.example.torneosapi.repository.EquipoRepository;
import com.example.torneosapi.repository.JugadorEquipoRepository;
import com.example.torneosapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorEquipoService {

    @Autowired
    private JugadorEquipoRepository jugadorEquipoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    private JugadorEquipoDTO convertToDTO(JugadorEquipo jugadorEquipo) {
        JugadorEquipoDTO dto = new JugadorEquipoDTO();
        dto.setId(jugadorEquipo.getId());
        dto.setJugadorNombre(jugadorEquipo.getJugador().getNombre());
        dto.setEquipoNombre(jugadorEquipo.getEquipo().getNombre());
        return dto;
    }

    private JugadorEquipo convertToEntity(JugadorEquipoDTO jugadorEquipoDTO) {
        JugadorEquipo jugadorEquipo = new JugadorEquipo();
        Optional<Usuario> jugador = usuarioRepository.findById(Integer.parseInt(jugadorEquipoDTO.getJugadorNombre()));
        jugador.ifPresent(jugadorEquipo::setJugador);

        Optional<Equipo> equipo = equipoRepository.findById(Integer.parseInt(jugadorEquipoDTO.getEquipoNombre()));
        equipo.ifPresent(jugadorEquipo::setEquipo);
        
        return jugadorEquipo;
    }

    public List<JugadorEquipoDTO> getAllJugadorEquipos() {
        return jugadorEquipoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public JugadorEquipoDTO saveJugadorEquipo(JugadorEquipoDTO jugadorEquipoDTO) {
        JugadorEquipo jugadorEquipo = convertToEntity(jugadorEquipoDTO);
        return convertToDTO(jugadorEquipoRepository.save(jugadorEquipo));
    }

    public JugadorEquipoDTO getJugadorEquipoById(Integer id) {
        Optional<JugadorEquipo> jugadorEquipo = jugadorEquipoRepository.findById(id);
        return jugadorEquipo.map(this::convertToDTO).orElse(null);
    }
}
