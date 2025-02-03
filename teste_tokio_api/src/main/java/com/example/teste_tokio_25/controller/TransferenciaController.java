package com.example.teste_tokio_25.controller;

import com.example.teste_tokio_25.model.Transferencia;
import com.example.teste_tokio_25.service.TransferenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService service;

    public TransferenciaController(TransferenciaService service) {
        this.service = service;
    }

    @PostMapping("/agendar")
    public ResponseEntity<Transferencia> agendar(@RequestBody Transferencia transferencia) {
        try {
            Transferencia agendada = service.agendarTransferencia(transferencia);
            return ResponseEntity.ok(agendada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/extrato")
    public List<Transferencia> listar() {
        return service.listarTransferencias();
    }
}
