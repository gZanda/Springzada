package com.Springzada.API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="FAZENDA")
public class FazendaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private float area;
    
    // Constructors

    public FazendaModel() {
    }

    public FazendaModel(int id, String nome, Long area) {
        this.id = id;
        this.nome = nome;
        this.area = area;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getArea() {
        return area;
    }
    public void setArea(float area) {
        this.area = area;
    }


}
