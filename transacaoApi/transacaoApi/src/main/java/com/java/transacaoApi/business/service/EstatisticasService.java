package com.java.transacaoApi.business.service;

import com.java.transacaoApi.controller.dtos.EstatisticasResponseDto;
import com.java.transacaoApi.controller.dtos.TransacaoRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {
    public final TransacaoService transacaoService;

    public EstatisticasResponseDto calculateEstatisticasTransacoes(Integer intervaloBusca) {

        log.info("Iniciada busca de estatisticas de transações pelo periodo de tempo: " + intervaloBusca);
        List<TransacaoRequestDto> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        if (transacoes.isEmpty()) {
            return new EstatisticasResponseDto(0L,0.0,0.0,0.0,0.0);
        }

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream()
                .mapToDouble(TransacaoRequestDto::valor).summaryStatistics();

        log.info("Estatísticas calculadas com sucesso");
        return new EstatisticasResponseDto(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());
    }
}
