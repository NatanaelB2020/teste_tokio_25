package com.example.teste_tokio_25.controller;

import com.example.teste_tokio_25.dtos.TransferenciaDTO;
import com.example.teste_tokio_25.mapper.TransferenciaMapper;
import com.example.teste_tokio_25.model.Transferencia;
import com.example.teste_tokio_25.service.TransferenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService service;

    public TransferenciaController(TransferenciaService service) {
        this.service = service;
    }

    @PostMapping("/agendar")
    public ResponseEntity<TransferenciaDTO> agendar(@RequestBody TransferenciaDTO dto) {
        try {
            Transferencia transferencia = TransferenciaMapper.toEntity(dto);
            Transferencia agendada = service.agendarTransferencia(transferencia);
            return ResponseEntity.ok(TransferenciaMapper.toDTO(agendada));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/extrato")
    public List<TransferenciaDTO> listar() {
        return service.listarTransferencias()
                .stream()
                .map(TransferenciaMapper::toDTO)
                .collect(Collectors.toList()); // Correção aqui
    }

}
