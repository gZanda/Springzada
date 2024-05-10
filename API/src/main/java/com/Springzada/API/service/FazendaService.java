package com.Springzada.API.service;

import org.springframework.stereotype.Service;
import com.Springzada.API.model.FazendaModel;
import com.Springzada.API.repository.FazendaRepository;
import lombok.AllArgsConstructor;
import com.Springzada.API.dto.FazendaDTO;
import org.springframework.beans.BeanUtils;
import java.util.List;

@AllArgsConstructor
@Service
public class FazendaService {

    // Injection
    private FazendaRepository repository;

    // Create a new Fazenda
    public FazendaDTO saveFazenda(FazendaDTO fazenda) {

        
        if (repository.findByNome(fazenda.nome()) != null) {
            return null;
        }

        var fazendaModel = new FazendaModel();
        BeanUtils.copyProperties(fazenda, fazendaModel);
        repository.save(fazendaModel);
        return new FazendaDTO( fazenda.nome(), fazenda.proprietario(), fazenda.area(), fazenda.image());

    }

    // Get all Fazendas
    public List<FazendaDTO> getFazendas() {

        return repository.findAll().stream().map(fazenda -> new FazendaDTO(fazenda.getNome(), fazenda.getProprietario(), fazenda.getArea(), fazenda.getImage())).toList();

    }

    // Get one Fazenda by name
    public FazendaDTO getFazenda(String nome) {

        var fazendaModel = repository.findByNome(nome);

        return fazendaModel == null ? null : new FazendaDTO(fazendaModel.getNome(), fazendaModel.getProprietario(), fazendaModel.getArea(), fazendaModel.getImage());
        
    }

    // Edit one Fazenda by name
    public FazendaDTO editFazenda(String nome, FazendaDTO fazenda) {

        var fazendaModel = repository.findByNome(nome);

        if (fazendaModel == null) {
            return null;
        }

        BeanUtils.copyProperties(fazenda, fazendaModel);
        repository.save(fazendaModel);
        return new FazendaDTO(fazendaModel.getNome(), fazendaModel.getProprietario(), fazendaModel.getArea(), fazendaModel.getImage());
    }

    // Delete one Fazenda by name
    public Boolean deleteFazenda(String nome) {

        var fazendaModel = repository.findByNome(nome);

        if (fazendaModel == null) {
            return false;
        }

        repository.delete(fazendaModel);
        return true;

    }

}
