package com.Springzada.API.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="FAZENDAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FazendaModel{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private String proprietario;

    @NotNull
    @Column(nullable = false)
    private float area;

    @Column(nullable = true)
    private String image;

}
