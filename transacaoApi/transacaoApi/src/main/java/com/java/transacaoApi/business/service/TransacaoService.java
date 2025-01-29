package com.java.transacaoApi.business.service;

import com.java.transacaoApi.controller.dtos.TransacaoRequestDto;
import com.java.transacaoApi.infra.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {
    private final List<TransacaoRequestDto> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDto dto) {

        log.info("Iniciada o processamento de gravar transações");

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora posterior à data e hora atual");
            throw new UnprocessableEntity("Data e hora da transação não pode ser posterior à data e hora atual.");
        }
        if (dto.valor() < 0) {
            log.error("Valor não pode ser menor que zero(0)");
            throw new UnprocessableEntity("Valor não pode ser menor que zero(0)");
        }

        listaTransacoes.add(dto);
    }

    public void limparTransacoes(){
        log.info("Iniciada a limpeza das transações");
        listaTransacoes.clear();
    }

    public void buscarTransacoes(){

    }
}
