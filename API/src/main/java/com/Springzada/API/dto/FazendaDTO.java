package com.Springzada.API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record FazendaDTO( @NotBlank String nome, @NotNull float area) {

}
