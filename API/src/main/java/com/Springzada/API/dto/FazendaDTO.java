package com.Springzada.API.dto;

import jakarta.validation.constraints.NotNull;

public record FazendaDTO( @NotNull String nome, @NotNull String proprietario, @NotNull float area, String image ) {

}
