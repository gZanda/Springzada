package com.Springzada.API.controller;

import com.Springzada.API.repository.FazendaRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Springzada.API.dto.FazendaRecord;
import com.Springzada.API.model.FazendaModel;
import org.springframework.beans.BeanUtils;

@RestController
public class FazendaController {
    
    @Autowired
    private FazendaRepository repository;

    @PostMapping("/fazenda")
    public ResponseEntity<FazendaModel> saveFazenda(@RequestBody @Valid FazendaRecord fazenda){
        var FazendaModel = new FazendaModel();
        BeanUtils.copyProperties(fazenda, FazendaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(FazendaModel));
    }

}
