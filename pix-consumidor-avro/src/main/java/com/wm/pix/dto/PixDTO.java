package com.wm.pix.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PixDTO {
    private String chaveOrigem;
    private String chaveDestino;
    private Double valor;
    private LocalDateTime dataTransferencia;
    private PixStatus status;
}
