package com.Springzada.API.dto;

import jakarta.validation.constraints.NotBlank;

public record FazendaDTO( @NotBlank String nome, @NotBlank float area) {

}
