package com.example.torneosapi.service;

import com.example.torneosapi.dtos.EquipoDTO;
import com.example.torneosapi.models.Equipo;
import com.example.torneosapi.models.Usuario;
import com.example.torneosapi.repository.EquipoRepository;
import com.example.torneosapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private EquipoDTO convertToDTO(Equipo equipo) {
        EquipoDTO dto = new EquipoDTO();
        dto.setId(equipo.getId_equipo());
        dto.setNombre(equipo.getNombre());
        dto.setOrganizador(equipo.getOrganizador().getNombre());
        return dto;
    }

    private Equipo convertToEntity(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setNombre(equipoDTO.getNombre());
        Optional<Usuario> organizador = usuarioRepository.findById(Integer.parseInt(equipoDTO.getOrganizador()));
        organizador.ifPresent(equipo::setOrganizador);
        return equipo;
    }

    public List<EquipoDTO> getAllEquipos() {
        return equipoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public EquipoDTO saveEquipo(EquipoDTO equipoDTO) {
        Equipo equipo = convertToEntity(equipoDTO);
        return convertToDTO(equipoRepository.save(equipo));
    }

    public EquipoDTO getEquipoById(Integer id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        return equipo.map(this::convertToDTO).orElse(null);
    }
}
