package com.example.teste_tokio_25.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class TransferenciaDTO {
    private Long id;
    private String contaOrigem;
    private String contaDestino;
    private BigDecimal valor;
    private BigDecimal taxa;
    private LocalDate dataTransferencia;
    private LocalDate dataAgendamento;
}
