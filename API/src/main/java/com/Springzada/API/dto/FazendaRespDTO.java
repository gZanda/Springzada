package com.Springzada.API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record FazendaRespDTO( @NotBlank String nome, @NotNull float area) {
    
}
