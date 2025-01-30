package com.java.transacaoApi.controller.dtos;

public record EstatisticasResponseDto(Long count
        , Double sum
        , Double avg
        , Double min
        , Double max) {
}
