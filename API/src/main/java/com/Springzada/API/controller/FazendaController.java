package com.Springzada.API.controller;

import com.Springzada.API.service.FazendaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @PostMapping("/fazenda")
    public ResponseEntity<FazendaModel> saveFazenda(@RequestBody @Valid FazendaRecord fazendaRecord){
        FazendaModel savedFazenda = service.saveFazenda(fazendaRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFazenda);
    }

    // Read all Fazendas
    @GetMapping("/fazendas")
    public ResponseEntity<List<FazendaModel>> getFazendas(){
        return ResponseEntity.ok(service.getFazendas());
    } 
}
