package com.Springzada.API.controller;

import com.Springzada.API.service.FazendaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.Springzada.API.dto.FazendaDTO;
import com.Springzada.API.model.FazendaModel;


@RestController
public class FazendaController {
    
    @Autowired
    private FazendaService service;

    // Create a new Fazenda --> DTO
    @PostMapping("/fazenda/create")
    public ResponseEntity<FazendaDTO> saveFazenda(@RequestBody @Valid FazendaDTO fazendaInput){

        return ResponseEntity.created(null).body(service.saveFazenda(fazendaInput));
    
    }

    // Get all Fazendas --> DTO
    @GetMapping("/fazenda/all")
    public ResponseEntity<List<FazendaDTO>> getFazendas(){

        return ResponseEntity.ok(service.getFazendas());
        
    } 

    // Get one Fazenda by name --> DTO
    @GetMapping("/fazenda/find/{nome}")
    public ResponseEntity<FazendaDTO> getFazenda(@PathVariable String nome){

        var fazenda = service.getFazenda(nome);
        return fazenda == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(fazenda);

    }

    // Edit one Fazenda by name
    @PutMapping("/fazenda/edit/{nome}")
    public ResponseEntity<FazendaModel> putFazenda(@PathVariable String nome, @RequestBody @Valid FazendaDTO fazendaRecord){
        
        var fazenda = service.editFazenda(nome, fazendaRecord);
        return fazenda == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(fazenda);

    }

    // Delete one Fazenda by name
    @DeleteMapping("/fazenda/delete/{nome}")
    public ResponseEntity<Object> deleteFazenda(@PathVariable String nome){

        var status = service.deleteFazenda(nome);
        return status == false ? ResponseEntity.notFound().build() : ResponseEntity.ok("Deleted successfully!");

    }

}