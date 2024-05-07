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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.Springzada.API.dto.FazendaRecord;
import com.Springzada.API.model.FazendaModel;


@RestController
public class FazendaController {
    
    @Autowired
    private FazendaService service;

    // Create a new Fazenda
    @PostMapping("/fazenda/create")
    public ResponseEntity<FazendaModel> saveFazenda(@RequestBody @Valid FazendaRecord fazendaRecord){

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveFazenda(fazendaRecord));
    
    }

    // Get all Fazendas
    @GetMapping("/fazenda/all")
    public ResponseEntity<List<FazendaModel>> getFazendas(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getFazendas());
        
    } 

    // Get one Fazenda by name
    @GetMapping("/fazenda/find/{nome}")
    public ResponseEntity<FazendaModel> getFazenda(@PathVariable String nome){

        var fazenda = service.getFazenda(nome);

        if(fazenda == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(fazenda);

    }

    // Edit one Fazenda by name
    @PutMapping("/fazenda/edit/{nome}")
    public ResponseEntity<FazendaModel> putFazenda(@PathVariable String nome, @RequestBody @Valid FazendaRecord fazendaRecord){
        
        var fazenda = service.editFazenda(nome, fazendaRecord);

        if(fazenda == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(fazenda);

    }

    // Delete one Fazenda by name
    @DeleteMapping("/fazenda/delete/{nome}")
    public ResponseEntity<Object> deleteFazenda(@PathVariable String nome){

        var status =  service.deleteFazenda(nome);
        
        if(status){
            return ResponseEntity.status(HttpStatus.OK).body("Fazenda deleted successfully.");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

    }

}
