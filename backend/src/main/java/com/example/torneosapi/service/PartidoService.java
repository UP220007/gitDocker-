package com.example.torneosapi.service;

import com.example.torneosapi.dtos.PartidoDTO;
import com.example.torneosapi.models.Partido;
import com.example.torneosapi.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    private PartidoDTO convertToDTO(Partido partido) {
        PartidoDTO dto = new PartidoDTO();
        dto.setIdPartido(partido.getIdPartido());
        dto.setTorneoNombre(partido.getTorneo().getNombre());
        dto.setEquipo1Nombre(partido.getEquipo1().getNombre());
        dto.setEquipo2Nombre(partido.getEquipo2().getNombre());
        dto.setFecha(partido.getFecha());
        dto.setResultado(partido.getResultado());
        return dto;
    }

    public List<PartidoDTO> getAllPartidos() {
        return partidoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PartidoDTO getPartidoById(Integer id) {
        Optional<Partido> partido = partidoRepository.findById(id);
        return partido.map(this::convertToDTO).orElse(null);
    }
}
