package com.Springzada.API.controller;

import com.Springzada.API.service.FazendaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import com.Springzada.API.dto.FazendaDTO;
import com.Springzada.API.exceptions.CustomException;

@AllArgsConstructor
@RestController
@RequestMapping("/fazenda")
public class FazendaController {

    // Injection
    private FazendaService service;

    // POST fazenda
    @PostMapping("/create")
    public ResponseEntity<FazendaDTO> saveFazenda(@RequestBody @Valid FazendaDTO fazendaInput) {

        var fazenda = service.saveFazenda(fazendaInput);
        if( fazenda == null ){
            throw new CustomException("This Fazenda Name Already Exists");
        }
        return ResponseEntity.ok(fazenda);

    }

    // GET ALL fazendas
    @GetMapping("/all")
    public ResponseEntity<List<FazendaDTO>> getFazendas() {

        return ResponseEntity.ok(service.getFazendas());

    }

    // GET ONE fazenda ( by name )
    @GetMapping("/find/{nome}")
    public ResponseEntity<FazendaDTO> getFazenda(@PathVariable String nome) {

        var fazenda = service.getFazenda(nome);
        return fazenda == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(fazenda);

    }

    // PUT fazenda ( by name )
    @PutMapping("/edit/{nome}")
    public ResponseEntity<FazendaDTO> putFazenda(@PathVariable String nome, @RequestBody @Valid FazendaDTO fazendaRecord) {

        var fazenda = service.editFazenda(nome, fazendaRecord);
        return fazenda == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(fazenda);

    }

    // DELETE fazenda ( by name )
    @DeleteMapping("/delete/{nome}")
    public ResponseEntity<Object> deleteFazenda(@PathVariable String nome) {

        var status = service.deleteFazenda(nome);
        return status == false ? ResponseEntity.notFound().build() : ResponseEntity.ok("Deleted successfully!");

    }
}
