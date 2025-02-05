package com.example.teste_tokio_25.mapper;

import com.example.teste_tokio_25.dtos.TransferenciaDTO;
import com.example.teste_tokio_25.model.Transferencia;

public class TransferenciaMapper {

    public static TransferenciaDTO toDTO(Transferencia transferencia) {
        TransferenciaDTO dto = new TransferenciaDTO();
        dto.setId(transferencia.getId());
        dto.setContaOrigem(transferencia.getContaOrigem());
        dto.setContaDestino(transferencia.getContaDestino());
        dto.setValor(transferencia.getValor());
        dto.setTaxa(transferencia.getTaxa());
        dto.setDataTransferencia(transferencia.getDataTransferencia());
        dto.setDataAgendamento(transferencia.getDataAgendamento());
        return dto;
    }

    public static Transferencia toEntity(TransferenciaDTO dto) {
        Transferencia transferencia = new Transferencia();
        transferencia.setId(dto.getId());
        transferencia.setContaOrigem(dto.getContaOrigem());
        transferencia.setContaDestino(dto.getContaDestino());
        transferencia.setValor(dto.getValor());
        transferencia.setTaxa(dto.getTaxa());
        transferencia.setDataTransferencia(dto.getDataTransferencia());
        transferencia.setDataAgendamento(dto.getDataAgendamento());
        return transferencia;
    }
}
