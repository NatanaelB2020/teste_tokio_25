package com.example.teste_tokio_25.service;

import com.example.teste_tokio_25.model.Transferencia;
import com.example.teste_tokio_25.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferenciaService {

    private final TransferenciaRepository repository;

    public TransferenciaService(TransferenciaRepository repository) {
        this.repository = repository;
    }

    public Transferencia agendarTransferencia(Transferencia transferencia) {
        LocalDate hoje = LocalDate.now();
        long diasEntre = ChronoUnit.DAYS.between(hoje, transferencia.getDataTransferencia());

        BigDecimal taxa = calcularTaxa(transferencia.getValor(), diasEntre);
        if (taxa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Não há taxa aplicável para a transferência.");
        }

        transferencia.setTaxa(taxa);
        transferencia.setDataAgendamento(hoje);
        return repository.save(transferencia);
    }

    public List<Transferencia> listarTransferencias() {
        return repository.findAll();
    }

    private BigDecimal calcularTaxa(BigDecimal valor, long dias) {
        if (dias == 0)
            return valor.multiply(BigDecimal.valueOf(0.025)).add(BigDecimal.valueOf(3));
        if (dias >= 1 && dias <= 10)
            return BigDecimal.valueOf(12);
        if (dias >= 11 && dias <= 20)
            return valor.multiply(BigDecimal.valueOf(0.082));
        if (dias >= 21 && dias <= 30)
            return valor.multiply(BigDecimal.valueOf(0.069));
        if (dias >= 31 && dias <= 40)
            return valor.multiply(BigDecimal.valueOf(0.047));
        if (dias >= 41 && dias <= 50)
            return valor.multiply(BigDecimal.valueOf(0.017));
        return BigDecimal.valueOf(-1); // Indica erro
    }
}
