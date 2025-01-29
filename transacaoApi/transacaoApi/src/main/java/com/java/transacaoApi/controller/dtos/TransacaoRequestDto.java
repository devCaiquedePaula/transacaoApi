package com.java.transacaoApi.controller.dtos;

import java.time.OffsetDateTime;

public record TransacaoRequestDto(Double valor, OffsetDateTime dataHora) {
}
