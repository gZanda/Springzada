package com.Springzada.API.controller;

import com.Springzada.API.service.FazendaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.Springzada.API.dto.FazendaRecord;
import com.Springzada.API.model.FazendaModel;


@RestController
public class FazendaController {
    
    @Autowired
    private FazendaService service;

    // Create a new Fazenda
    @PostMapping("/newFazenda")
    public ResponseEntity<FazendaModel> saveFazenda(@RequestBody @Valid FazendaRecord fazendaRecord){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveFazenda(fazendaRecord));
    
    }

    // Get all Fazendas
    @GetMapping("/fazendas")
    public ResponseEntity<List<FazendaModel>> getFazendas(){

        return ResponseEntity.ok(service.getFazendas());
        
    } 

    // Get one Fazenda by name
    @GetMapping("/fazenda/{nome}")
    public ResponseEntity<FazendaModel> getFazenda(@PathVariable String nome){

        var fazenda = service.getFazenda(nome);

        if(fazenda == null){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(fazenda);

    }

}
