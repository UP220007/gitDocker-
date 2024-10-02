package com.example.torneosapi.service;

import com.example.torneosapi.dtos.TorneoDTO;
import com.example.torneosapi.models.Torneo;
import com.example.torneosapi.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TorneoService {

    @Autowired
    private TorneoRepository torneoRepository;

    private TorneoDTO convertToDTO(Torneo torneo) {
        TorneoDTO dto = new TorneoDTO();
        dto.setIdTorneo(torneo.getIdTorneo());
        dto.setNombre(torneo.getNombre());
        dto.setFechaInicio(torneo.getFechaInicio());
        dto.setFechaFin(torneo.getFechaFin());
        dto.setOrganizadorNombre(torneo.getOrganizador().getNombre());
        return dto;
    }

    public List<TorneoDTO> getAllTorneos() {
        return torneoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TorneoDTO getTorneoById(Integer id) {
        Optional<Torneo> torneo = torneoRepository.findById(id);
        return torneo.map(this::convertToDTO).orElse(null);
    }
}
