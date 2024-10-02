package com.example.torneosapi.service;

import com.example.torneosapi.dtos.PeriodoPartidoDTO;
import com.example.torneosapi.models.PeriodoPartido;
import com.example.torneosapi.models.PeriodoPartidoId;
import com.example.torneosapi.repository.PeriodoPartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeriodoPartidoService {

    @Autowired
    private PeriodoPartidoRepository periodoPartidoRepository;

    private PeriodoPartidoDTO convertToDTO(PeriodoPartido periodo) {
        PeriodoPartidoDTO dto = new PeriodoPartidoDTO();
        dto.setIdPartido(periodo.getId().getIdPartido());
        dto.setNumeroPeriodo(periodo.getId().getNumeroPeriodo());
        dto.setDuracionMinutos(periodo.getDuracionMinutos());
        return dto;
    }

    public List<PeriodoPartidoDTO> getAllPeriodos() {
        return periodoPartidoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PeriodoPartidoDTO getPeriodoById(Integer idPartido, Integer numeroPeriodo) {
        PeriodoPartidoId id = new PeriodoPartidoId();
        id.setIdPartido(idPartido);
        id.setNumeroPeriodo(numeroPeriodo);
        Optional<PeriodoPartido> periodo = periodoPartidoRepository.findById(id);
        return periodo.map(this::convertToDTO).orElse(null);
    }
}
