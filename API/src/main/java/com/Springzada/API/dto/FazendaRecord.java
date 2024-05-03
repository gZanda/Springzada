package com.Springzada.API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record FazendaRecord( @NotBlank String nome, @NotNull float area) {
    
}
