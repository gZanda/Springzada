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
import org.springframework.http.HttpStatus;

@RestController
public class FazendaController {

    @Autowired
    private FazendaService service;

    @PostMapping("/fazenda/create")
    public ResponseEntity<FazendaDTO> saveFazenda(@RequestBody @Valid FazendaDTO fazendaInput) {
        try {
            return ResponseEntity.created(null).body(service.saveFazenda(fazendaInput));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/fazenda/all")
    public ResponseEntity<List<FazendaDTO>> getFazendas() {
        try {
            return ResponseEntity.ok(service.getFazendas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/fazenda/find/{nome}")
    public ResponseEntity<FazendaDTO> getFazenda(@PathVariable String nome) {
        try {
            var fazenda = service.getFazenda(nome);
            return fazenda == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(fazenda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/fazenda/edit/{nome}")
    public ResponseEntity<FazendaDTO> putFazenda(@PathVariable String nome, @RequestBody @Valid FazendaDTO fazendaRecord) {
        try {
            var fazenda = service.editFazenda(nome, fazendaRecord);
            return fazenda == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(fazenda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/fazenda/delete/{nome}")
    public ResponseEntity<Object> deleteFazenda(@PathVariable String nome) {
        try {
            var status = service.deleteFazenda(nome);
            return status == false ? ResponseEntity.notFound().build() : ResponseEntity.ok("Deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
